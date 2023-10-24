package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class GameManager{

    private final Judge judge = new Judge();

    void playGame(ComputerNumbers computerNumber){
        while (true){
            PlayerNumbers playerNumber = new PlayerNumbers(input());
            Result result = judge.getResult(computerNumber,playerNumber);
            result.printResult();
            if (result.isAllStrike()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> input(){
        System.out.print("숫자를 입력해주세요: ");
        String numberInput = readLine();
        return stringIntoIntegerList(numberInput);
    }

    private List<Integer> stringIntoIntegerList(String inputString){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++){
            throwIfNotNumericValue(inputString.charAt(i));
            int number = inputString.charAt(i) - '0';
            integerList.add(number);
        }
        return integerList;
    }

    private void throwIfNotNumericValue(char c){
        if(c-'0'<0||c-'0'>9){
            throw new IllegalArgumentException("Invalid number input : Number input should be a numeric value");
        }
    }

}
