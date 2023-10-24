package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<Integer> getUserInputNumbers(){
        String userInput = Console.readLine();
        return parseUserInput(userInput);
    }

    private List<Integer> parseUserInput(String userInput){
        List<Integer> userInputNumbers = new ArrayList<>();
        String[] userInputArr = userInput.split("");
        for (String s : userInputArr) {
            Integer number = Integer.parseInt(s);
            userInputNumbers.add(number);
        }
        return userInputNumbers;
    }
}
