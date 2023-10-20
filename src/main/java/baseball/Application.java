package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseballGame game = new NumberBaseballGame();
        boolean startGame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (startGame) {
            game.start();
            String input = Console.readLine();
            if (!NumberBaseballUtility.isValidChoice(input)) {
                throw new IllegalArgumentException();
            }
            if (input.equals("2")) {
                startGame = false;
            }
        }
    }
}
