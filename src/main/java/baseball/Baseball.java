package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private static final int DIGIT_LENGTH = 3;
    private static final int START_NUM_OF_RANGE = 1;
    private static final int END_NUM_OF_RANGE = 9;
    private static final int MINIMUM_NUM = 123;
    private static final int MAXIMUM_NUM = 987;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void runGame() {
        System.out.println(START_MESSAGE);
        List<Integer> answer = generateRandomNum();
        System.out.println("answer = " + answer);

        while (true) {
            System.out.print(INPUT_MESSAGE);
            String inputString = Console.readLine();
            List<Integer> inputNum = convertStringToList(inputString);
            int strike = countBallAndStrike(inputNum, answer);
            if (isAnswer(strike))
                break;
        }
    }

    public List<Integer> generateRandomNum() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM_OF_RANGE, END_NUM_OF_RANGE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
//        return Randoms.pickUniqueNumbersInRange(1, 9, DIGIT_LENGTH);
    }

    public List<Integer> convertStringToList(String inputString) {
        List<Integer> inputList = new ArrayList<>();
        validateInput(inputString);

        for (int i = 0; i < DIGIT_LENGTH; i++) {
            char c = inputString.charAt(i);
            inputList.add(Character.getNumericValue(c));
        }

        return inputList;
    }

    // contains로 loop 대신하는 version
    public void validateInput(String inputString) {
        if (inputString.length() != DIGIT_LENGTH || inputString.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(inputString) < MINIMUM_NUM || Integer.parseInt(inputString) > MAXIMUM_NUM) {
            throw new IllegalArgumentException();
        }
    }

    // loop 도는 version
//    public static void validateInput(String inputString) {
//        if (inputString.length() != DIGIT_LENGTH)
//            throw new IllegalArgumentException();
//
//        for (int i = 0; i < DIGIT_LENGTH; i++) {
//            if (!Character.isDigit(inputString.charAt(i)))
//                throw new IllegalArgumentException();
//        }
//    }

    public boolean isAnswer(int strike) {
        if (strike == DIGIT_LENGTH) {
            System.out.println(END_MESSAGE);
            return true;
        }
        return false;
    }

    public int countBallAndStrike(List<Integer> inputNum, final List<Integer> answer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < DIGIT_LENGTH; i++) {
            int inputDigit = inputNum.get(i);
            int answerDigit = answer.get(i);
            if (inputDigit == answerDigit) {
                strike++;
            } else if (inputNum.contains(answerDigit)) {
                ball++;
            }
        }

        printResult(ball, strike);
        return strike;
    }

    private void printResult(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
