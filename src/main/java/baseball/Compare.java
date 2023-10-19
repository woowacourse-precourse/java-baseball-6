package baseball;

import java.util.List;

public class Compare {
    Computer com = new Computer();
    List<Integer> computer = com.getComputerNumbers();
    UserNumber user = new UserNumber();
    List<Integer> userNumber = user.getUserNumbers();

    int strike = 0;
    int ball = 0;

    public void compareNumbers() {
        for(int i=0; i<userNumber.size(); i++) {
            if (userNumber.get(i) == computer.get(i))
                strike++;
            else if (userNumber.contains(computer.get(i)))
                ball++;
            else
               System.out.println("낫싱");
               break;
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
        } else {
            if (strike > 0) {
                System.out.print(strike + "스트라이크 ");
            }
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
        }
    }
}