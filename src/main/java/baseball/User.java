package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    public static final String NEW_GAME = "1";
    public static final String END_GAME = "2";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private List<Integer> userNumber;
    private Validator validator;

    public User() {
        this(new ArrayList<>(), new Validator());
    }

    private User(List<Integer> userNumber, Validator validator) {
        this.userNumber = userNumber;
        this.validator = validator;
    }

    public List<Integer> inputNumber() {
        userNumber = new ArrayList<>();
        System.out.print(USER_INPUT_MESSAGE);

        String userInput = Console.readLine();
        validator.validate(userInput);
        userNumber.add(Integer.parseInt(userInput));

        return userNumber;
    }

    public String inputStartingNewGameOrNot() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", NEW_GAME, END_GAME);
        System.out.println();

        String inputNewGameOrNot = Console.readLine();
        if (END_GAME.equals(inputNewGameOrNot) || NEW_GAME.equals(inputNewGameOrNot)) {
            return inputNewGameOrNot;
        }
        throw new IllegalArgumentException(NEW_GAME + "이나 " + END_GAME + "를 입력하지 않아 강제종료합니다.");
    }
}
