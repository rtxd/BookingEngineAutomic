import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromotionManagerTest {

    /**
     * Testing all promotions
     */
    @Test
    void applyAllPromotions() {
        PromotionManager promotionalRules = new PromotionManager();
        ShoppingCart sc = new ShoppingCart(promotionalRules);
        sc.add("OH");
        sc.add("OH");
        sc.add("OH");
        sc.add("BC");
        sc.add("BC");
        sc.add("BC");
        sc.add("BC");
        sc.add("BC");
        sc.add("SK");
        sc.add("SK");
        sc.add("SK");
        sc.add("SK");


        assertEquals(1080, sc.getTotal());
    }
}