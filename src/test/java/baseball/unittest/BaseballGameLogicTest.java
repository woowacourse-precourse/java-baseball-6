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

    @Test
    void one_ball(){
        List<Integer> computer = new ArrayList<>();
        computer.add(3);
        computer.add(6);
        computer.add(9);

        int[] input = new int[3];
        input[0] = 1;
        input[1] = 3;
        input[2] = 5;

        int ballCount = 0;
        for(int i = 0; i<3;i++){
            if(computer.contains(input[i])){
                ballCount++;
            }
        }
        assert ballCount == 1;
    }

    @Test
    void two_ball(){
        List<Integer> computer = new ArrayList<>();
        computer.add(3);
        computer.add(6);
        computer.add(9);

        int[] input = new int[3];
        input[0] = 1;
        input[1] = 3;
        input[2] = 6;

        int ballCount = 0;
        for(int i = 0; i<3;i++){
            if(computer.contains(input[i])){
                ballCount++;
            }
        }
        assert ballCount == 2;
    }

    @Test
    void three_ball(){
        List<Integer> computer = new ArrayList<>();
        computer.add(3);
        computer.add(6);
        computer.add(9);

        int[] input = new int[3];
        input[0] = 9;
        input[1] = 3;
        input[2] = 6;

        int ballCount = 0;
        for(int i = 0; i<3;i++){
            if(computer.contains(input[i])){
                ballCount++;
            }
        }
        assert ballCount == 3;
    }

    @Test
    void one_ball_one_strike(){
        List<Integer> computer = new ArrayList<>();
        computer.add(3);
        computer.add(6);
        computer.add(9);

        int[] input = new int[3];
        input[0] = 3;
        input[1] = 8;
        input[2] = 6;

        Result result = calculateBallAndStrike(computer, input);

        assert result.ballCount == 1;
        assert result.strikeCount == 1;
    }

    private static Result calculateBallAndStrike(List<Integer> computer, int[] input) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < input.length; i++) {
            // 변수 할당
            boolean ballCheck = computer.contains(input[i]);
            boolean strikeCheck = computer.get(i) == input[i];

            if (ballCheck && strikeCheck) {
                strikeCount++;
            }else if (ballCheck) {
                ballCount++;
            }
        }

        return new Result(ballCount, strikeCount);
    }

    // 결과 DTO를 하나 만들자
    static class Result {
        int ballCount;
        int strikeCount;

        Result(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }


}
