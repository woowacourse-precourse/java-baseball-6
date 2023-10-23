package baseball.service;

import baseball.domain.ComputerNum;
import baseball.domain.UserNum;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private final UserNum userNum;
    private final ComputerNum computerNum;
    private final BallCounter ballCounter;
    private Integer strike;
    private Integer ball;

    public GameService() {
        this.userNum = new UserNum();
        this.computerNum = new ComputerNum();
        this.ballCounter = new BallCounter();
    }

    public void inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        userNum.setNum(Console.readLine());
    }

    public void showBallCount() {
        int correctNumberSize = ballCounter.countCorrect(userNum.getNum(), computerNum.getNum());
        strike = ballCounter.countStrike(userNum.getNum(), computerNum.getNum());
        ball = correctNumberSize - strike;

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball > 0) {
            System.out.printf("%d볼\n", ball);
        } else if (strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike > 0 && ball > 0){
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }

    public boolean checkGameOver() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public boolean askRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer enterValue = Integer.parseInt(Console.readLine());

        if (enterValue == 1) {
            return true;
        } else if (enterValue != 2) {
            throw new IllegalArgumentException();
        }

        return false;
    }
}
