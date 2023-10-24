package baseball;

import baseball.game.GameNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    private static final int NUMBER_SIZE = 3;
    private static boolean GAME_MODE = true;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (GAME_MODE) {
            List<Integer> computerNumber = GameNumber.generateNumbers();
            List<Integer> userNumber;
            Result result;

            while (true) {
                userNumber = readUserNumber();
                result = compare(computerNumber, userNumber);
                result.print();
                if (gameOver(result)) {
                    GAME_MODE = restart();
                    break;
                }
            }
        }
    }

    private static List<Integer> readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String answer = Console.readLine().strip();

        if (answer.length() != NUMBER_SIZE || !isNumber(answer)) {
            throw new IllegalArgumentException("3개의 숫자를 연속해서 입력하세요.");
        }
        return convertToList(answer);
    }

    private static boolean isNumber(String userNumber) {
        for (char ch : userNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> convertToList(String number) {
        List<Integer> userNumber = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            userNumber.add(ch - '0');
        }
        return userNumber;
    }

    private static boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String answer = Console.readLine();

        if (answer.length() != 1 || !Character.isDigit(answer.charAt(0))) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }

        if (answer.charAt(0) == '2') {
            return false;
        }

        if (answer.charAt(0) == '1') {
            return true;
        }

        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }

    private static boolean gameOver(Result result) {
        return result.strike == NUMBER_SIZE;
    }

    private static Result compare(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (Objects.equals(computerNumber.get(index), userNumber.get(index))) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(index))) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }
}


class Result {
    int strike;
    int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(String.format("%d볼", this.ball));
        }
        if (strike != 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(String.format("%d스트라이크", this.strike));
        }

        if (result.isEmpty()) {
            result.append("낫싱");
        }

        System.out.println(result);
    }
}
