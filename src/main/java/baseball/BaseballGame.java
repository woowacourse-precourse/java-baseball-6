package baseball;

import baseball.constants.Messages;
import baseball.utils.AnswerGenerator;
import baseball.utils.UserInputReceiver;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private List<Integer> generatedAnswers;

    public void run() {
        System.out.println(Messages.GAME_START_MESSAGE);
        do {
            generatedAnswers = AnswerGenerator.generateAnswers();
            UserInputReceiver.getUserGuessInput(generatedAnswers);
        } while(UserInputReceiver.getUserRestartInput());

        Console.close();
    }
}
