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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputLine = readLine();

        int userAnswer = 0;

        try{
            userAnswer = Integer.parseInt(inputLine);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        switch (userAnswer){
            case 1: return true;
            case 2: return false;
            default: throw new IllegalArgumentException();
        }
    }

}
