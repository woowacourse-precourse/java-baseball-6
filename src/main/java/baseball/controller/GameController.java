package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Grade;
import baseball.domain.Player;
import baseball.utils.Constants;

import java.util.List;

public class GameController {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Grade grade = new Grade();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameRunning = true;

        while (gameRunning) {
            playGame();
            System.out.println("게임을 새로 시작하려면 " + Constants.RETRY + ", 종료하려면 " + Constants.EXIT + "를 입력하세요.");
            int playerInput = player.getFinishInput();

            if (playerInput == Constants.EXIT) {
                gameRunning = false;
                System.out.println("게임 종료");
            }
        }
    }

    private void playGame() {
        List<Integer> computerNumbers = computer.getComputerNumber();
        boolean flag = true;

        while (flag) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> playerNumbers = player.getPlayerNumbers();
            int[] result = grade.getScore(computerNumbers, playerNumbers);
            String resultString = grade.getResult(result);
            System.out.println(resultString);

            if (result[1] != Constants.MAX_SIZE) {
                continue;
            }
            flag = false;
        }
    }
}
