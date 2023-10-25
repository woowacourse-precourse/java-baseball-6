package controller;

import view.PlayGameInformationOutputView;
import view.PlayerNumberInputView;
import model.Computer;
import model.Player;
import model.Referee;
import util.PlayerGameRestartUtil;

import java.util.Set;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
    PlayerNumberInputView playerNumberInputView = new PlayerNumberInputView();
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();
    PlayerGameRestartUtil playerGameRestartUtil = new PlayerGameRestartUtil();

    private boolean isFirstRound = true;

    public static final int GAME_ONGOING = 0;
    public static final int CONTINUE_GAME = 1;
    public static final int FINISH_GAME = 2;

    private int gameStatus = GAME_ONGOING;

    public void gameProgress() {
        playGameInformationOutputView.printGameStart();
        gameStatus = GAME_ONGOING;

        while (true) {
            Set<Integer> computerBalls = null;
            Set<Integer> playerBalls = null;

            if (isFirstRound) {
                computer.generateBalls();
                computerBalls = computer.getComputerNumber();
                isFirstRound = true;
            }

            playerNumberInputView.guideInformation();
            player.generateBalls(playerNumberInputView.receiveNumber());
            playerBalls = player.getPlayerNumber();

            String gameResult = referee.judgeValue(computerBalls, playerBalls);
            System.out.println(gameResult);

            if (gameResult.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                decideAdditionalGame();
            }

            if (gameStatus == FINISH_GAME) {
                break;
            }

            if (gameStatus == CONTINUE_GAME) {
                computer.initComputerBall();
                isFirstRound = true;
                gameStatus = GAME_ONGOING;
                System.out.println("게임 재시작");
            }
        }
    }

    private void decideAdditionalGame() {
        String nextGameState = playerGameRestartUtil.gameRestartQuestion();
        if (nextGameState.equals("1")) {
            gameStatus = CONTINUE_GAME;
        }
        if (nextGameState.equals("2")) {
            gameStatus = FINISH_GAME;
        }
    }
}
