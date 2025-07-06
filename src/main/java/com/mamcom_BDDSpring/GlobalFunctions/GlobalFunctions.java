package com.mamcom_BDDSpring.GlobalFunctions;
import com.mamcom_BDDSpring.annotations.PageObjects;
import net.bytebuddy.utility.RandomString;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@PageObjects

public class GlobalFunctions {

    public int getInteger(String text) {
        String temp = "";  String newtext;
        int ReturnInteger = 0;
        for (int i = 0; i < text.length(); i++) {
            String character = text.substring( i, i + 1 );
            if (isNumeric( character )) {
                temp = temp + character;
            }
            if(character.contains(",")) {
                newtext=text.replace(",", "");
            }else newtext=text;
        }
        ReturnInteger = Integer.parseInt( temp );
        return ReturnInteger;
    }

    public Double getDouble(String text) {
        String newtext = null;
        if(text.contains(",")) {
            newtext=text.replace(",", "");
        }else newtext=text;

        return Double.valueOf( newtext );
    }

    public boolean isNumeric(String string) {
        try {
            int number = Integer.parseInt( string );
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public  String generateRandomString(int length) {
        String text = "";
        for(int i = 0; i < length; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt( 26 ) + 'a');
            if(i == 0) {text = Character.toString( c ).toUpperCase();
            } else {
                text = text + c;
            }
        }
        return text;
    }

    public  String generateRandomEmail(int length) {
        String text = "";
        for(int i = 0; i < length; i++) {
            Random r = new Random();
            char c = (char) (r.nextInt( 26 ) + 'a');
            if(i == 0) {
//                text = Character.toString( c ).toUpperCase();
                text = Character.toString( c ).toLowerCase();
            } else {
                text = text + c;
            }
        }
        return text;
    }

    public String getRandomNumber(int length) {
        String RandomNumber = "";
        for(int i = 0; i<length; i++) {
            RandomNumber = RandomNumber + (int)(Math.random()*10);
        }
        return RandomNumber;


    }

    public String getDate(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -14-day);
        Date calDate = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(calDate);
        return date;
    }

   public String generateRandomText(){
        int n =9;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                       + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }


}
