package org.day1;

public class GenerateRandomString {
    StringBuilder str;

    public GenerateRandomString(int length)
    {
        // chose a Character random from this String
        String AlphaNumericString =
                  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        str = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            str.append(AlphaNumericString
                    .charAt(index));
        }
    }

    public String get(){
        return str.toString();
    }
}
