package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    름
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAMEOVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int EXIT_CODE = 2;
    private static final int ALL_STRIKE = 3;

    public static void inputValidate(String line) {
        if (line == null || line.length() != 1 || !Character.isDigit(line.charAt(0)) || line.charAt(0) > '2') {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

        System.out.println(STARTING_MESSAGE);
        BaseballGame baseballGame = BaseballGame.getInstance();
        boolean isGameEnd = false;

        while (!isGameEnd) {
            baseballGame.inputNumbers();
            baseballGame.calculateScore();
            baseballGame.printGameScore();
            if (baseballGame.countStrike() != ALL_STRIKE) {
                continue;
            }

            System.out.println(GAMEOVER_MESSAGE);

            String line = Console.readLine();
            inputValidate(line);

            int code = Integer.parseInt(line);
            if (code == EXIT_CODE) {
                isGameEnd = true;
            } else {
                baseballGame.randomizeComputerNumber();
            }
        }
    }
}