package Lessons.l2018_01_12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPTest {

    @DataProvider
    public Object[][] data(){
        return new Object[][] {
                {1, "red"},
                {2, "green"},
                {3, "blue"},
        };
    }

    @Test (dataProvider = "data")
    public void dpTest(int i, String s) {
        System.out.println(String.format("int: %s, String %s", i, s));
    }
}
