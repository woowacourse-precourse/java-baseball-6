package baseball.unittest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameLogicTest {


    @Test
    void nothing(){
        List<Integer> computer = new ArrayList<>();
        computer.add(3);
        computer.add(6);
        computer.add(9);

        int[] input = new int[3];
        input[0] = 1;
        input[1] = 2;
        input[2] = 5;

        int ballCount = 0;
        for(int i = 0; i<3;i++){
            if(computer.contains(input[i])){
                ballCount++;
            }
        }
        assert ballCount == 0;
    }
}
