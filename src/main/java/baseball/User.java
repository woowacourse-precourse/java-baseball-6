package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumber;
    private final UserValidator validator;

    public User() {
        this.userNumber = new ArrayList<>(Constant.fixed_Number_Size);
        this.validator = new UserValidator();
    }

    public void setUserNumber() {
        System.out.println(Constant.Input_Number);
        String userInput = Console.readLine();
        if (!validator.checkUserInput(userInput)) {
            throw new IllegalArgumentException(Constant.Input_Wrong);
        }
        userInputToUserNumber(userInput);
    }

    private void userInputToUserNumber(String userInput) {
        List<Integer> tmpUserNumber = new ArrayList<>();
        for (int i = 0; i < Constant.fixed_Number_Size; i++) {
            tmpUserNumber.add(Character.getNumericValue(userInput.charAt(i)));
        }
        userNumber = tmpUserNumber;
    }

    public boolean checkUserNumberStrike(Integer index, Integer baseballNumber) {
        return userNumber.get(index).equals(baseballNumber);
    }

    public boolean checkUserNumberBall(Integer baseballNumber) {
        return userNumber.contains(baseballNumber);
    }

    public boolean checkBaseballNumber(Computer computer, Integer index) {
        if (checkUserNumberStrike(index, computer.getBaseballNumber().get(index))) {
            return true;
        }
        if (checkUserNumberBall(computer.getBaseballNumber().get(index))) {
            return false;
        }
        return false;
    }
}
