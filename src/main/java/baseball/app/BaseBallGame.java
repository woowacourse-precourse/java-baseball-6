package baseball.app;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private final static String CONTINUE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final BaseBallService baseBallService;

    public BaseBallGame() {
        this.baseBallService = new BaseBallService();
    }

    public void run() {
        do {
            baseBallService.exec();
        } while (isContinue());
    }

    public boolean isContinue() {
        System.out.println(CONTINUE_GAME_MESSAGE);
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        return false;
    }
}
