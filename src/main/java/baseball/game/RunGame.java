package baseball.game;

import baseball.Key;
import baseball.object.Computer;
import baseball.object.Hint;
import baseball.object.User;
import camp.nextstep.edu.missionutils.Console;

public class RunGame {

    private final Print print;
    private final Computer computer;
    private final User user;

    public RunGame(Print print, Computer computer, User user) {
        this.print = print;
        this.computer = computer;
        this.user = user;
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
        computer.generateNumber();

        while (true) {
            print.printInputNumber();
            user.inputAnswer();
            Hint hint = computer.compareNumber(user.getAnswer());
            if(print.printResult(hint))
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
