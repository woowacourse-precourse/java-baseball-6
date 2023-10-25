package baseball.runner;

import baseball.computer.Computer;
import baseball.player.Player;
import baseball.runner.dto.ResponseDto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Runner {
    private static final Player player = new Player();

    public static void run() {
        System.out.println("야구 게임을 시작합니다. ");

        while (true) {
            List<Integer> baseballNum = Computer.generateRandomNumbers();
            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = player.input();
                if (!isValidInput(input)) {
                    throw new IllegalArgumentException();
                }
                ResponseDto response = turnResult(baseballNum, input);
                printResult(response);
                if (response.getStrikeCount() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if ("2".equals(choice))
                break;
        }
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3)
            return false;
        for (char c : input.toCharArray())
            if (!Character.isDigit(c) || c == '0')
                return false;
        return input.chars().distinct().count() == 3;
    }

    private static ResponseDto turnResult(List<Integer> baseballNum, String input) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (baseballNum.get(i) == num)
                strikeCount++;
            else if (baseballNum.contains(num))
                ballCount++;
        }
        return ResponseDto.builder().ballCount(ballCount).strikeCount(strikeCount);
    }

    private static void printResult(ResponseDto response) {
        int strikeCount = response.getStrikeCount();
        int ballCount = response.getBallCount();
        if (strikeCount == 0 && ballCount == 0)
            System.out.println("낫싱");
        if (ballCount > 0)
            System.out.print(ballCount + "볼 ");
        if (strikeCount > 0)
            System.out.print(strikeCount + "스트라이크 ");
        System.out.println();
    }

}
