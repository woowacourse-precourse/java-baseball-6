package baseball.EndGame;

import static baseball.Message.EndProcessMsg.END;
import static baseball.Message.EndProcessMsg.END_PROMPT;
import static baseball.Message.EndProcessMsg.ERROR_PROMPT;
import static baseball.Message.EndProcessMsg.RESTART;
import static baseball.Message.EndProcessMsg.USER_CHOICE_PROMPT;

import baseball.Config.DiContainer;
import baseball.ProcessGame.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;

public class EndProcessImpl implements EndProcess {

    private static final BaseBallGame baseBallGame = DiContainer.getBaseBallGame();
    private static EndProcessImpl singleton;

    private EndProcessImpl() {
    }

    public static EndProcessImpl getSingleton() {
        if (singleton == null) {
            singleton = new EndProcessImpl();
        }
        return singleton;
    }


    @Override
    public void userChoice() {
        System.out.println(USER_CHOICE_PROMPT.getMsg());
        ValidateUserChoice(Console.readLine());
    }

    @Override
    public void ValidateUserChoice(String userChoice) {
        if (userChoice.equals(RESTART.getMsg())) {
            baseBallGame.initGame();
            return;
        } else if (userChoice.equals(END.getMsg())) {
            System.out.println(END_PROMPT.getMsg());
            return;
        }
        throw new IllegalStateException(ERROR_PROMPT.getMsg());
    }
}
