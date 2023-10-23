package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameApp {

    private boolean isPlay = true;
    private final BaseballGame baseballGame = new BaseballGame();

    public void runApp() {
        printGameStartMessage();
        while (isPlay) {
            baseballGame.init();
            baseballGame.playGame();
            setIsPlay(getIsPlay());
        }

    }

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void setIsPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }

    private boolean getIsPlay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
        return input.equals("1");
    }
}
