package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

    public static int add(String text){
        if(text == "")
            return 0;
        else if(text.contains(",") || text.contains("\n")){
            List<String> tempNumbers = parseNumbers(text);
            List<String> numbers = parseNewLine(tempNumbers);
            return sum(numbers);
        }
        else
            return toInt(text);
        

    }

    public static int toInt(String number){
        return Integer.parseInt(number);
    }

    public static List<String> parseNumbers(String numbers){
        return Arrays.asList(numbers.split(","));
    }

    public static List<String> parseNewLine(List<String> text){
        List<String> numbers = new ArrayList<String>();
        for(int i = 0; i < text.size(); i++){
            String[] tempNumbers = text.get(i).split("\n");
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

}
