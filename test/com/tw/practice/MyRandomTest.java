package com.tw.practice;

import com.tw.pratice.MyRandom;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by zhaochuxin on 15/12/26.
 */
public class MyRandomTest {


    private MyRandom myRandom;
    @Before
    public void setUp() throws Exception{
    myRandom = new MyRandom();
    }

    @Test
    public void should_have_four_characters() {
//        MyRandom.test();
//        assertThat(MyRandom.test(), is(0));
        String numbers = myRandom.test();
        assertEquals(numbers.length(), 4);

    }

    @Test
    public void should_be_digital() {
        String numbers = myRandom.test();
        assertEquals(isNumeric(numbers), true);
    }
    @Test
    public void should_not_be_duplicated(){
        assertTrue(isUniqueEachOther(myRandom.test()));
    }
    public boolean isUniqueEachOther(String numbers){
//       String regex = numbers.substring(0, 1) + "{" + numbers.length() + "}";
//       return numbers.matches(regex);
        for(int i=0;i<numbers.length();i++) {
            if (numbers.substring(i + 1, numbers.length()).indexOf(numbers.charAt(i)) > -1)
                return false;
        }return true;
    }
    private boolean isNumeric(String numbers) {
        return numbers.matches("\\d+");
    }
    @Test
    public void should_be_random(){
        assertTrue(isRandom(myRandom.test()));
    }
    public boolean isRandom(String numbers)
    {
        String numbers2 = myRandom.test();
        if(numbers==numbers2)
            return false;
        else {
            return true;
        }
    }
    @Test
    public void input_1234_expect_1234_is_4A0B(){
        assertEquals("4A0B",myRandom.compare("1234","1234"));
    }

    @Test
    public  void input_1234_except_4321_is_0A4B(){
        assertEquals("0A4B",myRandom.compare("1234","4321"));
    }

    @Test
    public  void input_1234_except_1536_is_2A0B()
    {
        assertEquals("2A0B",myRandom.compare("1234","1536"));
    }

    @Test
    public  void input_1234_except_4356_is_0A2B(){
        assertEquals("0A2B",myRandom.compare("1234","4356"));
    }

    @Test
    public  void input_1234_except_5678_is_0A0B()

    {
        assertEquals("0A0B", myRandom.compare("1234", "5678"));
    }

    @Test
    public  void input_1234_except_1243_is_2A2B(){
        assertEquals("2A2B",myRandom.compare("1234","1243"));
    }


}

