using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace database_assignment
{

    public class dbConnection
    {
        private static string cs = "data source=.\\SQLEXPRESS; database = assignment2; integrated security = SSPI";
        private static SqlConnection myConnection = new SqlConnection(cs);
        private static SqlCommand myCommand = myConnection.CreateCommand();
     
        public void getTotalBalanceCountry(string country,int date)
        {
                // Open connection
                myConnection.Open();

                //SqlTransaction transaction = myConnection.BeginTransaction(IsolationLevel.ReadCommitted);

                myCommand.CommandText = "set transaction isolation level read committed select countryName, sum(balance) as 'Total balance' from main.country c join main.person on c.countryId = person.countryId where year(registered) = " + date + " and countryName = '" + country + "' group by countryName commit";
                //myCommand.Transaction = transaction;
                

                SqlDataReader myReader = myCommand.ExecuteReader();
                //transaction.Commit();

                while (myReader.Read())
                {
                    Console.WriteLine("{0, -33} {1,20}", myReader["countryName"], myReader["Total balance"]);
                }
                myConnection.Close();
                myReader.Close();
        }

        public void getLastStats()
        {
                // Open connection
                myConnection.Open();

                //SqlTransaction transaction = myConnection.BeginTransaction(IsolationLevel.ReadCommitted);

                myCommand.CommandText = "set transaction isolation level read committed select top 1 totalPeople,bracket1,bracket2,bracket3 from main.stats order by dateCollected desc commit";
                //myCommand.Transaction = transaction;

                SqlDataReader myReader = myCommand.ExecuteReader();
               
                //transaction.Commit();
                
                while (myReader.Read())
                {
                    Console.WriteLine("{0, -5} {1,23} {2, 20} {3,20}", myReader["totalPeople"], myReader["bracket1"], myReader["bracket2"], myReader["bracket3"]);
                }
                myConnection.Close();
                myReader.Close();
        }
     
        public int getMainRun(string inputPath)
        {       
                // Open connection
                myConnection.Open();
                //SqlTransaction transaction = myConnection.BeginTransaction(IsolationLevel.RepeatableRead);

                myCommand = new SqlCommand("main.mainRun", myConnection);
                myCommand.CommandType = System.Data.CommandType.StoredProcedure;
                
                myCommand.Parameters.AddWithValue("@path",inputPath);
                //myCommand.Transaction = transaction;

                myConnection.InfoMessage += connection_InfoMessage;
                var result = myCommand.ExecuteNonQuery();

            //transaction.Rollback();

            myConnection.Close();
 
            return result;
        }

        static void connection_InfoMessage(object sender, SqlInfoMessageEventArgs e)
        {
            // this gets the print statements
            var outputFromStoredProcedure = e.Message;
        }

    }
}
