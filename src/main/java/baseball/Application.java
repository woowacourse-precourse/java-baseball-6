package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        startBaseballGame();
    }

    public static void startBaseballGame() {
        Queue<Integer> balls = new LinkedList<>();
        while (balls.size() < 3) {
            int ball = Randoms.pickNumberInRange(1, 9);
            if (balls.contains(ball)) {
                continue;
            }
            balls.add(ball);
        }

        balls.forEach(System.out::println);

        System.out.println("숫자 야구 게임을 시작합니다.");

        //입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
    }

    public static void validateInput(String input){
        if (!is3Length(input) || isNan(input) || isLessThan1(input) || isDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean is3Length(String data) {
        return data.length() == 3;
    }
    public static boolean isNan(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }
    public static boolean isLessThan1(String data) {
        String[] splitedData = data.split("");
        return Arrays.stream(splitedData).map(Integer::parseInt).anyMatch((number)-> number < 1);
    }

    public static boolean isDuplicate(String data) {
        long count = data.chars().distinct().count();
        return count != 3;
    }
}
