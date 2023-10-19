package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class NumberBaseball {

    private int[] answer;
    private boolean[] generatedNumberFlag;

    public NumberBaseball() {
        this.generatedNumberFlag = new boolean[10];
        this.answer = new int[3];
        generateAnswerNumber();
    }

    public void generateAnswerNumber() {
        for (int i = 0; i < 3; i++) {
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

        List<Integer> inputList = Arrays.stream(answer).boxed().collect(Collectors.toList());
        for (int i = 0; i < 3; i++) {
            if(inputList.contains(input[i])) {
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
