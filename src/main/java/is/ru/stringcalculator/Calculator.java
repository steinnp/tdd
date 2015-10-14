package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

    public static int add(String text){
        if(text == "")
            return 0;
        else{ 
            List<String> convert = new ArrayList<String>();
            convert.add(text);
            convert = parseDelim(convert, "\n");
            String delimCheck = convert.get(0);
            //if a new delimiter is declared we get the delimiter and
            //parse the strings into substrings.
            if(delimCheck.matches("//(.*)") == true){
                String newDelim = getDelim(delimCheck);
                convert.remove(0);
                convert = parseDelim(convert, newDelim);
            }
            List<String> numbers = parseDelim(convert, ",");
            return sum(numbers);
        }
    }
    // turns a number equivalent of string to int
    public static int toInt(String number){
        return Integer.parseInt(number);
    }
    //parses any delimiter declared at the start of a string with the correct
    //syntax
    public static String getDelim(String delimCheck){
        String delim = delimCheck.substring(2,3);
        return delim;
    }

    //breaks down a list of strings into substrings with delim as delimiter
    public static List<String> parseDelim(List<String> text, String delim){
        List<String> numbers = new ArrayList<String>();
        for(int i = 0; i < text.size(); i++){
            String[] convert = text.get(i).split(delim);
            for(int j = 0; j < convert.length; j++){
                numbers.add(convert[j]);
            }
        }
       return numbers; 
    }
    //computes the sum of the string equivalent of integers.
    public static int sum(List<String> numbers){
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += toInt(numbers.get(i));
        }
        return sum;
    }
}
