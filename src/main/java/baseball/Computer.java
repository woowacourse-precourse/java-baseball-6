package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private final int START_INCLUSIVE=1;
    private final int END_INCLUSIVE=9;
    private final int LENGTH=3;

    private List<Integer> computerNumbers;

    private static class LazyHolder{
        public static final Computer INSTANCE=new Computer();
    }

    public static Computer getInstance(){
        return LazyHolder.INSTANCE;
    }

    public List<Integer> generateRandomNumber(){
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LENGTH);
        computerNumbers=uniqueNumbers;
        return uniqueNumbers;
    }

    public int getBallCount(List<Integer> userNumbers){
        int count=0;
        int userNumber, computerNumber;

        for(int i=0; i<userNumbers.size(); i++){
            userNumber=userNumbers.get(i);

            for(int j=0; j<computerNumbers.size(); j++){
                computerNumber=computerNumbers.get(j);

                if(userNumber==computerNumber && i!=j) count++;
            }
        }

        return count;
    }
}
