package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Application {

    private static int strike;
    private static int ball;
    public static void main(String[] args) throws IllegalArgumentException {
        int isContinue = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isContinue == 1) {
            //게임이 시작될 때, answer 새로 생성
            List<Integer> answer = initAnswer();

            //게임 진행 중
            playGame(answer);

            //추가 게임 진행 여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isContinue = Integer.parseInt(Console.readLine());
        }
    }

    private static List<Integer> initAnswer() {
        List<Integer> num = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int buf = 0;
            while (buf == 0) {
                buf = Randoms.pickNumberInRange(1, 9);
            }
            int selectedNum = num.get(buf);
            num.set(buf, 0);
            answer.add(selectedNum);
        }
        return answer;
    }

    private static void playGame(List<Integer> answer) {
        while (true) {
            initBallAndStrike();

            System.out.print("숫자를 입력해주세요 : ");

            int input = inputAnswer();

            //정답 계산 부분
            calculateAnswer(answer, input);

            //정답 여부 출력 부분
            if (printAnswer())
                break;
        }
    }

    private static void initBallAndStrike() {
        strike = 0;
        ball = 0;
    }

    private static int inputAnswer() {
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
            if (input > 999 || input < 100) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static void calculateAnswer(List<Integer> answer, int input) {
        for (int trial = 2; trial >= 0; trial--) {
            int remainder = input % 10;
            input /= 10;
            if (answer.contains(remainder))
                if (answer.get(trial) == remainder)
                    strike++;
                else
                    ball++;
        }
    }

    private static boolean printAnswer() {
        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        else {
            if (ball != 0)
                System.out.printf("%d볼 ", ball);
            if (strike != 0)
                System.out.printf("%d스트라이크", strike);
        }
        System.out.println();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}