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

    public String[] compareTwoNumbers(List<Integer> userNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i) == this.computerNumber.get(i)) {
                strikeCount++;
                continue;
            }
            if (this.computerNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
        }
        String result = ballCount + "," + strikeCount;
        return result.split(",");
    }






}
