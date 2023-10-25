package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.GameResultPrinter.printAnswerHint;
import static baseball.InputValidator.*;
import static baseball.RandomNumberGenerator.makeRandomNumber;

public class Application {
    private static String randomNumber;
    public static String inputNumber;
    public static int ball;
    public static int strike;
    private static boolean isOver;
    private static String restartOrEndFlag;
    private static boolean isSucceed;
    private static final String RESTART = "1";
    private static final String TERMINATE = "2";

    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현
        isOver = false;
        while (!isOver) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            randomNumber = makeRandomNumber();
            isSucceed = false;
            while (!isSucceed) {
                System.out.print("숫자를 입력해주세요 : ");
                inputNumber = Console.readLine();
                isValidInteger();
                isThreeDigitNumber();
                hasDuplicateDigits();
                printAnswerHint();
                isSucceed();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartOrEndFlag = Console.readLine();
            isValidTerminationChoice();
            isOver();
        }
    }

    public static int calculateStrikeCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if(randomNumber.charAt(i) == inputNumber.charAt(i)) {
                cnt++;
            };
        }
        return cnt;
    }

    public static int calculateBallCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(inputNumber.substring(i, i + 1))
                 && randomNumber.charAt(i) != inputNumber.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void isSucceed() {
        if (strike == 3) {
            isSucceed = true;
        }
    }

    public static void isValidTerminationChoice() {
        if (!(restartOrEndFlag.equals(TERMINATE) || restartOrEndFlag.equals(RESTART))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isOver() {
        if (restartOrEndFlag.equals(TERMINATE)) {
            isOver = true;
        }
    }


}