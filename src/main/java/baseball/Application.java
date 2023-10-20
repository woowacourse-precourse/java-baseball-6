package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        startBaseballGame(true);
    }

    public static void startBaseballGame(boolean isFirstGame) {
        Queue<Integer> balls = new LinkedList<>();
        while (balls.size() < 3) {
            int ball = Randoms.pickNumberInRange(1, 9);
            if (balls.contains(ball)) {
                continue;
            }
            balls.add(ball);
        }
        String ballsOfComputer = balls.stream().map(Object::toString).collect(Collectors.joining());
        System.out.println("ballsOfComputer = " + ballsOfComputer);

        if (isFirstGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        //입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);

        //판별하기
        if (input.equals(ballsOfComputer)) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            //@todo: 종료 기능 구현하기
        } else if (balls.stream().map(Object::toString).noneMatch(input::contains)) {
            System.out.println("낫싱");
        } else if (!input.equals(ballsOfComputer)){
            checkBalls(ballsOfComputer, input);
        }

    }

    private static void checkBalls(String balls, String input) {
        int strikeCount = 0;
        ArrayList<Integer> strikeIndex = new ArrayList<>();
        for (int i = 0; i < balls.length(); i++) {
            if (balls.charAt(i) == input.charAt(i)) {
                strikeCount += 1;
                strikeIndex.add(i);
            }
        }

        int ballCount = 0;
        for (int i = 0; i < balls.length(); i++) {
            if(strikeIndex.contains(i)) continue;
            if (balls.contains(String.valueOf(input.charAt(i)))) {
                ballCount += 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(ballCount > 0) stringBuilder.append(ballCount + "볼 ");
        if(strikeCount > 0) stringBuilder.append(strikeCount + "스트라이크");
        System.out.println(stringBuilder);
    }

    public static void validateInput(String input) {
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
        return Arrays.stream(splitedData).map(Integer::parseInt).anyMatch((number) -> number < 1);
    }

    public static boolean isDuplicate(String data) {
        long count = data.chars().distinct().count();
        return count != 3;
    }
}
