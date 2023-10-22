package baseball.Controller;

import baseball.Domain.Computer;
import baseball.Domain.Player;
import baseball.Service.GameFlowManagementService;
import baseball.Service.GameNumberCheckService;
import baseball.View.FirstGamePlayerInputView;
import baseball.View.GameScoreView;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    private Computer computer = new Computer();
    private Player player = new Player();

    /* 숫자의 비교를 통한 게임 진행을 위해 변수 생성 */
    private static final int STRIKE_COUNT_INDEX = 0; //현재 스트라이크 개수 -> 인덱스로 저장
    private static final int STRIKE_COUNT_THREE = 3; //현재의 스트라이크 개수와 비교하기 위한 3스트라이크의 값 생성

    private final GameFlowManagementService gameFlowManagementService = new GameFlowManagementService(); //숫자 야구 게임의 흐름 및 다음 게임의 'Replay or Quit' question 담당 서비스를 연결
    private final GameNumberCheckService gameNumberCheckService = new GameNumberCheckService(); //컴퓨터와 플레이어의 숫자 비교-'스트라이크, 볼'을 카운트하는 서비스를 연결
    private final FirstGamePlayerInputView firstGamePlayerInputView = new FirstGamePlayerInputView(); //플레이어의 숫자 입력 실제 처리 및 저장하는 뷰를 연결
    private final GameScoreView gameScoreView = new GameScoreView(); //숫자 야구 게임의 플레이 상황에 따른 적절한 결과를 출력하는 뷰를 연결
    private List<Integer> countStrikeBall = new ArrayList<>(); //스트라이크와 볼의 개수 카운트하는 리스트 생성

    //게임 시작
    public void gameStart() {
        computer.setComputerNumbers();
        while (!gameFlowManagementService.gameQuit()) {
            playerNumbers();
            calculateCountStrikeBall();
            getGameScore();
        }
    }

    //1. 플레이어의 숫자 입력
    public void playerNumbers() {
        player.setPlayerNumbers(firstGamePlayerInputView.setPlayerNumbers());
    }

    //2. 플레이어의 숫자와 컴퓨터의 숫자를 비교해 스트라이크와 볼을 계산
    public void calculateCountStrikeBall() {
        countStrikeBall = gameNumberCheckService.compareGameNumber(player.getPlayerNumbers(),
                computer.getComputerNumbers());
    }

    // 3. 인덱스해둔 스코어를 가져와 3스트라이크와 일치하는지 확인 후 -> 3스트라이크 빌생 시 -> 게임을 종료하고, 게임을 재시작할 것인지 묻는 로직으로 이어주기
    public void getGameScore() {
        if (countStrikeBall.get(STRIKE_COUNT_INDEX) == STRIKE_COUNT_THREE) {
            gameScoreView.completeThreeStrikeScore(); //3스트라이크 발생
            gameFlowManagementService.nextGameFlow(computer);
        }
        if (countStrikeBall.get(STRIKE_COUNT_INDEX) != STRIKE_COUNT_THREE) {
            gameScoreView.incompleteThreeStrikeScore(countStrikeBall); //3스트라이크 미완성
        }
    }
}
