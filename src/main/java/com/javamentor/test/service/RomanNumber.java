package com.javamentor.test.service;

import com.javamentor.test.model.RomanNumeral;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumber {

    private final Map<String, Integer> mapInput = new HashMap<>();

    {
        mapInput.put("I", 1);
        mapInput.put("II", 2);
        mapInput.put("III", 3);
        mapInput.put("IV", 4);
        mapInput.put("V", 5);
        mapInput.put("VI", 6);
        mapInput.put("VII", 7);
        mapInput.put("VIII", 8);
        mapInput.put("IX", 9);
        mapInput.put("X", 10);
    }

    public int getNumber(String key) {
        return mapInput.get(key) != null ? mapInput.get(key) : 0;
    }

    public String getKey(int value) {
        return mapInput.entrySet().stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    public boolean isRoman(String s) {
        if (this.getNumber(s) >= 1 && this.getNumber(s) <= 10) return true;
        return false;
    }

    public String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " не в диапазоне римских чисел (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
