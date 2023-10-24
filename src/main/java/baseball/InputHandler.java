package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputHandler {
    List<Integer> userNumber = new ArrayList<>();
    String userInput;

    public void getUserInputNumber() {
        userNumber.clear();

        userInput = Console.readLine();
        for (char i : userInput.toCharArray()) {
            int number = Character.getNumericValue(i);
            userNumber.add(number);
        }
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public int getUserSelection() {
        userInput = Console.readLine();
        int userSelection = Integer.parseInt(userInput);
        return userSelection;
    }

    //3자리 숫자 유효성 검사
    public boolean isValidInputNumber(List<Integer> userNumber) {

        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }

        int userNumberCheck = Integer.parseInt(userInput);
            //throw new IllegalArgumentException("1부터 9 까지 서로 다른 숫자를 입력하세요.");


        Set<Integer> uniqueDigits = new HashSet<>(userNumber);
        if (uniqueDigits.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자 3자리를 입력하세요.");
        }

        return true;
    }

    //선택 입력 유효성 검사
    public boolean isValidInputSelection(int userSelection) {
        if (userSelection != 1 && userSelection != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }

        return true;
    }
}
