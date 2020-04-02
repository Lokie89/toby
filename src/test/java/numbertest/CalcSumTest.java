package numbertest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(JUnit4.class)
public class CalcSumTest {
    Calculator calculator;
    String numFilePath;

    @Before
    public void setUp(){
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("/daoxml/numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        Assert.assertEquals(calculator.calcSum(numFilePath), 10);
    }

    @Test
    public void multiplyOfNumbers() throws IOException{
        Assert.assertEquals(calculator.calcMultiply(numFilePath),24);
    }

    @Test
    public void concatenate() throws IOException{
        Assert.assertEquals(calculator.concatenate(numFilePath),"1234");
    }
}
