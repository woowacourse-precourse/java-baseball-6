package baseball.play;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class PlayGame {

    public final static String RESTART = "1";
    public final static String END = "2";

    private final Print print;
    private final Computer computer;
    private final User user;

    public PlayGame(Print print, Computer computer, User user) {
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
            if(Print.printResult(hint))
                break;
        }
    }

    private boolean wantToRestartOrEnd() {
        print.printWantToRestartOrEnd();
        String answer = Console.readLine();

//        if(!isRightAnswer(answer))
//            throw new IllegalArgumentException("잘못된 수를 입력하였습니다.");

        return answer.equals(RESTART);      //1일 경우 게임을 재시작합니다.
    }

    private boolean isRightAnswer(String answer) {
        return answer.equals(RESTART) || answer.equals(END);
    }

}
