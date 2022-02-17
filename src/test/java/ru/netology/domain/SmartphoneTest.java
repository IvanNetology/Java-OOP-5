package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone smart1 = new Smartphone(1, "Note", 80000, "Samsung");
    private Smartphone smart2 = new Smartphone(2, "Iphone", 60000, "Apple");
    private Smartphone smart3 = new Smartphone(3, "Galaxy", 60000, "Galaxy");

    @Test
    public void searchWhereMatchNotFound() {

        assertFalse(smart1.matches("Honor"));
    }

    @Test
    public void searchWhereMatchName() {

        assertTrue(smart1.matches("Note"));
    }

    @Test
    public void searchWhereMatchCompany() {

        assertTrue(smart2.matches("Apple"));
    }

    @Test
    public void searchWhereMatchNameAndCompany() {

        assertTrue(smart3.matches("Galaxy"));
    }
}