package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
        if(text == "")
            return 0;
        else
            return Integer.parseInt(text);

    }
}
