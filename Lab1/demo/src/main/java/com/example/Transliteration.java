package com.example;

import java.util.Map;

public class Transliteration implements IFormatStrategy {
    private static Map<String, String> dict = Map.ofEntries(
            Map.entry("а", "a"), Map.entry("б", "b"), Map.entry("в", "v"), Map.entry("г", "g"),
            Map.entry("д", "d"), Map.entry("е", "e"), Map.entry("ё", "e"),
            Map.entry("ж", "zh"), Map.entry("з", "z"), Map.entry("и", "i"),
            Map.entry("й", "i"), Map.entry("к", "k"), Map.entry("л", "l"),
            Map.entry("м", "m"), Map.entry("н", "n"), Map.entry("о", "o"),
            Map.entry("п", "p"), Map.entry("р", "r"), Map.entry("с", "s"),
            Map.entry("т", "t"), Map.entry("у", "u"), Map.entry("ф", "f"), Map.entry("х", "h"),
            Map.entry("ц", "c"), Map.entry("ч", "ch"), Map.entry("ш", "sh"),
            Map.entry("щ", "sh'"), Map.entry("ъ", ""), Map.entry("ы", "i"),
            Map.entry("ь", ""), Map.entry("э", "e"), Map.entry("ю", "yu"), Map.entry("я", "ya"));

    @Override
    public String format(String str) {
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toLowerCase().toCharArray()){
            String symbol = Character.toString(ch);
            if (dict.containsKey(symbol)){
                sb.append(dict.get(symbol));
            }
            else {
                sb.append(symbol);
            }
        }
        return new String(sb);
    }
}
