package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);

        boolean whetherPlay = true;
        while (whetherPlay) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

            System.out.println(GAME_RESTART_MESSAGE);
            String inputRestartString = Console.readLine();
            // TODO: 입력값에 대한 유효성 검증 필요
            int inputRestart = Integer.parseInt(inputRestartString);

        }

    }

}
