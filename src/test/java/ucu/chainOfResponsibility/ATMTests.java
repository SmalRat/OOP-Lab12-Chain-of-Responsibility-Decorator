package ucu.chainOfResponsibility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATMTests {
    @Test
    public void test1(){
        ATM atm = new ATM();
        Assertions.assertEquals("""
                50 * 2
                20 * 0
                5 * 0
                """, atm.process(100));
    }
    @Test
    public void test2(){
        ATM atm = new ATM();
        Assertions.assertEquals("""
                50 * 1
                20 * 1
                5 * 1
                """, atm.process(75));
    }
    @Test
    public void test3(){
        ATM atm = new ATM();
        Assertions.assertEquals("""
                50 * 1
                20 * 0
                5 * 1
                """, atm.process(55));
    }
    @Test
    public void test4(){
        ATM atm = new ATM();
        Assertions.assertEquals("""
                50 * 1
                20 * 0
                5 * 0
                """, atm.process(50));
    }
    @Test
    public void test5(){
        ATM atm = new ATM();
        Assertions.assertEquals("""
                50 * 0
                20 * 2
                5 * 1
                """, atm.process(45));
    }
    @Test
    public void test6(){
        ATM atm = new ATM();
        Assertions.assertThrows(IllegalArgumentException.class,() ->  atm.process(49));
    }
}
