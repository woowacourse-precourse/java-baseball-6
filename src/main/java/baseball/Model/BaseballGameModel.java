package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {
    private int[] answer;

    public BaseballGameModel() {
        generateRandomAnswer();
    }

    public void generateRandomAnswer() {
        answer = new int[3];
        List<Integer> availableNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < 3; i++) {
            int randomIndex = Randoms.pickNumberInRange(0, availableNumbers.size() - 1);
            answer[i] = availableNumbers.remove(randomIndex);
        }
    }

    public int[] getAnswer() {
        return answer;
    }

    public String guess(int[] guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                strikes++;
            } else if (contains(guess[i])) {
                balls++;
            }
        }

        if (strikes == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        int[] result = new int[]{strikes, balls};
        return formatResult(result);
    }



    private boolean contains(int number) {
        for (int num : answer) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    private String formatResult(int[] result) {
        StringBuilder formattedResult = new StringBuilder();
        boolean hasOutput = false;

        if (result[1] > 0) {
            formattedResult.append(result[1]).append("볼");
            hasOutput = true;
        }

        if (result[1] > 0 && result[0] > 0) {
            formattedResult.append(" ");
        }

        if (result[0] > 0) {
            formattedResult.append(result[0]).append("스트라이크");
            hasOutput = true;
        }

        if (!hasOutput) {
            formattedResult.append("낫싱");
        }

        return formattedResult.toString();
    }

}