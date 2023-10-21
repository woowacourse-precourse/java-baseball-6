package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private static final int NUMBER_LEN = 3;

    public List<Integer> userAnswer = new ArrayList<Integer>();

    public void enterNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
        String number = Console.readLine();
        setUserAnswer(number);

    }

    public void setUserAnswer(String number) {
        for (int i = 0; i < NUMBER_LEN; i++) {
            userAnswer.add(Character.getNumericValue(number.charAt(i)));
        }
    }


}
