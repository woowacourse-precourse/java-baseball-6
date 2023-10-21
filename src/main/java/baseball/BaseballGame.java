package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    private static final int DIGIT = 3;
    private static final int MAX_NUMBER = 999;
    private static final int MIN_NUMBER = 100;
    private static int answer;

    private BaseballGame() {
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            answer = makeRandomUniqueNumber();
            play();
        } while (reGame());
    }

    private static void play() {
        int userAnswer;

        do {
            userAnswer = getUserAnswer();
        } while (!checkUserAnswer(userAnswer));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static int makeRandomUniqueNumber() {
        int num;

        do {
            num = makeRandomNumber();
        } while (!isUniqueDigitNumber(num));

        return num;
    }

    private static int getUserAnswer() {
        int userAnswer;

        System.out.print("숫자를 입력해주세요 : ");

        userAnswer = Integer.parseInt(Console.readLine());
        if (!validUserAnswer(userAnswer)) {
            throw new IllegalArgumentException();
        }

        return userAnswer;
    }

    private static boolean checkUserAnswer(int userAnswer) {
        int strike = checkStrike(userAnswer, answer);
        int ball = checkBall(userAnswer, answer, strike);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        return strike == DIGIT;
    }

    private static boolean reGame() {
        int reGame;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            reGame = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (reGame == 1) {
            return true;
        } else if (reGame == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private static int checkStrike(int userAnswer, int answer) {
        int strike = 0;

        for (int i = 0; i < DIGIT; i++) {
            if (userAnswer % 10 == answer % 10) {
                strike++;
            }
            userAnswer /= 10;
            answer /= 10;
        }

        return strike;
    }

    private static int checkBall(int userAnswer, int answer, int strike) {
        Set<Integer> userSet = new HashSet<>();
        Set<Integer> answerSet = new HashSet<>();

        for (int i = 0; i < DIGIT; i++) {
            userSet.add(userAnswer % 10);
            userAnswer /= 10;
        }
        for (int i = 0; i < DIGIT; i++) {
            answerSet.add(answer % 10);
            answer /= 10;
        }

        answerSet.retainAll(userSet);

        return answerSet.size() - strike;
    }

    private static boolean validUserAnswer(int userAnswer) {
        return isInRange(userAnswer)
                && isUniqueDigitNumber(userAnswer);
    }

    private static boolean isInRange(final int num) {
        return num >= BaseballGame.MIN_NUMBER && num <= BaseballGame.MAX_NUMBER;
    }

    private static boolean isUniqueDigitNumber(int num) {
        Set<Integer> set = new HashSet<>();

        while (num != 0) {
            set.add(num % 10);
            num /= 10;
        }

        return set.size() == DIGIT;
    }

    private static int makeRandomNumber() {
        int[] nums = new int[DIGIT];
        int num = 0;

        for (int idx = 0; idx < DIGIT; idx++) {
            nums[idx] = Randoms.pickNumberInRange(1, 9);
        }

        for (int idx = 0; idx < DIGIT; idx++) {
            num += nums[idx] * Math.pow(10, DIGIT - idx - 1);
        }
        return num;
    }
}
