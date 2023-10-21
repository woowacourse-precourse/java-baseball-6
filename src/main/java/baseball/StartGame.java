package baseball;

import static baseball.ExceptionHandling.checkDuplication;
import static baseball.ExceptionHandling.checkNumber;
import static baseball.ExceptionHandling.checkNumberSize;
import static baseball.ExceptionHandling.restartOrEnd;
import static baseball.FixedValue.CORRECT_ANSWER;
import static baseball.FixedValue.END_GAME;
import static baseball.FixedValue.INPUT_NUMBER_SIZE;
import static baseball.FixedValue.RESET_NUMBER;
import static baseball.FixedValue.USER_MAX_VALUE;
import static baseball.FixedValue.USER_MIN_VALUE;
import static baseball.FixedValue.WRONG_ANSWER;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class StartGame {
    static ArrayList<Integer> baseball = new ArrayList<>(INPUT_NUMBER_SIZE);

    public static void start() {
        int gameStart = RESET_NUMBER;
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 야구 게임을 시작 한 뒤에 종료하기 전까지 계속 한다.
        while (gameStart != END_GAME) {
            randomNumber();             // 숫자에 대한 랜덤값 넣기
            inputUserNumber();          // 유저가 숫자 정보를 입력

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String number = Console.readLine();
            restartOrEnd(number);       // 새로 시작 or 종료를 제외한 나머지 숫자가 들어가면 예외처리
            gameStart = Integer.parseInt(number);
        }
    }

    public static void randomNumber() {
        baseball.clear();       // ArrayList 안에 들어있는 값을 초기화한다.

        while (true) {
            int randomNumber = Randoms.pickNumberInRange(USER_MIN_VALUE, USER_MAX_VALUE);

            if (!baseball.contains(randomNumber)) {
                baseball.add(randomNumber);
            }

            if (baseball.size() == INPUT_NUMBER_SIZE) {
                return;
            }
        }
    }

    public static void inputUserNumber() {
        int result = RESET_NUMBER;

        // 3개의 스트라이크가 나올 때까지 게임은 돌아간다.
        while (result != CORRECT_ANSWER) {
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            checkNumber(number);                // 유저가 넣은 값에 대해 숫자가 맞는지?
            checkDuplication(number);           // 유저가 넣은 값에 대한 숫자가 중복이 없는지?
            checkNumberSize(number);            // 유저가 넣은 값에 대한 3자리 숫자가 맞는지?
            result = gameResult(number);
        }
    }

    public static int gameResult(String number) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < INPUT_NUMBER_SIZE; i++) {
            int count = number.charAt(i) - 48;

            if (baseball.contains(count)) {
                if (baseball.get(i) == count) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        printResult(strike, ball);

        if (strike == CORRECT_ANSWER) {
            return CORRECT_ANSWER;
        }

        return WRONG_ANSWER;
    }

    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼\n", ball);
        }
    }
}
