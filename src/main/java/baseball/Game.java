package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    // generateNum
    public static final int SIZE = 3;
    public static final int MIN_NUM = 3;
    public static final int MAX_NUM = 3;

    List<Integer> answerNum;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerNum = generateAnswer();
    }

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < SIZE) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }

    public void playGame() {

    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        return input;
    }

    public List<Integer> convertStringInputToIntegerList(String stringInput) {
        List<Integer> integerInputList = new ArrayList<>();
        if (stringInput.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }
        for (int i = 0; i < stringInput.length(); i++) {
            int number = stringInput.charAt(i) - '0';
            if (number <= 0 || number >= 20) {
                throw new IllegalArgumentException("숫자는 1~9 사이여야 합니다.");
            }
            integerInputList.add(number);
        }
        return integerInputList;
    }

    public boolean isCorrect(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public void getStrikeBallCount() {

    }

    public int getStrikeCount(List<Integer> input, List<Integer> answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (input.get(i) == answer.get(i)) {
                count++;
            }
        }
        return count;
    }

    public int getBallCount(List<Integer> input, List<Integer> answer) {

    }

    public void printResult() {

    }

    public void checkFinish() {

    }

}
