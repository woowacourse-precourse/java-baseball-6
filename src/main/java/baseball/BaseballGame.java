package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGame {

    public static final int RESTART_OPERATION = 1;
    public static final int EXIT_OPERATION = 2;
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    int exitNumber, strikeNumber, ballNumber;
    List<Integer> answerNumber;
    List<Integer> expectedNumber;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        resetGame();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            readExpectedNumber(readLine());

            //computeAnswer();

            if (isCompleted() && isExit()) {
                return;
            }
        }
    }

    private void resetGame() {
        makeAnswerNumber();
        exitNumber = 0;
        strikeNumber = 0;
        ballNumber = 0;
    }

    public void makeAnswerNumber() {
        answerNumber = new ArrayList<>();

        while (answerNumber.size() < BASEBALL_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
        // System.out.println(answerNumber.toString());
    }

    public void readExpectedNumber(String input) {
        expectedNumber = inputToExpectedNumber(input);

        if (expectedNumber.size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_LENGTH + "자리 수를 입력해야 합니다.");
        }
        if (expectedNumber.contains(0)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        if (isDuplicated(expectedNumber)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public List<Integer> inputToExpectedNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        int temp = 0;

        try {
            temp = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        while (temp > 0) {
            numbers.add(0, temp % 10);
            temp /= 10;
        }
        return numbers;
    }

    public Boolean isDuplicated(List<Integer> number) {
        for (int i = 0; i < number.size(); i++) {
            int duplication = Collections.frequency(number, number.get(i));
            if (duplication > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isCompleted() {
        return strikeNumber == BASEBALL_NUMBER_LENGTH;
    }

    public boolean isExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        readExitNumber(readLine());

        switch (exitNumber) {
            case RESTART_OPERATION:
                resetGame();
                break;
            case EXIT_OPERATION:
                return true;
            default:
                throw new IllegalArgumentException(RESTART_OPERATION + " 또는 " + EXIT_OPERATION + "를 입력해야 합니다.");
        }
        return false;
    }

    public void readExitNumber(String input) {
        try {
            exitNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
