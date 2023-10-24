package baseball.controller;

import baseball.model.UserNumber;
import baseball.view.EndView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    EndView endView=new EndView();
    public UserNumber getUserInputNumber(){//사용자로부터 숫자 입력
        System.out.print("숫자를 입력해주세요 : ");
        String userInput= Console.readLine();
        List<Integer> userNumber=changeUserInputNumber(userInput);
        return new UserNumber(userNumber);
    }
    public List<Integer> changeUserInputNumber(String userInputNumber){
        List<Integer> inputNumber=new ArrayList<>();
        for(int i=0;i<userInputNumber.length();i++){
            char currentChar=userInputNumber.charAt(i);

            if(Character.isDigit(currentChar)){
                int changeType=Character.getNumericValue(currentChar);
                inputNumber.add(changeType);
            }
            else{
                throw new IllegalArgumentException("3자리 자연수를 입력하세요");

            }
        }
        if(inputNumber.size()!=3){
            throw new IllegalArgumentException("3자리 자연수를 입력하세요");
        }
            return inputNumber;
    }
    public boolean getRestartInput(){//재시작할지 입력
        endView.displayRestartMessage();
        while(true){
            int restartInput=Integer.parseInt(Console.readLine());
            if(restartInput!=1&&restartInput!=2){
                throw new IllegalArgumentException();
            }
            return restartInput==1;
        }
    }
    public int getExitInput(){//다시 시작할지 입력
        return 0;
    }
}
