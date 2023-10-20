package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ValidInputBallsList {
    public List<Integer> createInputBallsList() {
        List<Integer> validBallsList = new ArrayList<>();
        String numbersString = readLine();
        String[] numberStringArray = numbersString.split(" ");
        for(String numberString : numberStringArray){
            validBallsList.add(Integer.parseInt(numberString));
        }
        return validBallsList;
    }
}
