package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    @Test
        public void testEmptyString() {
            assertEquals(0, Calculator.add(""));
        }

    @Test
        public void testOneNumber(){
            assertEquals(1, Calculator.add("1"));
            assertEquals(2, Calculator.add("2"));
            assertEquals(3, Calculator.add("3"));
            assertEquals(4, Calculator.add("4"));
            assertEquals(5, Calculator.add("5"));
        }

    @Test
        public void testTwoNumbers(){
            assertEquals(2, Calculator.add("1,1"));
            assertEquals(4, Calculator.add("2,2"));
            assertEquals(6, Calculator.add("3,3"));
            assertEquals(8, Calculator.add("4,4"));
            assertEquals(10, Calculator.add("5,5"));
        }

    @Test
        public void testXNumbers(){
            assertEquals(12, Calculator.add("11,1,0"));
            assertEquals(4, Calculator.add("2,1,1"));
            assertEquals(6, Calculator.add("3,2,1"));
            assertEquals(8, Calculator.add("4,2,1,1,0,0"));
            assertEquals(10, Calculator.add("5,3,1,1"));
        }

    @Test
        public void testNewlineNumbers(){
            assertEquals(3, Calculator.add("1\n1,1"));
            assertEquals(7, Calculator.add("1\n4\n2"));
            assertEquals(10, Calculator.add("1,4\n1,3\n1"));
        }

    @Test
        public void testAnyDelimNumbers(){
            assertEquals(3, Calculator.add("//;\n1;1,1"));
            assertEquals(9, Calculator.add("//s\n1\n2s2s2,2"));
            assertEquals(10, Calculator.add("//x\n1x4x1x3x1"));
        }

    @Test(expected=IllegalArgumentException.class)
        public void testNegativeNumbers(){
            assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
            assertEquals("Negatives not allowed: -4, -5", Calculator.add("-4,-5"));
        }
    
    @Test
        public void testOverOneThousand(){
        
            assertEquals(1, Calculator.add("1,1001"));
            assertEquals(1001, Calculator.add("1,1000"));
            assertEquals(8, Calculator.add("4,2,1,1,1001,0"));
            assertEquals(7, Calculator.add("1\n4\n2,1050"));
            assertEquals(9, Calculator.add("//s\n1\n2s2s2,2,500000"));
            assertEquals(10, Calculator.add("//x\n1x4x1,300000x3x1"));
        }

    @Test
        public void testAnyLengthDelimNumbers(){
            assertEquals(3, Calculator.add("//;;\n1;;1,1"));
            assertEquals(9, Calculator.add("//ssksk\n1\n2ssksk2ssksk2,2"));
            assertEquals(10, Calculator.add("//x;;x\n1x;;x4x;;x1x;;x3x;;x1"));
        }

    @Test
        public void testAnyLengthDelimNumbers(){
            assertEquals(3, Calculator.add("//[;;][a]\n1;;1a1"));
            assertEquals(10, Calculator.add("//[s][sksk]\n1\n2ssksk1s2ssksk2,2"));
            assertEquals(20, Calculator.add("//[x;][;x]\n1x;1;x4x;2;x1x;3;x3x;4;x1"));
        }
}
