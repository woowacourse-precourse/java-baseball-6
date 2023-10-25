package baseball;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameProcess {
    ComAnswer comAnswer = new ComAnswer(createComAnswer());
    UserAnswer userAnswer = new UserAnswer("123");

    List<Integer> createComAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer;
    }

    String createUserAnswer() {
        out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    void changeComAnswer() {
        comAnswer.clear();
        comAnswer.changeValue(createComAnswer());
    }

    void changeUserAnswer() {
        userAnswer.clear();
        userAnswer.changeValue(createUserAnswer());
    }

    void deleteValues() {
        comAnswer.clear();
        userAnswer.clear();
    }

    boolean determine() {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < userAnswer.getSize(); i++) {
            if (comAnswer.isContain(userAnswer.getValue(i)) && comAnswer.getValue(i) == userAnswer.getValue(i)) {
                strike++;
            } else if (comAnswer.isContain(userAnswer.getValue(i)) && comAnswer.getValue(i) != userAnswer.getValue(i)) {
                ball++;
            }
        }
        return printResult(ball, strike);
    }

    boolean printResult(int ball, int strike) {
        boolean result = false;
        if (ball == 0 && strike == 0) {
            out.println("낫싱");
        } else if (ball != 0 && strike == 0) {
            out.println(ball + "볼");
        } else if (ball == 0 && strike < 3) {
            out.println(strike + "스트라이크");
        } else if (ball != 0 && strike < 3) {
            out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 3) {
            out.println(strike + "스트라이크");
            out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            result = true;
        }
        return result;
    }

    boolean endGame() {
        boolean result = true;
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameStatus = Console.readLine();
        if (gameStatus.equals("1")) {
            result = false;
        } else if (gameStatus.equals("2")) {
            result = true;
        }
        return result;
    }
}
