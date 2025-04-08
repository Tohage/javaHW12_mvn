import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTests {

    @Test
    public void shouldRemoveByIdProduct() {
        ShopRepository repo = new ShopRepository();
        Product p1 = new Product(1, "Phone", 500);
        Product p2 = new Product(2, "Laptop", 1500);
        Product p3 = new Product(3, "Tablet", 1000);

        repo.add(p1);
        repo.add(p2);
        repo.add(p3);

        repo.removeById(2);

        Product[] expected = {p1, p3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenIdNotFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Phone", 500));

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(10)
        );
    }
}

