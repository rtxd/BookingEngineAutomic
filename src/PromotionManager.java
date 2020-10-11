import java.util.ArrayList;
import java.util.Collections;

public class PromotionManager {

    public float applyAllPromotions(ArrayList<String> cart, float totalValue){
        totalValue = promotionalRule1(cart, totalValue);
        totalValue = promotionalRule2(cart, totalValue);
        totalValue = promotionalRule3(cart, totalValue);
        return totalValue;
    }

    private float promotionalRule1(ArrayList<String> cart, float price)
    {
//        if there are 3 OH in cart then discountedValue = discountedValue - OH.getPrice();
        if(Collections.frequency(cart, "OH") == 3)
        {
            price = price - 300;
        }
        return price;
    }

    //Could make this rule more flexible by passing in the Tour type as a parameter
    private float promotionalRule2(ArrayList<String> cart, float price)
    {
//        For every OH the user gets an SK for free
        int amountOfSKTours = Collections.frequency(cart, "SK");
        int amountOfOHTours = Collections.frequency(cart, "OH");
        if(amountOfSKTours < amountOfOHTours || amountOfSKTours == amountOfOHTours)
        {
            price = price - (30 * amountOfSKTours);
        }
        return price;
    }

    //Could make this rule more flexible by passing in the Tour type as a parameter
    private float promotionalRule3(ArrayList<String> cart, float price)
    {
        int amountOfBC = Collections.frequency(cart, "BC");
        if(amountOfBC > 4) {
            price = price - (20 * amountOfBC);
        }
        return price;
    }
}
