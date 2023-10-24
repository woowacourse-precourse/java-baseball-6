package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Input {
    public List<Integer> inputNumber(){
        System.out.print(Speak.inputNumberSpeak);
        String inputString = Console.readLine();
        if(inputString.length()!=3){
            throw new IllegalArgumentException(Speak.inputIsUnvalid);
        }
        List<Integer> inputList = new ArrayList<>();
        for(int i=0;i<3;i++) {
            char userInput = inputString.charAt(i);
            if ('1' <= userInput && userInput <= '9'&& !inputList.contains(Character.getNumericValue(userInput))){
                inputList.add(Character.getNumericValue(userInput));
            }else {
                throw new IllegalArgumentException(Speak.inputIsUnvalid);
            }
        }
        return inputList;
    }
    public boolean startOrEnd(){
        System.out.println(Speak.startOrEndSpeak);
        int choice = Integer.parseInt(Console.readLine());

        if(choice ==1)
            return true;
        else
            return false;
    }
}

