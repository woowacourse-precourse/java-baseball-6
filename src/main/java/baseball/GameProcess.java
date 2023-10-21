package baseball;

import java.util.List;
import java.util.Objects;

public class GameProcess {
    public static void gameStart() {
        List<Integer> computer = Computer.computerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> player = Player.playerNumber();

        if (countBall(player, computer) > 0) {
            System.out.print(countBall(player, computer) + "볼");
        }

        if (countStrike(player, computer) > 0) {
            System.out.println(countStrike(player, computer) + "스트라이크");
        }

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
}
