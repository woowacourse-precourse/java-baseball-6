package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int LENGTH = 3;

    private List<Integer> computerNumbers=new ArrayList<>(LENGTH);

    private static class LazyHolder {
        public static final Computer INSTANCE = new Computer();
    }

    public static Computer getInstance() {
        return LazyHolder.INSTANCE;
    }

    public synchronized void generateRandomNumber() {
        if(computerNumbers.size()>0)
            computerNumbers.clear();

        int randomNumber;
        while(computerNumbers.size()<LENGTH){
            randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if(!computerNumbers.contains(randomNumber))
                computerNumbers.add(randomNumber);
        }
    }

    public int getBallCount(List<Integer> userNumbers) {
        int count = 0;
        int userNumber, computerNumber;

        for (int i = 0; i < userNumbers.size(); i++) {
            userNumber = userNumbers.get(i);

            for (int j = 0; j < computerNumbers.size(); j++) {
                computerNumber = computerNumbers.get(j);

                if (userNumber == computerNumber && i != j) count++;
            }
        }

        return count;
    }

    public int getStrikeCount(List<Integer> userNumbers) {
        int count = 0;
        int userNumber, computerNumber;

        for (int i = 0; i < userNumbers.size(); i++) {
            userNumber = userNumbers.get(i);
            computerNumber = computerNumbers.get(i);

            if(userNumber==computerNumber) count++;
        }

        return count;
    }
}
