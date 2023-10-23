package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Communicator {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String USER_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MENU_SELECTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Validator validator;

    public Communicator(Validator validator) {
        this.validator = validator;
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public List<Integer> instructInputNumbers() {
        System.out.print(INPUT_MESSAGE);

        List<Integer> inputNumbers = new ArrayList<>();

        String inputString = Console.readLine();
        validator.validateInputString(inputString);

        for (int i=0; i<inputString.length(); i++) {
            char input = inputString.charAt(i);
            validator.validateInputNumber(inputNumbers, input);
            inputNumbers.add(Character.getNumericValue(input));
        }

        return inputNumbers;
    }

    public void printResult(Map<String, Integer> counts) {
        //TODO: hard coded string to something else + fix format to print ball and strike in one line
        int ballCount = counts.get("ballCount");
        if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        }

        int strikeCount = counts.get("strikeCount");
        if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (strikeCount == 3) {
            System.out.println(USER_WIN_MESSAGE);
        }
    }

    public Menu instructMenu() {
        System.out.println(MENU_SELECTION_MESSAGE);
        String menuSelection = Console.readLine();
        return Menu.findMenu(menuSelection);
    }

    public void printTerminate() {
        System.out.println("시스템을 종료합니다.");
    }
}
