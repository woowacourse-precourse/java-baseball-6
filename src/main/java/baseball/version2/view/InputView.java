package baseball.version2.view;

import static baseball.version2.Constants.Phrases.INSERT_ANSWER_PHRASES;
import static baseball.version2.Constants.Phrases.SELECT_CONTINUE_PHRASES;

import baseball.version2.DataValidator;
import baseball.version2.dto.PlayerAnswerDto;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final DataValidator dataValidator;


    public InputView() {
        this.dataValidator = new DataValidator();
    }

    public PlayerAnswerDto getPlayerAnswer(int arraySize) {
        PlayerAnswerDto playerAnswer = new PlayerAnswerDto();
        System.out.print(INSERT_ANSWER_PHRASES);
        String inputValue = Console.readLine();
        String[] answerStringArray = inputValue.split("");
        int[] answerArray = new int[arraySize];
        answerArray = dataValidator.validateIsNumberAndSize(answerStringArray, answerArray);
        dataValidator.validatePlayerAnswer(answerArray);
        playerAnswer.setAnswer(answerArray);
        return playerAnswer;
    }


    public int getPlayerDecision() {
        System.out.println(SELECT_CONTINUE_PHRASES);
        String playerDecision = Console.readLine();
        int decision = dataValidator.validateDecisionIsNumber(playerDecision);
        dataValidator.validateDecision(decision);

        return decision;
    }


}
