package baseball.service;

import baseball.util.ComputerUtil;
import baseball.util.MessageConverter;
import baseball.util.UserUtil;
import baseball.validation.InputNumberValidator;

import java.util.List;
import java.util.Map;

public class GameService {

    private static List<Integer> computerNumber;

    /*
     * 게임 초기설정 메서드
     * */
    public static void setGame() {
        computerNumber = ComputerUtil.generateComputerNumber();
    }

    /*
     * 게임 진행 메서드
     * */
    public static String playGame() {
        String input = UserUtil.getUserNumber();
        List<Integer> inputList = InputNumberValidator.validateInputNumber(input);
        Map<String, Integer> resultMap = MessageConverter.getResultMessage(inputList, computerNumber);
        return MessageConverter.getResultMessageToString(resultMap);
    }
}
