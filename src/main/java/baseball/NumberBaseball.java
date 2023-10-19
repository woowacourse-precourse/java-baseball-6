package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class NumberBaseball {

    private int[] answer;
    private boolean[] generatedNumberFlag;

    public NumberBaseball() {
        this.generatedNumberFlag = new boolean[10];
        this.answer = new int[3];
    }

    public void generateAnswerNumber() {
        for(int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if(this.generatedNumberFlag[number]) {
                i--;
                continue;
            }
            answer[i] = number;
            generatedNumberFlag[number] = true;
        }
    }


    public GuessResult countResult(int[] input) {
        int balls = 0;
        int strikes = 0;

        for(int i = 0; i < 3; i++) {
            if(Arrays.asList(answer).contains(input[i])) {
                balls++;
            }
            if(answer[i] == input[i]) {
                strikes++;
            }
        }

        balls -= strikes;
        return new GuessResult(strikes, balls);
    }


}
