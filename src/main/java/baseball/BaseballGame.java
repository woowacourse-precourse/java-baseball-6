package baseball;

import baseball.core.Core;
import baseball.models.Score;
import baseball.users.Computer;
import baseball.users.Player;
import baseball.utils.Utils;
import java.util.List;

public class BaseballGame {
    private int CLOSE = 0;
    private final Core core = new Core();
    private final Score score = new Score(0, 0);
    private final Player player = new Player();
    private Computer computer;

    public void run() {
        // 1. 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer(Utils.pickNumber());

        while (CLOSE != 2) {
            player.changeNumbers(Utils.inputNumber()); // 플레이어 숫자 입력
            List<Integer> computerNumbers = computer.getNumbers(); // 상대방(컴퓨터) 랜덤 값 가져오기
            List<Integer> playerNumbers = player.getNumbers(); // 플레이어 입력 값 가져오기

            playBall(computerNumbers, playerNumbers); // 경기 시작
        }
    }

    private void playBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = core.countStrike(computerNumbers, playerNumbers); // 스트라이크 수
        int ball = core.countBall(computerNumbers, playerNumbers); // 볼 수
        score.changeScore(strike, ball); // 스코어를 변경
        core.printToResult(strike, ball); // 결과 출력

        if (score.getStrike() == 3) { // 3스트라이크 일 때, 게임 종료
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            CLOSE = Utils.inputLastNumber(); // 플레이어 재시작/종료 입력
            Utils.restartOrClose(CLOSE, computer); // 프로그램 종료 또는 재시작
        }
    }
}
