package baseball.service;

import static baseball.controller.BaseballController.BASEBALL_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class ComputerService {
    
    private static final int BASEBALL_MIN_NUMBER = 1;
    private static final int BASEBALL_MAX_NUMBER = 9;
    
    public String initComputer() {
        return makeComputerNumber();
    }
    
    public int countStrikes(String computer, String player) {
        int count = 0;
    
        for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
            char targetNumber = player.charAt(i);
            
            if (targetNumber == computer.charAt(i)) {
                count += 1;
            }
        }
        
        return count;
    }
    
    public int countBalls(String computer, String player) {
        int count = 0;
    
        for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
            char targetNumber = player.charAt(i);
            int findIndex = computer.indexOf(targetNumber);
            
            if (findIndex > 0 && findIndex != i) {
                count += 1;
            }
        }
        
        return count;
    }
    
    private String makeComputerNumber() {
        LinkedHashSet<String> result = new LinkedHashSet<>();
    
        while (result.size() < BASEBALL_NUMBERS_SIZE) {
            result.add(makeRandomNumber());
        }
    
        return String.join("", result);
    }
    
    private String makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER);
        return Integer.toString(randomNumber);
    }
}
