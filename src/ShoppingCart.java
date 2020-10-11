import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    //    A dictionary mapping tour IDs to their respective Tour values
    private Map<String, Tour> tourTypes = new HashMap<String, Tour>();
    //    The shopping cart (stores tour IDs)
    private ArrayList<String> cart = new ArrayList<String>();
    private PromotionManager promotionalRules;

    public ShoppingCart(PromotionManager promotionalRules){
        this.promotionalRules = promotionalRules;
        tourTypes.put("OH" ,new Tour("OH", "Opera House Tour", 300));
        tourTypes.put("BC", new Tour("BC", "Sydney Bridge Climb", 110));
        tourTypes.put("SK", new Tour("SK", "Sydney Sky Tower", 30));
    }

    public void add(String tour)
    {
        cart.add(tour);
    }

    public void remove(String tour)
    {
        cart.remove(tour);
    }

    public float getTotal() {
        float totalPrice = 0;
        for(String tour : cart)
        {
            totalPrice = totalPrice + tourTypes.get(tour).getPrice();
        }

        return promotionalRules.applyAllPromotions(cart, totalPrice, tourTypes);
    }
}
