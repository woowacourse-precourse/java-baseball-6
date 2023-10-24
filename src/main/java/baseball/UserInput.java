package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class UserInput {

    public ArrayList<Integer> getUserNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String numberInput = Console.readLine();

        if (!isError(numberInput))
            throw new IllegalArgumentException();

        for (int i = 0; i < 3; i++) {
            int number = Character.getNumericValue(numberInput.charAt(i));
            numbers.add(number);
        }

        return numbers;
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartInput = Integer.parseInt(Console.readLine());

        if (restartInput == 1)
            return true;
        if (restartInput == 2)
            return false;
        else
            throw new IllegalArgumentException();
    }

    public boolean isError(String numberInput) {
        if (!is3Digit(numberInput))
            return false;
        if (!isAllInteger(numberInput))
            return false;
        if (!isNonZero(numberInput))
            return false;
        if (!isNotRepeat(numberInput))
            return false;
        return true;
    }

    public boolean is3Digit(String numberInput) {
        if (numberInput.length() == 3) {
            return true;
        }
        return false;
    }

    public boolean isAllInteger(String numberInput) {
        for (int i = 0; i < numberInput.length(); i++) {
            if ('0' > numberInput.charAt(i) || numberInput.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean isNonZero(String numberInput) {
        for (int i = 0; i < numberInput.length(); i++) {
            if (numberInput.charAt(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotRepeat(String numberInput) {
        if (numberInput.charAt(0) == numberInput.charAt(1))
            return false;
        if (numberInput.charAt(0) == numberInput.charAt(2))
            return false;
        if (numberInput.charAt(1) == numberInput.charAt(2))
            return false;
        return true;
    }
}
