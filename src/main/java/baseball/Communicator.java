package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Communicator {
    private final Validator validator;
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public Communicator(Validator validator) {
        this.validator = validator;
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public List<Integer> instructInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> input = new ArrayList<>();

        String inputString = Console.readLine();
        validator.validateInputString(inputString);
        for (int i=0; i<inputString.length(); i++) {
            input.add(inputString.charAt(i) - '0');
        }

        return input;
    }
}
