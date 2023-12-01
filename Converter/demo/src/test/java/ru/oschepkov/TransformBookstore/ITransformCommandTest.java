package ru.oschepkov.transformbookstore;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import ru.oschepkov.bookstore.BookXml;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.bookstore.CharacterXml;
import ru.oschepkov.bookstore.PriceXml;
import ru.oschepkov.bookstore.TitleXml;

public class ITransformCommandTest {
    @Test
    public void testFunctionInterface() {
         List<CharacterXml> characters1 = new ArrayList<>();
            characters1.add(new CharacterXml("Harry Potter", "Protagonist"));
            characters1.add(new CharacterXml("Hermione Granger", "Supporting"));
            characters1.add(new CharacterXml("Ron Weasley", "Supporting"));

            List<CharacterXml> characters2 = new ArrayList<>();
            characters2.add(new CharacterXml("Paul Atreides", "Protagonist"));
            characters2.add(new CharacterXml("Liet-Kynes", "Supporting"));
            characters2.add(new CharacterXml("Baron Vladimir Harkonnen", "Antagonist"));

            BookstoreXml bookstore = new BookstoreXml();
            bookstore.setBooks(new ArrayList<>());

            BookXml book1 = new BookXml();
            book1.setCategory("Fantasy");
            book1.setTitle(new TitleXml("en", "Harry Potter and the Philosopher's Stone"));
            book1.setAuthor("J.K. Rowling");
            book1.setYear(1997);
            book1.setPrice(new PriceXml("USD", 25));
            book1.setCharacters(characters1);

            BookXml book2 = new BookXml();
            book2.setCategory("Science Fiction");
            book2.setTitle(new TitleXml("en", "Dune"));
            book2.setAuthor("Frank Herbert");
            book2.setYear(1965);
            book2.setPrice(new PriceXml("USD", 20));
            book2.setCharacters(characters2);

            bookstore.getBooks().add(book1);
            bookstore.getBooks().add(book2);

            ITransformCommand command = (BookstoreXml b) -> {
                return new BookstoreXml(b.getBooks().stream()
                    .sorted(Comparator.comparing(book -> book.getPrice().getValue()))
                    .collect(Collectors.toList()));
            };
            bookstore = command.apply(bookstore);

            assertTrue(Math.abs(bookstore.getBooks().get(0).getPrice().getValue() - 20) < Math.pow(-10, 6));
    }
}
