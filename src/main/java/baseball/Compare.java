package baseball;

import java.util.List;

public class Compare {
    Computer com = new Computer();
    List<Integer> computer = com.getComputerNumbers();

    int strike = 0;
    int ball = 0;

    public void compareNumbers(List<Integer> userNumber) {
        for(int i=0; i<computer.size(); i++) {
            if (userNumber.get(i) == computer.get(i))
                strike++;
            else if (userNumber.contains(computer.get(i)))
                ball++;
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
        } else {
            if (strike > 0) {
                System.out.print(strike + "스트라이크 ");
            }
            if (ball > 0) {
                System.out.print(ball + "볼");
            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
        }
    }
}