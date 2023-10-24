package baseball.Player;

// 숫자야구 게임에 필요한 Player 구현한 class
// input, exception 검사, 숫자야구 게임 결과 계산

import baseball.Computer.Computer;
import baseball.Exception.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNum;
    private int strike;
    private int ball;
    private final int STRIKECOUNT = 1;
    private final int BALLCOUNT = 2;
    private final int KEYNUMBER = 3;
    private final int RESTARTNUM = 1;

    public Player() {
    }

    // Player의 input을 받는 method
    private void inputPlayerNum() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        playerNum = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            this.playerNum.add(input.charAt(i) - '0');
        }
        
        checkException(playerNum);
    }

    // input에 대한 exception을 검사하는 method
    private void checkException(List<Integer> playerNum) {

        ExceptionHandler.checkException(playerNum);
    }

    // 숫자야구를 진행하기 위해 반복적으로 input을 받는 method
    // computer instance를 매개변수로 받아 결과를 계산
    public void playing(Computer computer) {

        boolean gameFinish = false;
        while (!gameFinish) {

            this.strike = 0;
            this.ball = 0;

            inputPlayerNum();
            gameFinish = checkBallStrike(computer);
        }
    }

    // input이 들어오고 결과를 계산하는 method
    // computer instance를 매개변수로 받아 직접적으로 결과를 계산
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

    // 결과를 계산하여 판단하는 method
    // result를 매개변수로 받아 strike인지 ball인지 판단
    private void finalResult(int result) {

        if (result == STRIKECOUNT) {
            strike++;
        } else if (result == BALLCOUNT) {
            ball++;
        }
    }

    // 계산을 맞추고 결과를 출력하는 method
    // computer instance를 매개변수로 받아 strike와 ball값을 넘겨주어 출력
    private void printBallStrike(Computer computer) {

        computer.printBallStrike(this.strike, this.ball);
    }

    // 숫자야구 게임이 종료하였는지 조건을 판단하고 출력하는 method
    private Boolean checkFinish() {

        if (this.strike == KEYNUMBER) {

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    // 숫자야구 게임의 정답을 맞출 시 재시작 여부를 묻는 method
    public Boolean checkRestart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = ExceptionHandler.checkReNum(Console.readLine());

        return input == RESTARTNUM;
    }
}
