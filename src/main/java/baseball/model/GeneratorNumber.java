package baseball.model;

import java.util.List;

public class GeneratorNumber {

    public static List<Integer> generateComputerNumber() {
        ComputerNumber computerNumber = ComputerNumber.getComputerNumber();
        return computerNumber.getNumberList();
    }

    public static List<Integer> generateUserNumber(String userInput) {
        UserNumber userNumber = UserNumber.userNumberFactory(userInput);
        return userNumber.getNumberList();
    }
}
