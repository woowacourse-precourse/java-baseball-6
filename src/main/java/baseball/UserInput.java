package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    /*
    * validation을 userInput에서만 사용하는데.. 굳이 나눠야할까? 싶다
    * 만약 생성된 난수에 대해서 validation을 진행한다면 나눠서 각각 사용할거같긴한데...흠...합칠까...
    * */
    Validation validation = new Validation();
    public String getUserInput() {
        return Console.readLine();
    }

    public List<Integer> makeUserInputToThreeNumbers() {
        List<Integer> result = new ArrayList<>();
        String removeSpace = getUserInput().replace(" ", "");

        validation.validateThreeNumbers(removeSpace);
        for (int i = 0; i < removeSpace.length(); i++) {
            result.add(removeSpace.charAt(i) - '0'); // 아 뭔가 이거도 별론데... stream 쓰자 습..
        }
        for (Character c : removeSpace) {

        }
        return new ArrayList<>(result);
    }

    public void validateContinueSign(String input) {
        validation.validateSign(input);
    }
}
