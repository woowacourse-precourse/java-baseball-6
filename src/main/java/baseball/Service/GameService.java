package baseball.Service;

import baseball.domain.Computer;
import baseball.domain.User;


public class GameService {

    private int computerNumber;
    private int userNumber;

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameInitialize(){
        Computer computer = new Computer();
        computerNumber = computer.getNumber();
    }

    public void gameOn(){
        User user = new User();
        userNumber = user.getNumber();

        if (!gameScoreCalculate()) gameOn();
    }

    private boolean gameScoreCalculate(){
        int strikes = 0;
        int balls = 0;

        int[] computerDigits = getDigits(computerNumber);
        int[] userDigits = getDigits(userNumber);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userDigits[i] == computerDigits[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }
        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱");
        }

        if (balls > 0) {
            System.out.print(balls + "볼");
        }

        if (strikes > 0) {
            if (balls > 0) {
                System.out.print(" ");
            }
            System.out.print(strikes+"스트라이크");
        }
        System.out.println();

        if (strikes==3) return true;
        else return false;
    }

    private int[] getDigits(int number) {
        return new int[]{
                number / 100,         // 100의 자리
                (number / 10) % 10,   // 10의 자리
                number % 10           // 1의 자리
        };
    }

}
