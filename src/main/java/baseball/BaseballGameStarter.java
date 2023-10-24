package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameStarter {

    private static void validate(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
        int inputInt = input.charAt(0) - '0';
        if (inputInt != 1 && inputInt != 2) {
            throw new IllegalArgumentException("1 또는 2만 입력해 주세요.");
        }
    }

    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        validate(input);

        int inputInt = Integer.parseInt(input);
        return switch (inputInt) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalArgumentException();
        };
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean start = true;
        while (start) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
            start = this.isRestart();
        }
    }
}
