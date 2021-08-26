use assignment2;
GO

--Q1
create or alter procedure main.loadJSON
as
begin
	set nocount on;
	declare @PersonDetails varchar(max);

	select @PersonDetails = BulkColumn
	from openrowset(bulk 'C:\Users\user\Desktop\Database Assignment\persondata.json',single_blob) json

	if(isjson(@PersonDetails) = 1)
		begin
			insert into main.jsontable
			select * 
			from openjson(@PersonDetails,'$.PersonDetails.Person')
			with
			(
				dateloaded datetime,
				name varchar(50) '$.first_name',
				surname varchar(50) '$.last_name',
				email varchar(50) '$.email',
				age varchar(50) '$.age',
				balance varchar(50) '$.balance',
				country varchar(50) '$.country',
				registered varchar(50) '$.registered'
			)

			update main.jsontable
			set dateloaded = SYSDATETIMEOFFSET();

		end
	else
		begin
			print 'Json file is empty';
		end
end
go

exec main.loadJSON
go

--Q2

create or alter trigger main.afterParsing
on main.jsontable after insert
as 
begin
	set nocount on;
	declare @msg nvarchar(1000);
	begin try
		insert into main.country(countryName)
		select distinct country
		from main.jsontable
		where country is not null

		insert into main.person(name,surname,email,birthYear,balance,registered,countryId)
		select jt.name,jt.surname,jt.email,
			   year(DATEADD(year,(- (cast(jt.age as int))),getdate())),
			   cast(jt.balance as numeric(9,2)),cast(jt.registered as date),
			   (select countryId from main.country where countryName = jt.country)
		from main.jsontable jt join main.country c 
			on  jt.country = c.countryName
	end try
	begin catch
		set @msg = ERROR_MESSAGE();
		throw 50001,@msg,16;
	end catch
end

/*
delete from main.jsontable
delete from main.person
delete from main.country
delete from main.stats

select * from main.jsontable
select * from main.person
select countryName from main.country
select * from main.stats
*/
go

--Q3
create or alter procedure main.generateStatistics
as
begin
	declare @minYear numeric(4,0);
	declare @maxYear numeric(4,0);

	declare @bracket1 numeric(10,2);
	declare @bracket2 numeric(10,2);
	declare @bracket3 numeric(10,2);

	declare @bucketSize numeric(2,0);

	set @minYear = (select min(birthYear) from main.person)
	set @maxYear = (select max(birthYear) from main.person)
	set @bucketSize = ((select count(distinct birthYear) from main.person) / 3)

	--bracket 1
	set @bracket1 = (select sum(balance)
					 from main.person
					 where birthYear between (@minYear) and (@minYear + @bucketSize))

	--bracket 2
	set @bracket2 = (select sum(balance)
					 from main.person
					 where birthYear between (@minYear + @bucketSize + 1) 
					 and (@minYear + (@bucketSize * 2) + 1))

	--bracket 3
	set @bracket3 = (select sum(balance)
					 from main.person
					 where birthYear between (@minYear + (@bucketSize * 2) + 2)
					 and (@maxYear))

	insert into main.[stats](dateCollected,totalPeople,bracket1,bracket2,bracket3)
	values
	(
		SYSDATETIMEOFFSET(),
		(select COUNT(*) from main.person),
		@bracket1,@bracket2,@bracket3
	)
end
go

set transaction isolation level repeatable read
begin transaction 
	exec main.generateStatistics
	select * from main.[stats]
commit
go

--delete from main.[stats]

--Q4

create or alter procedure main.mainRun
as 
begin
	declare @msg nvarchar(1000);
	begin try
		exec main.loadJSON
		exec main.generateStatistics
	end try
	begin catch
		set @msg = ERROR_MESSAGE();
		throw 50001,@msg,16;
	end catch
end
go

exec main.mainRun
go

--Q5

alter procedure main.mainRun(@path varchar(2000))
as 
begin
	set nocount on;
	set transaction isolation level repeatable read
	begin transaction
		declare @msg nvarchar(1000);
		begin try
			declare @query varchar(max);
			set @query = 'declare @PersonDetails varchar(max);

						select @PersonDetails = BulkColumn
						from openrowset(bulk '''+@path+''',single_blob) json

						if(isjson(@PersonDetails) = 1)
							begin
								insert into main.jsontable
								select * 
								from openjson(@PersonDetails,''$.PersonDetails.Person'')
								with
								(
									dateloaded datetime,
									name varchar(50) ''$.first_name'',
									surname varchar(50) ''$.last_name'',
									email varchar(50) ''$.email'',
									age varchar(50) ''$.age'',
									balance varchar(50) ''$.balance'',
									country varchar(50) ''$.country'',
									registered varchar(50) ''$.registered''
								)

								update main.jsontable
								set dateloaded = SYSDATETIMEOFFSET();
								print 1;
							end'

				exec(@query)

				exec main.generateStatistics
		commit tran
	end try
	begin catch
		rollback tran
		set @msg = ERROR_MESSAGE();
		throw 50001,@msg,16;
	end catch
end

--Testing Main Procedure main.mainRun
delete from main.jsontable
delete from main.person
delete from main.country

exec main.mainRun 'C:\Users\user\Desktop\Database Assignment\persondata.json'

select * from main.jsontable
select * from main.person
select * from main.country

--Q7
--query with inner join
select [name] + ' ' +  surname as 'Full name',countryName as 'Country'
from main.person p join main.country c
	 on p.countryId = c.countryId

--Create a clustered index
create clustered index ix_fullname
on main.person([name],surname)

--Create a nonclustered index
create nonclustered index i_fullname
on main.person([name],surname)

--Q8
--Report 1

select cast(birthYear as varchar(50)) as 'BirthYear', cast((AVG(balance)) as varchar(50)) as 'avgBalance'
from main.person
group by birthYear
for json auto

--Report 2

select dateCollected,totalPeople,bracket1,bracket2,bracket3
from main.stats
for xml path('stats'),root('row')