package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private final List<Integer> computerNumber;
    private List<Integer> userNumber;

    public Game(Computer computer) {
        this.computerNumber = computer.getComputer();
    }

    public void start() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            User user = new User(number);
            userNumber = user.getUser();
            if (check()) {
                break;
            }
        }
    }

    public boolean check() {
        int ball = 0;
        int strike = 0;

        for(int i = 0; i < 3; i++ ){
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike += 1;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball += 1;
            }
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            return true;
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        return false;
    }

}
