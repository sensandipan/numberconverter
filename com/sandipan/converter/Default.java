package com.sandipan.converter;

public class Default extends Placevalue {

	static private String MINUS = "minus";
    static private String UNION_AND = "and";
    static private String ZERO_TOKEN = "zero";
    private Placevalue processor = new Higher(9);

    @Override
    public String getName(String value) {
        boolean negative = false;
        if (value.startsWith("-")) {
            negative = true;
            value = value.substring(1);
        }

        int decimals = value.indexOf(".");
        String decimalValue = null;
        if (0 <= decimals) {
            decimalValue = value.substring(decimals + 1);
            value = value.substring(0, decimals);
        }

        String name = processor.getName(value);

        if (name.isEmpty()) {
            name = ZERO_TOKEN;
        } else if (negative) {
            name = MINUS.concat(SEPARATOR).concat(name); 
        }

        if (!(null == decimalValue || decimalValue.isEmpty())) {
            name = name.concat(SEPARATOR).concat(UNION_AND).concat(SEPARATOR)
                .concat(processor.getName(decimalValue))
                .concat(SEPARATOR).concat(scale.getName(-decimalValue.length()));
        }

        return name;
    }

}
