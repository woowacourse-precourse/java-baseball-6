package baseball.game;

import baseball.Key;
import baseball.object.Computer;
import baseball.object.User;
import camp.nextstep.edu.missionutils.Console;

public class RunGame {

    private final Print print;

    public RunGame(Print print) {
        this.print = print;
    }

    public void startGame() {
        print.printStart();

        while(true) {
            runBaseBallGame();
            if(!wantToRestartOrEnd())
                break;
        }
    }

    private void runBaseBallGame() {
        new Computer();

        while (true) {
            print.printInputNumber();
            User.getUserAnswer();
            Game.compareNumber(User.getAnswer());
            if(print.printResult())
                break;
        }
    }

    private boolean wantToRestartOrEnd() {
        print.printWantToRestartOrEnd();
        String answer = Console.readLine();

        if(!isRightAnswer(answer))
            throw new IllegalArgumentException("잘못된 수를 입력하였습니다.");

        return answer.equals(Key.RESTART);      //1일 경우 게임을 재시작합니다.
    }

    private boolean isRightAnswer(String answer) {
        return answer.equals(Key.RESTART) || answer.equals(Key.END);
    }

}
