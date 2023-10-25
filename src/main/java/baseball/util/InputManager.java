package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public List<Integer> getPlayerInputNumbers() throws IllegalArgumentException{
        String inputLine = readLine();
        if(inputLine.length() != 3) throw new IllegalArgumentException();
        List<Integer> numbers = new ArrayList<>();

        for(char c : inputLine.toCharArray()) {
            int inputNum = c - '0';
            if(inputNum < 1 || inputNum > 9) throw new IllegalArgumentException();
            if(numbers.contains(inputNum)) throw new IllegalArgumentException();
            numbers.add(inputNum);
        }
        return numbers;
    }

    public boolean checkUserContinue() throws IllegalArgumentException {
        //TODO Player 게임 계속 여부 입력 처리
        return false;
    }

}
