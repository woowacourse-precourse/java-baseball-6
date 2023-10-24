package baseball.view;

import baseball.utill.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;


public class InputView {

    private static final Validator validator = new Validator();
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SEPARATOR = "";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public List<String> readPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        String[] input = Console.readLine().split(SEPARATOR);
        List<String> inputList = Arrays.asList(input);
        validator.validation(inputList);
        return inputList;
    }


    public int readEndSign() {
        System.out.println(RESTART_MESSAGE);
        String endSign = Console.readLine();
        validator.validationEndSign(endSign);
        return Integer.parseInt(endSign);
    }

}
