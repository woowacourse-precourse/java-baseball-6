package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static final int BALL = 1;
    public static final int STRIKE = 2;
    public static final int NOTHING = 3;
    public static final int RESTART = 1;
    public static final int LENGTH = 3;


    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }


    public static Integer ballOrStrike(int idx, char userInput, List<Integer> answer) {
        int result = NOTHING;
        int curInput = userInput - '0';
        if (answer.contains(curInput)) {
            result = BALL;
        }
        if (answer.get(idx) == curInput) {
            result = STRIKE;
        }
        return result;
    }

    public static boolean evaluator(String userInput, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userInput.length(); i++) {
            char curInput = userInput.charAt(i);
            int result = ballOrStrike(i, curInput, answer);
            if (result == BALL) {
                ball++;
            }
            if (result == STRIKE) {
                strike++;
            }
        }
        return replyToUser(strike, ball);
    }

    public static boolean replyToUser(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        return true;
    }

    public static boolean isGameRestart(String userRestart) {
        if (userRestart.charAt(0) - '0' == RESTART) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameRestart = true;
        while (isGameRestart) {
            List<Integer> answer = getAnswer();
            boolean isIncorrect = true;
            while (isIncorrect) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                isIncorrect = evaluator(userInput, answer);
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userRestart = Console.readLine();
            isGameRestart = isGameRestart(userRestart);

        }

    }
}

