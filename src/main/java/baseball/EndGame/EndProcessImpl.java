package baseball.EndGame;

import baseball.ProcessGame.BaseBallGame;
import baseball.ProcessGame.BaseBallGameImpl;
import camp.nextstep.edu.missionutils.Console;

public class EndProcessImpl implements EndProcess {

    private static BaseBallGame baseBallGame = new BaseBallGameImpl();
    public static Boolean isEnd = false;

    @Override
    public void userChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            ValidateUserChoice(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            Console.close();
        }
    }

    @Override
    public void ValidateUserChoice(String userChoice) {
        if (userChoice.equals("1")) {
            baseBallGame.initGame();
            return;
        } else if (userChoice.equals("2")) {
            isEnd = true;
            return;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }
}
