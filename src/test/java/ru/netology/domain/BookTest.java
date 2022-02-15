package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    private Book book1 = new Book(1, "Алгебра", 350, "Жилин Н.А.");
    private Book book2 = new Book(2, "Химия", 500, "Непряев С.Л.");
    private Book book3 = new Book(3, "Алгебра", 450, "Суслов Р.В.");
    private Book book4 = new Book(4, "История", 450, "Непряев С.Л.");
    private Book book5 = new Book(5, "География", 450, "История");
    private Book book6 = new Book(6, "Экономика", 450, "Экономика");

    @Test
    public void searchWhereNoBooks() {

        String name = "Алгебра";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchNotFound() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "Политология";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchOneName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "Химия";

        Product[] expected = {book2};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchTwoName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "Алгебра";

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchOneAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "Суслов Р.В.";

        Product[] expected = {book3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchTwoAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "Непряев С.Л.";

        Product[] expected = {book2, book4};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchOneNameOneAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "История";

        Product[] expected = {book4, book5};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhereMatchNameAndAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);

        String name = "Экономика";

        Product[] expected = {book6};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
}