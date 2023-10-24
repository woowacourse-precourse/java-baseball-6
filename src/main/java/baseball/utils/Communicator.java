package baseball.utils;

import baseball.menu.Menu;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Communicator {
    //---Messages---
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String USER_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MENU_SELECTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String TERMINATE_MESSAGE = "시스템을 종료합니다.";
    private static final String NOTHING = "낫싱";
    //---------

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static List<Integer> instructInputNumbers() {
        System.out.print(INPUT_MESSAGE);

        List<Integer> inputNumbers = new ArrayList<>();

        String inputString = Console.readLine();
        Validator.validateInputString(inputString);

        for (int i = 0; i < inputString.length(); i++) {
            char input = inputString.charAt(i);
            Validator.validateInputNumber(inputNumbers, input);
            inputNumbers.add(Character.getNumericValue(input));
        }

        return inputNumbers;
    }

    public static void printResult(Map<Count, Integer> counts) {
        int ballCount = counts.get(Count.BALL);
        String ballMark = Count.BALL.getCountMarkFrom(ballCount);

        int strikeCount = counts.get(Count.STRIKE);
        String strikeMark = Count.STRIKE.getCountMarkFrom(strikeCount);

        System.out.println(ballMark + strikeMark);

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
        }

        if (strikeCount == 3) {
            System.out.println(USER_WIN_MESSAGE);
        }
    }

    public static Menu instructMenu() {
        System.out.println(MENU_SELECTION_MESSAGE);
        String menuSelection = Console.readLine();
        return Menu.findMenu(menuSelection);
    }

    public static void printTerminate() {
        System.out.println(TERMINATE_MESSAGE);
    }

    public static void printException(RuntimeException exception) {
        System.out.println(exception.getMessage());
        printTerminate();
    }
}
