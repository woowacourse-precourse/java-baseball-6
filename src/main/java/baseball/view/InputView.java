package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_NUMBER_LENGTH_EXCEPTION = "입력하는 수는 3자리여야합니다.";
    private static final String INPUT_NUMBER_CONTAIN_EXCEPTION = "1~9까지의 수를 입력해주세요.";
    private static final String INPUT_NUMBER_DUPLICATE_EXCEPTION = "입력하는 수는 서로 다른 수여야합니다.";
    private static final String RESET_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." ;
    private static final int INPUT_NUMBER_LENGTH = 3 ;
    private static final String INPUT_NUMBER_TYPE = "^[1-9]*$";


    public static String inputNumber(){
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();
        validationNumber(input.replaceAll(" ", ""));
        return input;
    }
    public static String resetGame(){
        System.out.println(RESET_GAME_MESSAGE);
        return Console.readLine();
    }
    private static void validationNumber(String input){
        if (inputNumberLength(input)) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH_EXCEPTION);
        }
        if (inputType(input)) {
            throw new IllegalArgumentException(INPUT_NUMBER_CONTAIN_EXCEPTION);
        }
        if (differentNumber(input)) {
            throw new IllegalArgumentException(INPUT_NUMBER_DUPLICATE_EXCEPTION);
        }

    }
    private static boolean inputNumberLength(String inputNumber){
        return inputNumber.length() !=INPUT_NUMBER_LENGTH;
    }
    private static boolean inputType(String inputNumber){
        return !inputNumber.matches(INPUT_NUMBER_TYPE);
    }
    public static boolean differentNumber(String inputNumber) {
        List<String> inputNumberList = Arrays.asList(inputNumber.split(""));
        Set<String> inputNumberSet = new HashSet<>(inputNumberList);
        return inputNumberSet.size() != INPUT_NUMBER_LENGTH;
    }


}
