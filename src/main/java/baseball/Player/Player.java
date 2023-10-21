package baseball.Player;

import baseball.Computer.Computer;
import baseball.Exception.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNum;
    private int strike;
    private int ball;

    public Player() {
    }

    private void inputPlayerNum() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        playerNum = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            this.playerNum.add(input.charAt(i) - '0');
        }

        System.out.println(playerNum.toString());

        checkException(playerNum);
    }

    private void checkException(List<Integer> playerNum) {

        ExceptionHandler.checkException(playerNum);
    }

    public void playing(Computer computer) {

        boolean gameFinish = false;
        while (!gameFinish) {

            this.strike = 0;
            this.ball = 0;

            inputPlayerNum();
            gameFinish = checkBallStrike(computer);
        }
    }

    private boolean checkBallStrike(Computer computer) {

        int playerIndex = 0;
        for (Integer num : this.playerNum) {

            int result = computer.checkBallStrike(num, playerIndex);
            playerIndex++;
            finalResult(result);
        }

        printBallStrike(computer);

        return checkFinish();
    }

    private void finalResult(int result) {

        if (result == 1) {
            strike++;
        } else if (result == 2) {
            ball++;
        }
    }

    private void printBallStrike(Computer computer) {

        computer.printBallStrike(this.strike, this.ball);
    }

    private Boolean checkFinish() {

        if (this.strike == 3) {

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    public Boolean checkRestart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());

        return input == 1;
    }
}
