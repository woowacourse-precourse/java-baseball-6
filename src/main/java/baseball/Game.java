package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    // generateNum
    public static final int SIZE = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

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
        while (true) {
            List<Integer> input = convertStringInputToIntegerList(getInput());
            boolean correctAnswer = checkStrikeBallCount(answerNum, input);
            if (correctAnswer) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        return input;
    }

    public List<Integer> convertStringInputToIntegerList(String stringInput) {
        List<Integer> integerInputList = new ArrayList<>();
        if (stringInput.length() != SIZE) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }
        for (int i = 0; i < stringInput.length(); i++) {
            int number = stringInput.charAt(i) - '0';
            if (number <= 0 || number >= 10) {
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

    public boolean checkStrikeBallCount(List<Integer> input, List<Integer> answer) {
        int strike = getStrikeCount(input, answer);
        int ball = getBallCount(input, answer);
        printResult(strike, ball);
        return isCorrect(strike);
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
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int num = answer.get(i);
            if (input.contains(num) && input.get(i) != answer.get(i)) {
                count++;
            }
        }
        return count;
    }

    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        }
    }

    public boolean checkFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        if (input.equals("1")) {
            return false;
        }
        return true;
    }

}
