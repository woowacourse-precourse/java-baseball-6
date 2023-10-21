package baseball;

import java.util.List;
import java.util.Objects;

public class GameProcess {
    public static void gameStart() {
        List<Integer> computer = Computer.computerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> player = Player.playerNumber();

        int strike = Score.countStrike(player, computer);
        int ball = Score.countBall(player, computer);

        Score.printGameResult(strike, ball);
        // 3스트라이크가 충족되지 않으면 결과값을 무한으로 출력 중인 상태 => fix 필요
//        while (strike != 3) {
//            Score.printGameResult(strike, ball);
//        }
//        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        // computer와 player 확인 작업(이후 삭제 예정)
        System.out.println(computer);
        System.out.println(player);
    }

}
