package baseball.Controller;

import baseball.Domain.Computer;
import baseball.Domain.Player;
import baseball.Service.GameFlowManagementService;
import baseball.Service.GameNumberCheckService;
import baseball.View.GamePlayerInputView;
import baseball.View.GameScoreView;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    private Computer computer;
    private Player player;
    private GameFlowManagementService gameFlowManagementService;
    private GameNumberCheckService gameNumberCheckService;
    private GamePlayerInputView gamePlayerInputView;  //First와 Next 게임의 view를 하나로 합침
    private GameScoreView gameScoreView;
    private List<Integer> countStrikeBall;

    private static final int STRIKE_COUNT_INDEX = 0; //현재 스트라이크 개수
    private static final int STRIKE_COUNT_THREE = 3; //비교를 위한 3스트라이크

    public BaseballGameController() { // 필드 선언 위치와 초기화 위치 분리
        computer = new Computer();
        player = new Player();
        gameFlowManagementService = new GameFlowManagementService();
        gameNumberCheckService = new GameNumberCheckService();
        gamePlayerInputView = new GamePlayerInputView();
        gameScoreView = new GameScoreView();
        countStrikeBall = new ArrayList<>();
    }

    public void gameStart() {
        computer.setComputerNumbers();
        while (!gameFlowManagementService.gameQuit()) {
            playGameRound(); // 게임 진행 로직을 별도 메서드로 분리
        }
    }

    public void playerNumbers() {
        player.setPlayerNumbers(gamePlayerInputView.setPlayerNumbers());
    }

    public void calculateCountStrikeBall() {
        countStrikeBall = gameNumberCheckService.compareGameNumber(player.getPlayerNumbers(),
                computer.getComputerNumbers());
    }

    public void getGameScore() {
        if (countStrikeBall.get(STRIKE_COUNT_INDEX) == STRIKE_COUNT_THREE) {
            gameScoreView.completeThreeStrikeScore(); //3스트라이크 발생
            gameFlowManagementService.nextGameFlow(computer);
        }
        if (countStrikeBall.get(STRIKE_COUNT_INDEX) != STRIKE_COUNT_THREE) {
            gameScoreView.incompleteThreeStrikeScore(countStrikeBall); //3스트라이크 미완성
        }
    }

    private void playGameRound() { // 분리한 메서드
        playerNumbers();
        calculateCountStrikeBall();
        getGameScore();
    }
}
