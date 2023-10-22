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
}
