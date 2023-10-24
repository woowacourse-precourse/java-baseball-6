package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private String userInput;
    private ArrayList<Integer> userNumber = new ArrayList<Integer>();

    public void setUserInput() {
        this.userInput = readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (!checkUniqueNumber()) {
            throw new IllegalArgumentException();
        }
    }
    public boolean checkUniqueNumber() {
        boolean check = true;
        String tmp = "";
        for (char c : userInput.toCharArray()) {
            if (!tmp.contains(String.valueOf(c))) {
                tmp += String.valueOf(c);
            }
            else {
                check = false;
                break;
            }
        }
        return check;
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
