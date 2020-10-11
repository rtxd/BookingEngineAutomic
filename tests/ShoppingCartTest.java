import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void add() {
        PromotionManager promotionalRules = new PromotionManager();
        ShoppingCart sc = new ShoppingCart(promotionalRules);
        sc.add("OH");
        sc.add("BC");
        sc.add("SK");

        assertTrue(sc.getCartItems().contains("OH"));
        assertTrue(sc.getCartItems().contains("BC"));
        assertTrue(sc.getCartItems().contains("SK"));
    }

    @Test
    void remove() {
        PromotionManager promotionalRules = new PromotionManager();
        ShoppingCart sc = new ShoppingCart(promotionalRules);
        sc.add("OH");
        sc.add("BC");
        sc.add("SK");

        sc.remove("OH");
        sc.remove("BC");
        sc.remove("SK");

        assertFalse(sc.getCartItems().contains("OH"));
        assertFalse(sc.getCartItems().contains("BC"));
        assertFalse(sc.getCartItems().contains("SK"));
    }

    @Test
    void getTotal() {
        PromotionManager promotionalRules = new PromotionManager();
        ShoppingCart sc = new ShoppingCart(promotionalRules);
        sc.add("OH");
        sc.add("BC");
        sc.add("SK");

        assertEquals(410, sc.getTotal());
    }
}