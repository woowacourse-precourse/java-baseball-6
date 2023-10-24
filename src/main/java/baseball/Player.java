package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Integer> saveThreeNumbers = new ArrayList<>(3);

    public List<Integer> getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputText = Console.readLine();
        saveThreeNumbers = Validator.checkThreeNumbers(inputText);

        return saveThreeNumbers;
    }
}
