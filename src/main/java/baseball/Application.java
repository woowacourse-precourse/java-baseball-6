package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.*;


public class Application {
    static List<Integer> answer;
    static String input;
    static int again;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            answer = generateRandom();
            input = readLine();

            if (!illegalArgument(input))
                throw new IllegalArgumentException("잘못된 값 출력에 의한 종료!");

            while (!correct(input)) {
                System.out.print("숫자를 입력해주세요 : ");
                input = readLine();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            again = parseInt(readLine());

            if (again == 2) break;
            else
                throw new IllegalArgumentException("잘못된 값 출력에 의한 종료!");
        }
    }

    private static boolean illegalArgument(String input) {
        return input.length() == 3 &&
                input.charAt(0) != input.charAt(1) &&
                input.charAt(1) != input.charAt(2) &&
                input.charAt(0) != input.charAt(2);
    }

    private static boolean correct(String input) {
        int strike = 0;
        int ball   = 0;

        for (int i = 0; i < 3; i++) {
            int num = input.charAt(i) - '0';

            if (answer.contains(num)) {
                if (i == answer.indexOf(num)) ++strike;
                else ++ball;
            }
        }

        return printScore(ball, strike);
    }

    private static boolean printScore(int ball, int strike) {
        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        if (ball > 0)
            System.out.printf("%d볼 ", ball);
        if (strike > 0)
            System.out.printf("%d스트라이크", strike);
        System.out.println();

        return strike == 3;
    }

    private static List<Integer> generateRandom() {
        List<Integer> computer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(num))
                computer.add(num);
        }

        return computer;
    }
}
