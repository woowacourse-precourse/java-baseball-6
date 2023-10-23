package baseball.version2.view;

import static baseball.version2.constants.Phrases.INSERT_ANSWER_PHRASES;
import static baseball.version2.constants.Phrases.SELECT_CONTINUE_PHRASES;

import baseball.version2.dto.PlayerAnswerDto;
import baseball.version2.tools.Converter;
import baseball.version2.tools.DataValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final DataValidator dataValidator;
    private final Converter converter;

    public InputView() {
        this.dataValidator = new DataValidator();
        this.converter = new Converter();
    }

    public PlayerAnswerDto getPlayerAnswer(int arraySize) {
        System.out.print(INSERT_ANSWER_PHRASES);

        String inputValue = Console.readLine();
        int[] answerArray = convertPlayerInput(arraySize, inputValue);
        dataValidator.validatePlayerAnswer(answerArray);

        PlayerAnswerDto playerAnswer = new PlayerAnswerDto();
        playerAnswer.setAnswer(answerArray);
        return playerAnswer;
    }

    private int[] convertPlayerInput(int arraySize, String inputValue) {
        String[] answerStringArray = inputValue.split("");
        int[] answerArray = new int[arraySize];

        answerArray = converter.convertStringToArray(answerStringArray, answerArray);
        return answerArray;
    }

    public int getPlayerDecision() {
        System.out.println(SELECT_CONTINUE_PHRASES);

        String playerDecision = Console.readLine();
        int decision = converter.convertStringToInt(playerDecision);

        dataValidator.validateDecision(decision);
        return decision;
    }

}
