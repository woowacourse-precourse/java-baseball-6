package baseball.domain;

import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    public BaseballGame(){
        Computer computer = new Computer();
        this.computerNumber = computer.randomComputerNumber();
    }

    public List<Integer> createComputerNumber() {
        Computer computer = new Computer();
        this.computerNumber = computer.randomComputerNumber();
        return this.computerNumber;
    }

    public List<Integer> createUserNumber(String userNumber){
        User user = new User();
        this.userNumber = user.readUserNumber(userNumber);
        return this.userNumber;
    }




    public String[] compareTwoNumbers() {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < this.userNumber.size(); i++) {
            if (this.userNumber.get(i) == this.computerNumber.get(i)) {
                strikeCount++;
                continue;
            }
            if (this.computerNumber.contains(this.userNumber.get(i))) {
                ballCount++;
            }
        }
        String result = ballCount + "," + strikeCount;
        return result.split(",");
    }






}
