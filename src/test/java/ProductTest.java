import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {
    private Product cake;

    @BeforeEach
    void beforeEach() {
        cake = new Product("Торт");
    }

    @Test
    void assert_that_cant_add_same_ingredient() {
        Product secondCake = new Product("Торт");

        assertFalse(cake.addProduct(secondCake));
    }

    @Test
    void assert_that_cant_add_main_product_as_ingredient_to_another_ingredient() {
        Product milk = new Product("Молоко");
        cake.addProduct(milk);
        assertFalse(milk.addProduct(cake));
    }

    @Test
    void assert_that_can_add_ingredient_when_its_part_of_another_ingredient() {
        Product vanilla = new Product("Ваниль");
        Product chocolate = new Product("Шоколад");
        Product sugar = new Product("Сахар");
        cake.addProduct(vanilla);
        cake.addProduct(chocolate);

        assertTrue(vanilla.addProduct(sugar) && chocolate.addProduct(sugar));
    }
}
