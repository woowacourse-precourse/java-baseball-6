package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userInput = null;

    User(){
        userInput = new ArrayList<>();
    }
    void input() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램 종료");
        }
        userInput = input.chars().mapToObj(Character::getNumericValue).toList();
        if (userInput.stream().distinct().count() < 3) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램 종료");
        }
    }
    List<Integer> getUserInput(){
        return userInput;
    }
}
