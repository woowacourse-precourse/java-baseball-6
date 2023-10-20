package baseball.EndGame;

import baseball.ProcessGame.BaseBallGame;
import baseball.ProcessGame.BaseBallGameImpl;
import camp.nextstep.edu.missionutils.Console;

public class EndProcessImpl implements EndProcess {

    private static final BaseBallGame baseBallGame = new BaseBallGameImpl();

    @Override
    public void userChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        ValidateUserChoice(Console.readLine());
    }

    @Override
    public void ValidateUserChoice(String userChoice) {
        if (userChoice.equals("1")) {
            baseBallGame.initGame();
            return;
        } else if (userChoice.equals("2")) {
            System.out.println("게임을 종료합니다.");
            return;
        }
        throw new IllegalStateException("1 또는 2를 입력해주세요.");
    }
}
