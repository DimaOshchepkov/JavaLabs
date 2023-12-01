package ru.oschepkov;

import java.util.Arrays;

import ru.oschepkov.years.BookJson;
import ru.oschepkov.years.CharacterJson;
import ru.oschepkov.years.PriceJson;
import ru.oschepkov.years.TitleJson;
import ru.oschepkov.years.YearJson;
import ru.oschepkov.years.YearsJson;

public class YearsInstance {

    public YearsJson getEnglishBooksByYears() {
        YearJson year1965 = YearJson.builder()
                .value(1965)
                .books(Arrays.asList(
                        BookJson.builder()
                                .category("Science Fiction")
                                .title(new TitleJson("en", "Dune"))
                                .author("Frank Herbert")
                                .year(1965)
                                .price(new PriceJson("USD", 25.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Paul Atreides", "Protagonist"),
                                        new CharacterJson("Liet-Kynes", "Supporting"),
                                        new CharacterJson("Baron Vladimir Harkonnen", "Antagonist")))
                                .build(),
                        BookJson.builder()
                                .category("Fantasy")
                                .title(new TitleJson("en", "Harry Potter and the Sorcerer's Stone"))
                                .author("J.K. Rowling")
                                .year(1997)
                                .price(new PriceJson("USD", 20.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Harry Potter", "Protagonist"),
                                        new CharacterJson("Hermione Granger", "Supporting"),
                                        new CharacterJson("Ron Weasley", "Supporting")))
                                .build(),
                        BookJson.builder()
                                .category("Science Fiction")
                                .title(new TitleJson("en", "Dune Messiah"))
                                .author("Frank Herbert")
                                .year(1969)
                                .price(new PriceJson("USD", 22.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Paul Atreides", "Protagonist"),
                                        new CharacterJson("Chani", "Supporting"),
                                        new CharacterJson("Stilgar", "Supporting"),
                                        new CharacterJson("Alia Atreides", "Antagonist")))
                                .build()))
                .build();

        YearJson year1990 = YearJson.builder()
                .value(1990)
                .books(Arrays.asList(
                        BookJson.builder()
                                .category("Science Fiction")
                                .title(new TitleJson("en", "Hyperion"))
                                .author("Dan Simmons")
                                .year(1989)
                                .price(new PriceJson("USD", 24.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Martin Silenus", "Protagonist"),
                                        new CharacterJson("The Consul", "Supporting"),
                                        new CharacterJson("Brawne Lamia", "Supporting")))
                                .build(),
                        BookJson.builder()
                                .category("Mystery")
                                .title(new TitleJson("en", "The Silence of the Lambs"))
                                .author("Thomas Harris")
                                .year(1988)
                                .price(new PriceJson("USD", 19.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Hannibal Lecter", "Antagonist"),
                                        new CharacterJson("Clarice Starling", "Protagonist"),
                                        new CharacterJson("Jack Crawford", "Supporting")))
                                .build()))
                .build();

        return new YearsJson(Arrays.asList(year1965, year1990));
    }

    public YearsJson getRussianBooksByYears() {
        YearJson year1965 = YearJson.builder()
                .value(1965)
                .books(Arrays.asList(
                        BookJson.builder()
                                .category("Фантастика")
                                .title(new TitleJson("ru", "Дюна"))
                                .author("Фрэнк Герберт")
                                .year(1965)
                                .price(new PriceJson("RUB", 1500.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Павел Атрейдес", "Главный герой"),
                                        new CharacterJson("Лит-Кайнс", "Поддерживающий"),
                                        new CharacterJson("Барон Владимир Гарконнен", "Антагонист")))
                                .build(),
                        BookJson.builder()
                                .category("Фэнтези")
                                .title(new TitleJson("ru", "Гарри Поттер и философский камень"))
                                .author("Джоан Роулинг")
                                .year(1997)
                                .price(new PriceJson("RUB", 1800.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Гарри Поттер", "Главный герой"),
                                        new CharacterJson("Гермиона Грейнджер", "Поддерживающий"),
                                        new CharacterJson("Рон Уизли", "Поддерживающий")))
                                .build()))
                .build();

        YearJson year1990 = YearJson.builder()
                .value(1990)
                .books(Arrays.asList(
                        BookJson.builder()
                                .category("Научная фантастика")
                                .title(new TitleJson("ru", "Гиперион"))
                                .author("Дэн Симмонс")
                                .year(1989)
                                .price(new PriceJson("RUB", 2000.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Мартин Силенус", "Протагонист"),
                                        new CharacterJson("Консул", "Поддерживающий"),
                                        new CharacterJson("Броня Ламия", "Поддерживающий")))
                                .build(),
                        BookJson.builder()
                                .category("Детектив")
                                .title(new TitleJson("ru", "Молчание ягнят"))
                                .author("Томас Харрис")
                                .year(1988)
                                .price(new PriceJson("RUB", 1900.00))
                                .characters(Arrays.asList(
                                        new CharacterJson("Ганнибал Лектер", "Антагонист"),
                                        new CharacterJson("Кларисса Старлинг", "Протагонист"),
                                        new CharacterJson("Джек Кроуфорд", "Поддерживающий")))
                                .build()))
                .build();

        return new YearsJson(Arrays.asList(year1965, year1990));
    }
}
