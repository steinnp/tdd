package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
        if(text == "")
            return 0;
        else if(text.contains(",")){
            String[] numbers = parseNumbers(text);
            return sum(parseNumbers(text));
        }
        else
            return toInt(text);
        

    }

    public static int toInt(String number){
        return Integer.parseInt(number);
    }

    public static String[] parseNumbers(String numbers){
        return numbers.split(",");
    }

    public static int sum(String[] numbers){
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += toInt(numbers[i]);
        }
        return sum;
    }

}
