public class BookingEngine {
    public static void main(String[] args) {

        Tour operaHouse = new Tour("OH", "Opera House Tour", 300);
        Tour bridgeClimb = new Tour("BC", "Sydney Bridge Climb", 110);
        Tour skyTower = new Tour("SK", "Sydney Sky Tower", 30);


        PromotionManager promotionalRules = new PromotionManager();
        ShoppingCart cart = new ShoppingCart(promotionalRules);

        //add the tour type (ie bridge climb etc) to the list of tours
        cart.addTourType(operaHouse);
        cart.addTourType(bridgeClimb);
        cart.addTourType(skyTower);

        //Add these tours to the cart, to be purchased
        cart.add("OH");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");

        System.out.println(operaHouse);
        System.out.println(bridgeClimb);
        System.out.println(skyTower);

        //Print out the cart total after promotions have been applied
        System.out.println(cart.getTotal());


    }
}
