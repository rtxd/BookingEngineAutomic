import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class PromotionManager {

    /**
     * the final price after all promotions have been applied to the cart
     * @param cart The users shopping cart
     * @param totalValue Total value of cart before promotions applied
     * @param tourTypes Hashmap connecting Tour IDs to their objects
     * @return Final value of cart after promotions have been applied
     */
    public float applyAllPromotions(ArrayList<String> cart, float totalValue, Map<String, Tour> tourTypes){
        totalValue = applyPromotionalRule1(cart, totalValue, tourTypes);
        totalValue = applyPromotionalRule2(cart, totalValue, tourTypes);
        totalValue = applyPromotionalRule3(cart, totalValue, tourTypes);
        return totalValue;
    }

    /**
     * Promotional Rule: 3 for 2 deal on opera house ticket, if user buys 3 they only have to pay for 2
     * @return price after rule 1 is applied
      */
    private float applyPromotionalRule1(ArrayList<String> cart, float price, Map<String, Tour> tourTypes)
    {
        if(Collections.frequency(cart, "OH") == 3)
        {
            price = price - tourTypes.get("OH").getPrice();
        }
        return price;
    }

    /**
     * Promotional Rule: Free sky tower tour with every opera house tour sold
     * @return price after rule is applied
     */
    private float applyPromotionalRule2(ArrayList<String> cart, float price, Map<String, Tour> tourTypes)
    {
//        For every OH the user gets an SK for free
        int amountOfSKTours = Collections.frequency(cart, "SK");
        int amountOfOHTours = Collections.frequency(cart, "OH");
        if(amountOfSKTours < amountOfOHTours || amountOfSKTours == amountOfOHTours)
        {
            price = price - (tourTypes.get("SK").getPrice() * amountOfSKTours);
        }
        else if(amountOfSKTours > amountOfOHTours)
        {
            price = price - (amountOfOHTours * tourTypes.get("SK").getPrice());
        }
        return price;
    }

    /**
     * Promotional Rule: The Sydney Bridge Climb will have a bulk discount applied, where the price will drop by $20, if someone buys more than 4
     * @return price after rule is applied
     */
    private float applyPromotionalRule3(ArrayList<String> cart, float price, Map<String, Tour> tourTypes)
    {
        int amountOfBC = Collections.frequency(cart, "BC");
        if(amountOfBC > 4) {
            price = price - (20 * amountOfBC);
        }
        return price;
    }
}
