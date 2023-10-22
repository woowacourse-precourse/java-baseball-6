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

    private final GameFlowManagementService gameFlowManagementService = new GameFlowManagementService(); //숫자 야구 게임의 흐름 및 다음 게임의 'Replay or Quit' question 담당
    private final GameNumberCheckService gameNumberCheckService = new GameNumberCheckService(); //컴퓨터와 플레이어의 숫자 비교-'스트라이크, 볼'을 카운트
    private final FirstGamePlayerInputView firstGamePlayerInputView = new FirstGamePlayerInputView(); //플레이어의 숫자 입력 처리 및 저장
    private final GameScoreView gameScoreView = new GameScoreView(); //숫자 야구 게임의 플레이 상황에 따른 적절한 결과 출력
    private List<Integer> countStrikeBall = new ArrayList<>(); //스트라이크와 볼의 개수 카운트
}
