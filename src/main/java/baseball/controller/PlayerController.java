package baseball.controller;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private Computer computer;
    public PlayerController(Computer computer) {
        this.computer = computer;
    }
    public void resetComputer(int numberSize){
        String generatedNumber = "";
        List<Integer> usingNumbers = new ArrayList<>();
        while (usingNumbers.size() < numberSize) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!usingNumbers.contains(number)) {
                usingNumbers.add(number);
            }
        }
        for (int temp: usingNumbers) {
            generatedNumber += temp;
        }
        computer.setNumber(generatedNumber);
    }
    public int getStrikeCount(String userStr){
        int strike_count = 0;
        for (int i=0; i < userStr.length(); i++){
            if (userStr.charAt(i) == computer.getNumber().charAt(i)) {
                strike_count++;
            }
        }
        return strike_count;
    }
    public int getBallCount(String userStr){
        int ballCount = 0;
        for (int userIdx =0; userIdx < userStr.length(); userIdx++){
            for (int comIdx = 0; comIdx < userStr.length(); comIdx++){
                if (comIdx == userIdx) continue;
                if (userStr.charAt(userIdx) == computer.getNumber().charAt(comIdx)) ballCount++;
            }
        }
        return ballCount;
    }
}
