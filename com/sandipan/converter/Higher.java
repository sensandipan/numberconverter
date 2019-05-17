package com.sandipan.converter;

public class Higher extends Placevalue {
	 private Hundred hundredProcessor = new Hundred();
     private Placevalue lowProcessor;
     private int exponent;

     public Higher(int exponent) {
         if (exponent <= 3) {
             lowProcessor = hundredProcessor;
         } else {
             lowProcessor = new Higher(exponent - 3);
         }
         this.exponent = exponent;
     }

     public String getToken() {
         return scale.getName(getPartDivider());
     }

     protected Placevalue getHighProcessor() {
         return hundredProcessor;
     }

     protected Placevalue getLowProcessor() {
         return lowProcessor;
     }

     public int getPartDivider() {
         return exponent;
     }

     @Override
     public String getName(String value) {
         StringBuilder buffer = new StringBuilder();

         String high, low;
         if (value.length() < getPartDivider()) {
             high = "";
             low = value;
         } else {
             int index = value.length() - getPartDivider();
             high = value.substring(0, index);
             low = value.substring(index);
         }

         String highName = getHighProcessor().getName(high);
         String lowName = getLowProcessor().getName(low);

         if (!highName.isEmpty()) {
             buffer.append(highName);
             buffer.append(SEPARATOR);
             buffer.append(getToken());

             if (!lowName.isEmpty()) {
                 buffer.append(SEPARATOR);
             }
         }

         if (!lowName.isEmpty()) {
           buffer.append(lowName);
         }

         return buffer.toString();
     }

}
