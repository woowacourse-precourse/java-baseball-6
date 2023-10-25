package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Core core = new Core();

    public void start() {
        List<Integer> computerNumber = new ArrayList<>();
        int[] digits;
        int strikeCount;
        int ballCount;
        boolean isEnd = false;
        int isRestart = 0;

        startGame();
        Utils.getRandomNumber(computerNumber);

        while (!isEnd) {
            // 플레이어의 숫자 입력
            digits = getUserInput();

            // 스트라이크 검사
            strikeCount = core.getStrikeCount(computerNumber, digits);

            // 볼 검사
            ballCount = core.getBallCount(computerNumber, digits, strikeCount);

            // 입력된 숫자에 대한 결과 출력
            core.printResult(strikeCount, ballCount);

            // 게임의 종료 조건 검사
            isEnd = core.isEnd(strikeCount);

            // 게임 종료시, 재시작 여부를 묻는 코드
            if (isEnd) {
                isRestart = isRestart();
            }

            // 재시작으로 결정한 경우
            if (isRestart == 1) {
                isEnd = false;
                isRestart = 0;
                Utils.getRandomNumber(computerNumber);
            }
        }
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static int[] getUserInput() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int[] digits = Utils.convertStringToInt(input);
        int[] distinctDigits = Arrays.stream(digits).distinct().toArray();

        // IllegalArgumentException을 발생시켜야 하는 경우
        // 3자리 숫자가 아닐 경우 or 서로 다른 숫자가 아닐 경우
        if (digits.length != 3 || distinctDigits.length != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자가 아닙니다.");
        }
        return digits;
    }

    public static int isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        int[] digits = Utils.convertStringToInt(input);
        if (digits.length != 1 || (digits[0] != 1 & digits[0] != 2)) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
        return digits[0];
    }
}