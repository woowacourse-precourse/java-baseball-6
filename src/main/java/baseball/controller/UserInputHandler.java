package baseball.controller;

import baseball.constants.Constants;
import baseball.model.UserNumber;
import baseball.view.EndView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    EndView endView=new EndView();
    private List<List<Integer>> duplicatedNum=new ArrayList<>();

    public UserNumber getUserInputNumber(){//사용자로부터 숫자 입력
        System.out.print(Constants.USER_INPUT_MESSAGE);
        String userInput= Console.readLine();
        List<Integer> userNumber=changeUserInputNumber(userInput);
        if(!containNumber(duplicatedNum,userNumber)&&userNumber.size()==3){
            duplicatedNum.add(userNumber);
            return new UserNumber(userNumber);
        }
        else if(containNumber(duplicatedNum,userNumber)){
            System.out.println(Constants.DUPLICATE_NUMBER_MESSAGE);
        }
        else{
            System.out.println(Constants.ERROR_MESSAGE);
        }
        return new UserNumber(userNumber);
    }
    public boolean containNumber(List<List<Integer>> numberList,List<Integer> target){
        for(int i=0;i<numberList.size();i++){
            List<Integer> number=numberList.get(i);
            boolean isEqual=true;
            for(int j=0;j<number.size();j++){
                if(!number.get(j).equals(target.get(i))){
                    isEqual=false;
                    break;
                }
            }
            if(isEqual){
                return false;
            }
        }
        return false;
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
                throw new IllegalArgumentException(Constants.ERROR_MESSAGE);

            }
        }
        if(inputNumber.size()!=Constants.RANDOM_NUMBER_LENGTH){
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
            return inputNumber;
    }
    public boolean getRestartInput(){//재시작할지 입력
        endView.displayRestartMessage();
        while(true){
            int restartInput=Integer.parseInt(Console.readLine());
            if(restartInput== Constants.RESTART_GAME_NUMBER){
                return true;
            }
            else if(restartInput==Constants.END_GAME_NUMBER){
                return false;
            }
            else{
                System.out.println(Constants.RETRY_MESSAGE);
            }
        }
    }
    public int getExitInput(){//다시 시작할지 입력
        return 0;
    }
}
