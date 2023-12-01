package ru.oschepkov;

import java.util.Arrays;
import java.util.List;

import ru.oschepkov.bookstore.BookXml;
import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.bookstore.CharacterXml;
import ru.oschepkov.bookstore.PriceXml;
import ru.oschepkov.bookstore.TitleXml;

public class BookstoreInstance {

    public BookstoreXml getEnglishBooks() {
        List<BookXml> books = Arrays.asList(
                BookXml.builder()
                        .category("Fantasy")
                        .title(new TitleXml("Harry Potter and the Philosopher's Stone", "en"))
                        .author("J.K. Rowling")
                        .year(1997)
                        .price(new PriceXml("USD", 20.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Harry Potter", "Protagonist"),
                                new CharacterXml("Hermione Granger", "Supporting"),
                                new CharacterXml("Ron Weasley", "Supporting")))
                        .build(),

                BookXml.builder()
                        .category("Science Fiction")
                        .title(new TitleXml("Dune", "en"))
                        .author("Frank Herbert")
                        .year(1965)
                        .price(new PriceXml("USD", 25.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Paul Atreides", "Protagonist"),
                                new CharacterXml("Liet-Kynes", "Supporting"),
                                new CharacterXml("Baron Vladimir Harkonnen", "Antagonist")))
                        .build(),

                BookXml.builder()
                        .category("Fantasy")
                        .title(new TitleXml("The Lord of the Rings", "en"))
                        .author("J.R.R. Tolkien")
                        .year(1954)
                        .price(new PriceXml("USD", 30.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Frodo Baggins", "Protagonist"),
                                new CharacterXml("Aragorn", "Supporting"),
                                new CharacterXml("Gollum", "Antagonist")))
                        .build(),

                BookXml.builder()
                        .category("Science Fiction")
                        .title(new TitleXml("Foundation", "en"))
                        .author("Isaac Asimov")
                        .year(1951)
                        .price(new PriceXml("USD", 22.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Hari Seldon", "Protagonist"),
                                new CharacterXml("The Mule", "Antagonist"),
                                new CharacterXml("R. Daneel Olivaw", "Supporting")))
                        .build(),

                BookXml.builder()
                        .category("Classic")
                        .title(new TitleXml("To Kill a Mockingbird", "en"))
                        .author("Harper Lee")
                        .year(1960)
                        .price(new PriceXml("USD", 18.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Atticus Finch", "Protagonist"),
                                new CharacterXml("Scout Finch", "Supporting"),
                                new CharacterXml("Boo Radley", "Supporting")))
                        .build());

        return new BookstoreXml(books);
    }

    public BookstoreXml getRussianBooks() {
        List<BookXml> books = Arrays.asList(
                BookXml.builder()
                        .category("Роман")
                        .title(new TitleXml("Война и мир", "ru"))
                        .author("Лев Толстой")
                        .year(1869)
                        .price(new PriceXml("RUB", 1200.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Пьер Безухов", "Главный герой"),
                                new CharacterXml("Наташа Ростова", "Помощник"),
                                new CharacterXml("Андрей Болконский", "Антагонист")))
                        .build(),

                BookXml.builder()
                        .category("Детектив")
                        .title(new TitleXml("Преступление и наказание", "ru"))
                        .author("Фёдор Достоевский")
                        .year(1866)
                        .price(new PriceXml("RUB", 950.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Родион Раскольников", "Протагонист"),
                                new CharacterXml("Соня Мармеладова", "Поддерживающий"),
                                new CharacterXml("Порфирий Петрович", "Антагонист")))
                        .build(),

                BookXml.builder()
                        .category("Фантастика")
                        .title(new TitleXml("Мастер и Маргарита", "ru"))
                        .author("Михаил Булгаков")
                        .year(1967)
                        .price(new PriceXml("RUB", 850.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Воланд", "Антагонист"),
                                new CharacterXml("Мастер", "Протагонист"),
                                new CharacterXml("Маргарита", "Поддерживающий")))
                        .build(),

                BookXml.builder()
                        .category("Классика")
                        .title(new TitleXml("Дядя Ваня", "ru"))
                        .author("Антон Чехов")
                        .year(1899)
                        .price(new PriceXml("RUB", 700.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Иван Войницкий (Ваня)", "Протагонист"),
                                new CharacterXml("Елена Андреевна", "Поддерживающий"),
                                new CharacterXml("Александр Сергеевич", "Антагонист")))
                        .build(),

                BookXml.builder()
                        .category("Сатира")
                        .title(new TitleXml("Мертвые души", "ru"))
                        .author("Николай Гоголь")
                        .year(1842)
                        .price(new PriceXml("RUB", 800.00))
                        .characters(Arrays.asList(
                                new CharacterXml("Чичиков", "Протагонист"),
                                new CharacterXml("Собакевич", "Поддерживающий"),
                                new CharacterXml("Манилов", "Поддерживающий")))
                        .build());

        return new BookstoreXml(books);
    }
}
