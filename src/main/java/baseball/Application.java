package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private static boolean isAnswer = false;
    public static List<Integer> answer = new ArrayList<>();
    public static List<Integer> userAnswer = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        int userInput;
        do {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                userInput = Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        } while (userInput != 2);
    }

    private static void startGame() {
        initGame();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            readAnswer();
            calculateAnswer();
            if (isAnswer) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static void initGame() {
        setRandomAnswer();
        userAnswer.clear();
        isAnswer = false;
    }

    private static void setRandomAnswer() {
        answer.clear();
        while (answer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
    }

    private static void readAnswer() {
        userAnswer.clear();
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            int num = input.charAt(i) - '0';
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
            if (userAnswer.contains(num)) {
                throw new IllegalArgumentException();
            }
            userAnswer.add(num);
        }
    }

    private static void calculateAnswer() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userAnswer.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(userAnswer.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크 ");
            }
        }
        System.out.println();

        if (strike == 3) {
            isAnswer = true;
        }
    }
}
