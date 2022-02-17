package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book1 = new Book(1, "Алгебра", 350, "Жилин Н.А.");
    private Book book2 = new Book(2, "Химия", 500, "Непряев С.Л.");
    private Book book3 = new Book(3, "Экономика", 450, "Экономика");

    @Test
    public void searchWhereMatchNotFound() {

        assertFalse(book1.matches("История"));
    }

    @Test
    public void searchWhereMatchName() {

        assertTrue(book1.matches("Алгебра"));
    }

    @Test
    public void searchWhereMatchAuthor() {

        assertTrue(book1.matches("Жилин Н.А."));
    }

    @Test
    public void searchWhereMatchNameAndAuthor() {

        assertTrue(book3.matches("Экономика"));
    }
}