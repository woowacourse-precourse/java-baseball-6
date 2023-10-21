package baseball;

import java.util.List;
import java.util.Objects;

public class GameProcess {
    public static void gameStart() {
        List<Integer> computer = Computer.computerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> player = Player.playerNumber();

        int strike = countStrike(player, computer);
        int ball = countBall(player, computer);

        // 3스트라이크가 충족되지 않으면 결과값을 무한으로 출력 중인 상태 => fix 필요
        while (strike != 3) {
            printGameResult(strike, ball);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        // computer와 player 확인 작업(이후 삭제 예정)
        System.out.println(computer);
        System.out.println(player);
    }

    public static Integer countStrike(List<Integer> playerNumber, List<Integer> computerNumber) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(playerNumber.get(i), computerNumber.get(i))) {
                strike += 1;
            }
        }

        return strike;
    }

    public static Integer countBall(List<Integer> playerNumber, List<Integer> computerNumber) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (!Objects.equals(playerNumber.get(i), computerNumber.get(i)) && computerNumber.contains(playerNumber.get(i))) {
                ball += 1;
            }
        }

        return ball;
    }

    public static void printGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (ball > 0) {
            System.out.printf("%d볼\n", ball);
        }
    }
}
