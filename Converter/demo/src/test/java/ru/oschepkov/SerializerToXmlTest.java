package ru.oschepkov;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.oschepkov.BookstoreStruct.*;
import ru.oschepkov.BookstoreStruct.Character;

public class SerializerToXmlTest {


    @Test
    public void testApply2() throws IOException {
        List<Character> characters1 = new ArrayList<>();
            characters1.add(new Character("Harry Potter", "Protagonist"));
            characters1.add(new Character("Hermione Granger", "Supporting"));
            characters1.add(new Character("Ron Weasley", "Supporting"));

            List<Character> characters2 = new ArrayList<>();
            characters2.add(new Character("Paul Atreides", "Protagonist"));
            characters2.add(new Character("Liet-Kynes", "Supporting"));
            characters2.add(new Character("Baron Vladimir Harkonnen", "Antagonist"));

            Bookstore bookstore = new Bookstore();
            bookstore.setBooks(new ArrayList<>());

            Book book1 = new Book();
            book1.setCategory("Fantasy");
            book1.setTitle(new Title("en", "Harry Potter and the Philosopher's Stone"));
            book1.setAuthor("J.K. Rowling");
            book1.setYear("1997");
            book1.setPrice(new Price("USD", "20.00"));
            book1.setCharacters(characters1);

            Book book2 = new Book();
            book2.setCategory("Science Fiction");
            book2.setTitle(new Title("en", "Dune"));
            book2.setAuthor("Frank Herbert");
            book2.setYear("1965");
            book2.setPrice(new Price("USD", "25.00"));
            book2.setCharacters(characters2);

            bookstore.getBooks().add(book1);
            bookstore.getBooks().add(book2);

            (new SerializerToXml()).apply("src\\test\\resources\\out.xml", bookstore);
            assertTrue((new File("src\\test\\resources\\out.xml")).exists());
            //(new File("src\\main\\resourses\\out.json")).delete();
    }
}
