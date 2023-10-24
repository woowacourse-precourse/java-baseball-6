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
    private final Computer computer = new Computer(Utils.pickNumber()); // 상대방(컴퓨터) 객체 생성
    private final Player player = new Player(Utils.inputNumber()); // 플레이어 객체 생성

    public void run() {
        // 1. 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (CLOSE != 2) {
            List<Integer> computerNumbers = computer.getNumbers(); // 상대방(컴퓨터) 랜덤 값 가져오기
            List<Integer> playerNumbers = player.getNumbers(); // 플레이어 숫자 입력

            int strike = core.countStrike(computerNumbers, playerNumbers);
            int ball = core.countBall(computerNumbers, playerNumbers);
            score.changeScore(strike, ball);

            if (score.getStrike() == 3) {
                // 게임 종료
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                CLOSE = Utils.restartOrClose();
            }
        }


    }
}
