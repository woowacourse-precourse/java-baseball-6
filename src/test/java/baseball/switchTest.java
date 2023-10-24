package baseball;

import org.junit.jupiter.api.Test;

public class switchTest {
    @Test
    public void lambda_switch(){
        int value = 4;
        switch (value){
            case 4 -> System.out.println(value + "this is four");
            case 1 -> System.out.println(value + "this is one");
        }
    }
}
