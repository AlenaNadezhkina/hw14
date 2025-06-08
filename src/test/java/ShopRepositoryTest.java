import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopRepositoryTest {

    Product item1 = new Product(11, "хлеб", 1);
    Product item2 = new Product(222, "булка", 2);
    Product item3 = new Product(3, "картошка", 3);

    @Test
    public void test() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(100);
        });
    }

    @Test
    public void ProductRemove() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(11);
        Product[] actual = repo.findAll();
        Product[] expected = {item2, item3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void ProductHasCode() {
        Product product = new Product(11, "хлеб", 1);
        int actual = product.hashCode();
        assertEquals(1042780729, actual);
    }

    @Test
    public void ProductEqualsNotNull() {
        Product obj = new Product(1, "хлеб", 1);
        Assertions.assertTrue(obj.equals(obj));
    }

    @Test
    public void ProductEqualsNull() {
        Product obj = new Product(5, "хлеб", 1);
        Assertions.assertFalse(obj.equals(null));
    }

    @Test
    void ProductEqualsNew() {
        Product obj = new Product(5, "хлеб", 1);
        Assertions.assertFalse(obj.equals(new Object()));
    }

    @Test
    public void ProductEqualsDifferentAll() {
        Product obj1 = new Product(11, "хлеб", 1);
        Product obj2 = new Product(222, "булка", 2);
        Assertions.assertFalse(obj1.equals(obj2));
    }

    @Test
    public void ProductEqualsSame() {
        Product obj1 = new Product(11, "хлеб", 1);
        Product obj2 = new Product(11, "хлеб", 1);
        Assertions.assertTrue(obj1.equals(obj2));
        Assertions.assertTrue(obj2.equals(obj1));
    }

    @Test
    public void ProductEqualsDifferentId() {
        Product obj1 = new Product(11, "хлеб", 1);
        Product obj2 = new Product(15, "хлеб", 1);
        Assertions.assertFalse(obj1.equals(obj2));
    }

    @Test
    public void ProductEqualsDifferentTitle() {
        Product obj1 = new Product(11, "хлеб", 1);
        Product obj2 = new Product(11, "молоко", 1);
        Assertions.assertFalse(obj1.equals(obj2));
    }

    @Test
    public void ProductEqualsDifferentPrice() {
        Product obj1 = new Product(11, "хлеб", 1);
        Product obj2 = new Product(11, "хлеб", 2);
        Assertions.assertFalse(obj1.equals(obj2));
    }
}

