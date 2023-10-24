package baseball.service;

import baseball.util.ComputerUtil;
import baseball.util.MessageConverter;
import baseball.util.UserUtil;
import baseball.validation.InputNumberValidator;
import baseball.view.InputView;

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
    private final InputView inputView = new InputView();

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
        String input = userUtil.getUserNumber();
        List<Integer> inputList = inputNumberValidator.validateInputNumber(input);
        Map<String, Integer> resultMap = messageConverter.getResultMessage(inputList, computerNumber);
        return messageConverter.getResultMessageToString(resultMap);
    }

    /*
    * 게임 종료 메서드
    * true : 게임 종료 false : 재시작
    * */
    public boolean stopGame() {
        String input = userUtil.getUserNumber();
        inputNumberValidator.validateGameStateInput(input);

        return Objects.equals(input, END);
    }
}
