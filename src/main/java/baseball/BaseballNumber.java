package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class BaseballNumber {
    private ArrayList<Integer> playerInputNumbers;
    private ArrayList<Integer> correctNumbers;

    public BaseballNumber(){
        playerInputNumbers = new ArrayList<>();
        correctNumbers = new ArrayList<>();
    }

    //정답 수 생성
    public ArrayList<Integer> generateCorrectNumbers(){
        correctNumbers.clear();
        for(int i=0;i<3;i++){
            int inputRandomInt = Randoms.pickNumberInRange(1,9);
            if(isDuplicate(correctNumbers,inputRandomInt)){
                continue;
            }
            correctNumbers.add(inputRandomInt);
        }

        return correctNumbers;
    }

    //중복 확인
    public boolean isDuplicate(ArrayList<Integer> correctNumbers, int inputRandomInt){
        if(correctNumbers.contains(inputRandomInt)){
            return true;
        }
        return false;
    }

    //String to ArrayList<Integer>
    public ArrayList<Integer> toIntegerArray(String inputString){
        playerInputNumbers.clear();
        String[] integerTokens = inputString.split("");
        for(String token : integerTokens){
            int intValue = Integer.parseInt(token);
            playerInputNumbers.add(intValue);
        }
        return playerInputNumbers;
    }


}
