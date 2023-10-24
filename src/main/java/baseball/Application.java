package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int CAPACITY = 3;

    static void pickNumber(List<Integer> computer) {
        while (computer.size() < CAPACITY) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static List<Integer> readInput() {
        String input = Console.readLine();
        List<Integer> player = new ArrayList<>();

        ExceptionHandler.checkInputSize(input, CAPACITY);
        for (int i = 0; i < CAPACITY; ++i) {
            int number = input.charAt(i) - '0';

            ExceptionHandler.checkNumber(number, player);
            player.add(number);
        }
        return player;
    }

    static Result evaluate(List<Integer> player, List<Integer> computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < CAPACITY; ++i) {
            int playerNumber = player.get(i);

            if (computer.get(i) == playerNumber) {
                ++strike;
            } else if (computer.contains(playerNumber)) {
                ++ball;
            }
        }
        return new Result(ball, strike);
    }

    static void printResult(Result result) {
        int ball = result.getBall();
        int strike = result.getStrike();

        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    static boolean readCommand() {
        String input = Console.readLine();

        ExceptionHandler.checkInputSize(input, 1);
        char command = input.charAt(0);

        ExceptionHandler.checkCommand(command);
        return command == '2';
    }

    static boolean isStop(Result result, List<Integer> computer) {
        if (result.getStrike() == CAPACITY) {
            computer.clear();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return readCommand();
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();

        while (true) {
            pickNumber(computer);
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> player = readInput();
            Result result = evaluate(player, computer);

            printResult(result);
            if (isStop(result, computer)) {
                break;
            }
        }
    }
}