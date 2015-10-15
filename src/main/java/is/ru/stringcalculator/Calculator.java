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
            if(delimCheck.substring(0,1).equals("/") && delimCheck.substring(1,2).equals("/")){
                List<String> delims = getDelims(delimCheck);
                convert.remove(0);
                for(int i = 0; i < delims.size(); i++){
                convert = parseDelim(convert, delims.get(i));
                }
            }
            convert = parseDelim(convert, ",");
            checkLegalNumbers(convert);
        return sum(convert);
        }
    }

    //checks for illegal numbers
    public static void checkLegalNumbers(List<String> convert){
        for(int i = 0; i < convert.size(); i++){
            if(convert.get(i).contains("-")){
                String exceptionString = "Negatives not allowed: " + convert.get(i);
                IllegalArgumentException e = new IllegalArgumentException(exceptionString);
                throw(e);
            }
        }
    }

    // turns a number equivalent of string to int
    public static int toInt(String number){
        return Integer.parseInt(number);
    }
    //parses any delimiters declared at the start of a string with the correct
    //syntax, longest delimiters come first to make sure smaller substrings
    //dont change longer strings if they have the same characters
    public static List<String> getDelims(String delimCheck){
        String delim = delimCheck.substring(2,delimCheck.length());
        List<String> delims = new ArrayList<String>();
        delims.add(delim);
        delims = parseDelim(delims, "\\[");
        delims = parseDelim(delims, "]");
        if(delims.get(0).equals(""))
            delims.remove(0);
        List<String> returnList = new ArrayList<String>();
        while(delims.size() > 0){
            String longest = delims.get(0);
            int longestPos = 0;
            for(int i = 0; i < delims.size(); i++){
                if(delims.get(i).length() > longest.length()){
                    longest = delims.get(i);
                    longestPos = i;
                }
            }
                returnList.add(longest);
                delims.remove(longestPos);
        }
        return returnList;
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
            if(toInt(numbers.get(i)) < 1001){
                sum += toInt(numbers.get(i));
            }
        }
        return sum;
    }
}
