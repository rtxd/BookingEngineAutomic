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
    }

    public ArrayList<String> getCartItems() {
        return cart;
    }

    public void addTourType(Tour tourType){
        tourTypes.put(tourType.getId(), tourType);
    }


    public void add(String tour)
    {
        cart.add(tour);
    }

    public void remove(String tour)
    {
        cart.remove(tour);
    }

    /**
     * Get the total price of the cart after promotions have been applied
     * @return cart value
     */
    public float getTotal() {
        float totalPrice = 0;
        for(String tour : cart)
        {
            totalPrice = totalPrice + tourTypes.get(tour).getPrice();
        }

        return promotionalRules.applyAllPromotions(cart, totalPrice, tourTypes);
    }
}
