package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);
    private Smartphone smart1 = new Smartphone(1, "Note", 80000, "Samsung");
    private Smartphone smart2 = new Smartphone(2, "Iphone", 60000, "Apple");
    private Smartphone smart3 = new Smartphone(3, "Note", 80000, "Honor");
    private Smartphone smart4 = new Smartphone(4, "Galaxy", 60000, "Apple");
    private Smartphone smart5 = new Smartphone(5, "Ultra", 80000, "Galaxy");
    private Smartphone smart6 = new Smartphone(6, "Marusya", 60000, "Marusya");

    @Test
    public void searchWhereNoSmarts() {

        String name = "Note";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchNotFound() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Sony";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchOneName() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Iphone";

        Product[] expected = {smart2};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchTwoName() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Note";

        Product[] expected = {smart1, smart3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchOneCompany() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Honor";

        Product[] expected = {smart3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchTwoCompany() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Apple";

        Product[] expected = {smart2, smart4};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchOneNameOneCompany() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Galaxy";

        Product[] expected = {smart4, smart5};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchWhereMatchNameAndCompany() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);
        manager.add(smart4);
        manager.add(smart5);
        manager.add(smart6);

        String name = "Marusya";

        Product[] expected = {smart6};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

}