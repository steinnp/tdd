package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

    public static int add(String text){
        if(text == "")
            return 0;
        else{ 
            List<String> convert = new ArrayList<String>();
            convert.add(text);
            List<String> tempNumbers = parseDelim(convert, "\n");
            String delimCheck = tempNumbers.get(0);
                if(delimCheck.matches("//(.*)") == true){
                    String delim = delimCheck.substring(2,3);
                    tempNumbers.remove(0);
                    tempNumbers.add(delim);
                    tempNumbers = parseDelim(tempNumbers, delim);
                }
            List<String> numbers = parseDelim(tempNumbers, ",");
            return sum(numbers);
        }
    }

    public static int toInt(String number){
        return Integer.parseInt(number);
    }

    public static List<String> parseDelim(List<String> text, String delim){
        List<String> numbers = new ArrayList<String>();
        for(int i = 0; i < text.size(); i++){
            String[] tempNumbers = text.get(i).split(delim);
            for(int j = 0; j < tempNumbers.length; j++){
                numbers.add(tempNumbers[j]);
            }
        }
       return numbers; 
    }

    public static int sum(List<String> numbers){
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += toInt(numbers.get(i));
        }
        return sum;
    }

    public static void main(String[] args){
       int temp = add("\\\\;\n2,3;3\n5"); 
    }
}
