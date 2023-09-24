package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    public void addNewProduct() {
        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "First", 10_000);
        Product product2 = new Product(2, "Second", 20_000);
        Product product3 = new Product(3, "Third", 30_000);
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        Product[] actual = shop.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void addExistIDProduct() {
        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "First", 10_000);
        Product product2 = new Product(1, "Second", 20_000);

        shop.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class,
                () -> shop.add(product2));


    }


    @Test
    public void removeExistID() {
        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "First", 10_000);
        Product product2 = new Product(2, "Second", 20_000);
        Product product3 = new Product(3, "Third", 30_000);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(2);
        Product[] actual = shop.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeNotExistID() {
        ShopRepository shop = new ShopRepository();
        Product product1 = new Product(1, "First", 10_000);
        Product product2 = new Product(2, "Second", 20_000);
        Product product3 = new Product(3, "Third", 30_000);

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> shop.remove(5));

    }

}