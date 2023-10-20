package baseball;

import java.util.Scanner;

public class Game {
    private Computer computer = new Computer();
    private User user = new User();
    private Compare compare = new Compare();
    private UserInterface userInterface = new UserInterface();

    private int retryCheckNumber = 0;
    private int bulls = 0;
    private int cows = 0;

    public void game() {
        computer.setRandomNumbers();
        while(bulls != 3) {
            userInterface.pleaseEnterNumber();
            user.enterNumbers();
            judgmentStrikeOrBall();
        }
        userInterface.gameEndMessage();
        retryOrExitCheck();
    }
    public int getRetryCheckNumber() {
        return retryCheckNumber;
    }
    public void judgmentStrikeOrBall() {
        bulls = compare.strikeCheck(computer.getComputerNumbers(), user.getUserNumbers());
        cows = compare.ballCheck(computer.getComputerNumbers(), user.getUserNumbers()) - bulls;
        if(cows > 0) { // 볼 출력
            userInterface.BallMessage(cows);
        }
        if(bulls > 0) { // 스트라이크 출력
            userInterface.strikeMessage(bulls);
        }
        if(cows == 0 && bulls == 0) { // 낫싱 출력
            userInterface.nothing();
        }
        System.out.println();
    }
    public void retryOrExitCheck() { // 여기 나중에 예외처리
        userInterface.restartOrShutdownMessage();
        Scanner s = new Scanner(System.in);
        retryCheckNumber = s.nextInt();
    }
}
