package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
        if(text == "")
            return 0;
        else
            return toInt(text);

    }

    public static int toInt(String number){
        return Integer.parseInt(number);
    }

}
