package model;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumbers {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int MAX_NUMBER_LENGTH=3;
    private static String randomNumbers="";

    public String createNumbers(int nowNumberLength){
        while(randomNumbers.length()<3){
            String randomNumber = getRandomNumbers();
            if(checkDuplicate(randomNumbers,randomNumber)){
                continue;
            }else{
                randomNumbers +=String.valueOf(randomNumber);
            }
        }
        return randomNumbers;
    }
    public String getRandomNumbers(){
        String randomNumber = String.valueOf(Randoms.pickNumberInRange(START_NUMBER,END_NUMBER));
        return randomNumber;
    }

    private boolean checkDuplicate(String randomNumbers,String randomNumber){
        if(randomNumbers.contains(String.valueOf(randomNumber))){
            return true;
        }else{
            return false;
        }
    }

}
