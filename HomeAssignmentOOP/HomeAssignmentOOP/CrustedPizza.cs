namespace HomeAssignmentOOP
{
    public class CrustedPizza : Pizza
    {
        string crust;

        public CrustedPizza() : base()
        {
            crust = string.Empty;
        }

        public CrustedPizza(string cSize, string cSauce,string cCrust, Toppings[] ctoppings) : base(cSize,cSauce, ctoppings)
        {
            crust = cCrust;
        }
        //this method calculated the total price of the pizza and adds up the crust selected to the price
        public override double getPrice()
        {
                double pizzaWithNoCrust = base.getPrice();
                double cPrice = 0;
                if (crust == "regular")
                {
                    cPrice = 0;
                }
                else if (crust == "mozzarella")
                {
                    cPrice = 2;
                }
                else if (crust == "spice cheese")
                {
                    cPrice = 4;
                }
                double pizzaPlusCrust = cPrice + pizzaWithNoCrust;
                return pizzaPlusCrust;
            }
        }
}
