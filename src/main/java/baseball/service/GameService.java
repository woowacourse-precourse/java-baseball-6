package baseball.service;

import baseball.util.ComputerUtil;
import baseball.util.MessageConverter;
import baseball.util.UserUtil;
import baseball.validation.InputNumberValidator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameService {

    private static final String END = "2";
    private static List<Integer> computerNumber;

    private final ComputerUtil computerUtil = new ComputerUtil();
    private final UserUtil userUtil = new UserUtil();
    private final MessageConverter messageConverter = new MessageConverter();
    private final InputNumberValidator inputNumberValidator = new InputNumberValidator();

    /*
     * 게임 초기설정 메서드
     * */
    public void setGame() {
        computerNumber = computerUtil.generateComputerNumber();
    }

    /*
     * 게임 진행 메서드
     * */
    public String playGame() {
        String userInput = userUtil.getUserInput();
        inputNumberValidator.validateInputNumber(userInput);
        List<Integer> userInputList = messageConverter.convertStrToList(userInput);
        Map<String, Integer> resultMessageMap = messageConverter.getResultMessage(userInputList, computerNumber);

        return messageConverter.getResultMessageToString(resultMessageMap);
    }

    /*
     * 게임 종료 메서드
     * true : 게임 종료 false : 재시작
     * */
    public boolean stopGame() {
        String userInput = userUtil.getUserInput();
        inputNumberValidator.validateGameStateInput(userInput);

        return Objects.equals(userInput, END);
    }
}
