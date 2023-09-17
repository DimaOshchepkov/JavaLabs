package com.example;

public class AsInSentences implements IFormatStrategy {

    @Override
    public String format(String str) {
        StringBuilder sb = new StringBuilder(str);

        int dotPos = str.indexOf('.');
        int symbolPos = firstNotSpaceSubol(str, 0);
        if (symbolPos != -1)
            sb.setCharAt(symbolPos, Character.toUpperCase(str.charAt(symbolPos)));

        while (dotPos != -1) {
            symbolPos = firstNotSpaceSubol(str, dotPos + 1);
            if (symbolPos != -1)
                sb.setCharAt(symbolPos, Character.toUpperCase(str.charAt(symbolPos)));

            dotPos = firstDot(str, dotPos + 1);
        }

        return sb.toString();
    }

    private int firstNotSpaceSubol(String str, int start, int end) {
        int first = start;
        end = Math.min(end, str.length());
        while (first < end && str.charAt(first) == ' ') {
            first++;
        }
        
        if (first < end) return first;
        return -1;
    }

    private int firstNotSpaceSubol(String str, int start) {
        return firstNotSpaceSubol(str, start, str.length());
    }

    private int firstDot(String str, int start, int end) {
        int first = start;
        end = Math.min(end, str.length());
        while (first < end && str.charAt(first) != '.') {
            first++;
        }
        
        if (first < end) return first;
        return -1;
    }
    
    private int firstDot(String str, int start) {
        return firstDot(str, start, str.length());
    }

}
