public class BookingEngine {
    public static void main(String[] args) {

        Tour tour1 = new Tour("OH", "Opera House Tour", 300);
        Tour tour2 = new Tour("BC", "Sydney Bridge Climb", 110);
        Tour tour3 = new Tour("SK", "Sydney Sky Tower", 30);

        PromotionManager promotionalRules = new PromotionManager();
        ShoppingCart cart = new ShoppingCart(promotionalRules);
        cart.add("OH");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");

        System.out.println(tour1);
        System.out.println(tour2);
        System.out.println(tour3);

        System.out.println(cart.getTotal());


    }
}
