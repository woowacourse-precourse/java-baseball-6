package baseball;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private String userInput;
    private ArrayList<Integer> userNumber = new ArrayList<Integer>();

    public void setUserInput() {
        this.userInput = readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    public ArrayList<Integer> getUserNumber() {
        String[] userInputList = userInput.split("");
        for (String numberStr : userInputList) {
            int numberInt = Integer.parseInt(numberStr);
            userNumber.add(numberInt);
        }
        return userNumber;
    }
}
