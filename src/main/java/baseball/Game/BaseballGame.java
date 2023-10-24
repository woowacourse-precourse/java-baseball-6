package baseball.Game;

import baseball.Util.Constant;
import baseball.Util.Exception;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {

    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();
    Compare compare = new Compare();
    Exception exception = new Exception();
    List<Integer> computer;
    List<Integer> player;

    public void GameStart() {

        //게임 시작, 컴퓨터 숫자 설정
        System.out.print("숫자 야구 게임을 시작합니다.\n");
        computer = computerNumber.getComputer();

        GamePlay(computer);
    }

    public void GamePlay(List<Integer> computer) {

        // 플레이어 숫자를 입력받음
        System.out.print("숫자를 입력해주세요 : ");
        player = playerNumber.getPlayer();

        // 플레이어 숫자와 컴퓨터 숫자를 비교
        String CountResult = compare.CountResult(player, computer);
        System.out.println(CountResult);

        // 게임 종료 조건(3스트라이크) 확인, 게임 재시작 구문으로 이동
        if (CountResult.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            GameReplay();
            return;
        }

        // 게임 다시 진행하는 재귀함수
        GamePlay(computer);
    }

    public void GameReplay() throws IllegalArgumentException {

        // 게임 재시작값 확인
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String ReplayValue = Console.readLine();

        // 게임 재시작값 입력 예외 송출
        exception.Exception_ReplayNumber(ReplayValue);

        // 1일때 재시작, 2일때 return 없이 자동종료 (불필요한 구문)
        if (ReplayValue.equals(Constant.GAME_REPLAY)) {
            GameStart();
        }
    }
}