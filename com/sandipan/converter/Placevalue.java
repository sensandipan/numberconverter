package com.sandipan.converter;

import java.util.ArrayList;
import java.util.List;
import com.sandipan.converter.ScaleUnit;


public abstract class Placevalue {
	
    static protected final String SEPARATOR = " ";
    static protected final int NO_VALUE = -1;
    public static ScaleUnit[] SCALE_UNITS = new ScaleUnit[] {
            new ScaleUnit(9, "billion", "billion"),
            new ScaleUnit(6, "million", "million"),
            new ScaleUnit(3, "thousand", "thousand"),
            new ScaleUnit(2, "hundred", "hundred"),
            new ScaleUnit(-1, "tenth", "tenth"),
            new ScaleUnit(-2, "hundredth", "hundredth"),
            new ScaleUnit(-3, "thousandth", "thousandth"),
            new ScaleUnit(-4, "ten-thousandth", "ten-thousandth"),
            new ScaleUnit(-5, "hundred-thousandth", "hundred-thousandth"),
            new ScaleUnit(-6, "millionth", "millionth")
         };
    
    public enum Scalar {
        SHORT,
        LONG;

        public String getName(int exponent) {
            for (ScaleUnit unit : SCALE_UNITS) {
                if (unit.getExponent() == exponent) {
                    return unit.getName(this.ordinal());
                }
            }
            return ""; 
        }
    }

    public Scalar scale = Scalar.SHORT;
    protected List<Integer> getDigits(long value) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    if (value == 0) {
            digits.add(0);
    } else {
            while (value > 0) {
                digits.add(0, (int) value % 10);
                value /= 10;
            }
        }
        return digits;
    }

    public String getName(long value) {
        return getName(Long.toString(value));
    }

    public String getName(double value) {
        return getName(Double.toString(value));
    }

    abstract public String getName(String value);

}
