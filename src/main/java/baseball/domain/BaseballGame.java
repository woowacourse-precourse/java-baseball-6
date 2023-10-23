package baseball.domain;

import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private List<Integer> computerNumber;

    public BaseballGame(){
        Computer computer = new Computer();
        this.computerNumber = computer.randomComputerNumber();
        System.out.println(this.computerNumber);
    }

    public List<Integer> createComputerNumber() {
        Computer computer = new Computer();
        this.computerNumber = computer.randomComputerNumber();
        System.out.println(this.computerNumber);
        return computerNumber;
    }

    public String[] compareTwoNumbers(String userNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) - '0' == this.computerNumber.get(i)) {
                strikeCount++;
                continue;
            }
            if (this.computerNumber.contains(userNumber.charAt(i) - '0')) {
                ballCount++;
            }
        }
        String result = ballCount + "," + strikeCount;
        return result.split(",");
    }






}
