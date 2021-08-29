package in28minutes.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {

    @Test
    void sum() {

        MyMath myMath = new MyMath();
        int sum = myMath.sum(8);
        System.out.println("Suma"+sum);
        assertEquals(8,sum);
    }

    @BeforeEach
    public void before(){
        System.out.println("Before");
    }

    @AfterEach
    public void after(){
        System.out.println("after");
    }

    @BeforeAll
    private static void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterAll
    private static void afterClass(){
        System.out.println("After Class");
    }

}