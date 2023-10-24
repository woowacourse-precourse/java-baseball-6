package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    static final int MAX_NUMBER = 9;
    static final int MIX_NUMBER = 1;
    static final int NUMBER_SIZE = 3;
    private List<Integer> ramdomNumber = new ArrayList<>();

    public void generationRandomNumber() {
        ramdomNumber.clear();
        while (ramdomNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIX_NUMBER, MAX_NUMBER);
            if(!ramdomNumber.contains(randomNumber)) {
                ramdomNumber.add(randomNumber);
            }
        }
    }

    public int strikeCount(List<Integer> userNumber){
        int count = 0;
        for(int i=0; i<NUMBER_SIZE; i++){
            int number = userNumber.get(i);
            if(ramdomNumber.contains(number) && ramdomNumber.get(i) == number) {
                count++;
            }
        } return count;
    }

    public int ballCount(List<Integer> userNumber){
        int count = 0;
        for(int i=0; i<NUMBER_SIZE; i++){
            int number = userNumber.get(i);
            if(ramdomNumber.contains(number) && ramdomNumber.get(i) != number) {
                count++;
            }
        } return count;
    }
}
