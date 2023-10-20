package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class NumberBaseball {

    private int[] answer;
    private boolean[] generatedNumberFlag;
    private GuessResult curState;

    public NumberBaseball() {
        this.generatedNumberFlag = new boolean[10];
        this.answer = new int[3];
        this.curState = new GuessResult(0, 0);
        generateAnswerNumber();
    }

    public boolean isEnd() {
        return curState.strikes() == 3 && curState.balls() == 0;
    }

    public String getResultMsg(int[] input) {
        countResult(input);

        if(curState.balls() == 0 && curState.strikes() == 0) {
            return "낫싱";
        }

        String resultMsg = "";
        if(curState.balls() > 0) {
            resultMsg += (curState.balls() + "볼");
        }
        if(curState.balls() > 0 && curState.strikes() > 0) {
            resultMsg += " ";
        }
        if(curState.strikes() > 0) {
            resultMsg += (curState.strikes() + "스트라이크");
        }

        return resultMsg;
    }

    private void generateAnswerNumber() {
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

    private void countResult(int[] input) {
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
        this.curState = new GuessResult(strikes, balls);
    }
}
