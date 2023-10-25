package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class View {

    public String user_balls() throws Exception {
        String userInput = Console.readLine();
        if(!check_userBalls(userInput)){
            throw new Exception("Input 값이 잘못되었습니다.");
        }
        return userInput;
    }

    private boolean check_userBalls(String userInput) throws Exception {
        return checkLength(userInput)&&checkAllInteger(userInput)&&checkOverlapping(userInput);
    }

    private boolean checkLength(String userInput) {
        return userInput.length()==3;
    }

    private boolean checkAllInteger(String userInput) throws Exception {
        try{
            Integer.parseInt(userInput);
        }catch (Exception e){
            throw new Exception("INPUT에 숫자 외의 값이 있습니다");
        }
        return true;
    }

    private boolean checkOverlapping(String userInput) {
        Set<Character> check = new HashSet<>();
        for(char c : userInput.toCharArray()){
            check.add(c);
        }
        return check.size() == 3;
    }
}
