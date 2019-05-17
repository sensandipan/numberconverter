package com.sandipan.converter;

public class Hundred extends Placevalue {

    private int EXPONENT = 2;

    private Unit unitProcessor = new Unit();
    private Tens tensProcessor = new Tens();

    @Override
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();

        int number;
        if (value.isEmpty()) {
            number = 0;
        } else if (value.length() > 4) {
            number = Integer.valueOf(value.substring(value.length() - 4), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        number %= 1000;  // keep at least three digits

        if (number >= 100) {
            buffer.append(unitProcessor.getName(number / 100));
            buffer.append(SEPARATOR);
            buffer.append(scale.getName(EXPONENT));
        }

        String tensName = tensProcessor.getName(number % 100);

        if (!tensName.isEmpty() && (number >= 100)) {
            buffer.append(SEPARATOR);
        }
        buffer.append(tensName);

        return buffer.toString();
    }

}
