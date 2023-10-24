package baseball;

import baseball.constants.Constants;
import baseball.constants.Messages;
import baseball.utils.AnswerGenerator;
import baseball.utils.Convertor;
import baseball.utils.ScoreJudge;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> generatedAnswers;

    public void run() {
        System.out.println(Messages.GAME_START_MESSAGE);

        do {
            generatedAnswers = AnswerGenerator.generateAnswers();
            guess();
        } while(restart());

        Console.close();
    }

    public List<Integer> getGeneratedAnswers() {
        return generatedAnswers;
    }

    /**
     * (2) 사용자 입력
     */
    public void guess() throws IllegalArgumentException {
        String userInput = null;
        do {
            System.out.print(Messages.ENTER_USER_INPUT);
            userInput = Console.readLine();
            Validator.validateUserInput(userInput);
            System.out.println(ScoreJudge.judgeScore(generatedAnswers, userInput));
        } while (!isCorrectAnswer(userInput));
    }

    /**
     * (3) 정답 여부 판정
     */
    public boolean isCorrectAnswer(String userInput) {
        if (userInput.equals(Convertor.convertToString(generatedAnswers))) {
            System.out.println(Messages.GAME_COMPLETE_MESSAGE);
            return true;
        }
        return false;
    }

    /**
     * (4) 게임 재시작
     */
    public boolean restart() {
        System.out.println(Messages.GAME_CONTINUE_MESSAGE);
        String userInput = Console.readLine();

        Validator.validateRestartInput(userInput);

        if (userInput.equals(Constants.CODE_CONTINUE_GAME)) {
            return true;
        }
        return false;
    }
}
