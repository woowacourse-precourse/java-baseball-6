package baseball.controller;

import baseball.model.Constant;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.view.Message;
import baseball.view.UserInput;
import baseball.view.UserOutput;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class GameService {
    static public void gameStart(){
        Computer computer = new Computer(makeRandomNumber());

        /* Repeat until the user gets the correct answer. */
        while(true){
            ArrayList<Integer> userInput = convertStringToArrayListInteger(UserInput.getUserInputNumber());
            Hint hint = compareNumber(userInput, computer.getTargetNum());
            UserOutput.consoleOutSBStatus(hint.getStrike(), hint.getBall());
            if(isFinish(hint)){//Correct!
                break;
            }
        }

        UserOutput.consoleOutGameFinish();
    }

    static private ArrayList<Integer> makeRandomNumber(){
        ArrayList<Integer> randomNumber = new ArrayList<>();

        /* make num of NUMBER_LENGTH different random Integer */
        while(randomNumber.size() < Constant.NUMBER_LENGTH){
            int num = Randoms.pickNumberInRange(Constant.NUMBER_START,Constant.NUMBER_FINISH);
            if(!randomNumber.contains(num)){//no duplicated num
                randomNumber.add(num);
            }
        }

        return randomNumber;
    }

    static private Hint compareNumber(ArrayList<Integer> inputA, ArrayList<Integer> inputB){
        int strikeCnt = 0;
        int ballCnt = 0;

        for(int i=0; i<inputA.size(); i++){
            if(inputB.contains(inputA.get(i))){//there is a matched number
                if(inputB.indexOf(inputA.get(i)) == i){//at the same index
                    strikeCnt++;
                }
                else{//at the different index
                    ballCnt++;
                }
            }
        }

        return new Hint(strikeCnt, ballCnt);
    }


    static private boolean isFinish(Hint hint){
        return hint.getStrike() == Constant.NUMBER_LENGTH;
    }

    static private ArrayList<Integer> convertStringToArrayListInteger(String input){
        ArrayList<Integer> arrayList = new ArrayList<>();

        /* User types more or less than NUMBER_LENGTH */
        if(input.length() != Constant.NUMBER_LENGTH){
            throw new IllegalArgumentException(Message.INVALID_INPUT_LENGTH);
        }

        for(int i = 0; i < input.length(); i++){
            char characterVar = input.charAt(i);
            /* User types not numeric values */
            if(Constant.CHAR_START > characterVar || characterVar > Constant.CHAR_FINISH) {
                throw new IllegalArgumentException(Message.INVALID_INPUT_NUMERIC);
            }
            int number = Character.getNumericValue(input.charAt(i));
            if(arrayList.contains(number)){
                throw new IllegalArgumentException(Message.INVALID_INPUT_DUPLICATE);
            }
            arrayList.add(number);
        }

        return arrayList;
    }
}

