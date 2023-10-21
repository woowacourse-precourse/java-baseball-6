package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    public void run(){
        inputUserNum();
    }

    private List<Integer> inputUserNum(){
        int userInput = Integer.valueOf(Console.readLine());
        List<Integer> userNum = new ArrayList<>();

        while(userInput != 0){
            userNum.add(0, userInput % 10);
            userInput /= 10;
        }
        return userNum;
    }

    private void checkUserNumForm(String userInput) {
        if(!isInteger(userInput)){
            throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("사용자 입력이 3자리수가 아닙니다.");
        }
        if (isDuplicatedNum(userInput)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("사용자 입력에 0이 포함됐습니다.");
        }
    }

    private boolean isDuplicatedNum(String userInput){
        Set<Character> userInputSet = new HashSet<>();

        for(char userInputChar : userInput.toCharArray()){
            userInputSet.add(userInputChar);
        }

        if(userInputSet.size() == userInput.length()){
            return false;
        }
        return true;
    }

    private boolean isInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
