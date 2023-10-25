package baseball;

import java.util.List;

public class Play {


    public void game() {

        System.out.println("숫자 야구 게임을 시작합니다");
        Computer computer = new Computer();
        List<Integer> another = computer.anotherNumber();
        int value = 0;
        while (value != 3) {

            Input input = new Input();
            List<Integer> player = input.numbers();
            if (player.size() == 0) {
                return;
            }

            value = compare(player, another);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        int newgame = new Input().newGameCheck();
        if (newgame == 1) {
            System.out.println(1);
            game();
        }
    }

    public int compare(List<Integer> player, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < player.size(); i++) {
            int now = player.get(i);
            if (answer.get(i) == now) {
                strike++;
            } else if (answer.contains(now)) {
                ball++;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return strike;
    }
}
