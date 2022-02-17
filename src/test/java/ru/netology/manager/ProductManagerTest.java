package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);
    private Book book1 = new Book(1, "Алгебра", 350, "Жилин Н.А");
    private Book book2 = new Book(2, "Химия", 500, "Непряев С.Л.");
    private Smartphone smart1 = new Smartphone(3, "S21 Ultra", 80000, "Samsung");
    private Smartphone smart2 = new Smartphone(4, "10X", 60000, "Apple");
    private Book book3 = new Book(5, "Алгебра", 450, "Суслов Р.В");
    private Smartphone smart3 = new Smartphone(6, "S21 Ultra", 80000, "Honor");

    @Test
    public void addBook() {
        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addSmart() {
        manager.add(smart1);

        Product[] expected = {smart1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addBookAndSmart() {
        manager.add(book1);
        manager.add(smart1);

        Product[] expected = {book1, smart1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoMatch() {
        manager.add(smart2);
        manager.add(book1);
        manager.add(smart1);
        manager.add(book2);

        String name = "Физика";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneMatchBook() {
        manager.add(smart2);
        manager.add(book1);
        manager.add(smart1);
        manager.add(book2);

        String name = "Алгебра";

        Product[] expected = {book1};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTwoMatchBook() {
        manager.add(smart2);
        manager.add(book1);
        manager.add(smart1);
        manager.add(book2);
        manager.add(book3);

        String name = "Алгебра";

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneMatchSmart() {
        manager.add(smart2);
        manager.add(book1);
        manager.add(smart1);
        manager.add(book2);

        String name = "10X";

        Product[] expected = {smart2};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTwoMatchSmart() {
        manager.add(smart2);
        manager.add(book1);
        manager.add(smart1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smart3);

        String name = "S21 Ultra";

        Product[] expected = {smart1, smart3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
}