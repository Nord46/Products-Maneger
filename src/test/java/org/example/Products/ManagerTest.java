package org.example.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Book book1 = new Book(67, "War and Peace", 1500, "Lev Tolstoy");
    Smartphone phone1 = new Smartphone(89, "Iphone", 9500, "Apple");
    Book book2 = new Book(24, "Big debt crises", 2800, "Ray Dalio");
    Smartphone phone2 = new Smartphone(99, "Honor", 8400, "HUAWEI");
    Smartphone phone3 = new Smartphone(98, "Honor", 9000, "HUAWEI");
    @Test
    public void searchProductText() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("War and Peace");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNonProductText() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Last Light");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTwoProductsText() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone2, phone3};
        Product[] actual = manager.searchBy("Honor");

        Assertions.assertArrayEquals(expected, actual);
    }
}
