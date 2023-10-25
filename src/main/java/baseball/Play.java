package baseball;

import java.util.List;

public class Play {
    int strike, ball;

    public void game() {

        System.out.println("숫자 야구 게임을 시작합니다");
        Computer computer = new Computer();
        List<Integer> another = computer.anotherNumber();
        while (strike != 3) {
            strike = 0;
            ball = 0;
            Input input = new Input();
            List<Integer> player = input.numbers();
            if (player.size() == 0)
                return;
            compare(player, another);

        }
        Input input = new Input();
        int newgame = input.newGameCheck();
        if (newgame == 1)
            game();
    }

    private void compare(List<Integer> player, List<Integer> answer) {
        for (int i = 0; i < player.size(); i++) {
            int now = player.get(i);
            if (answer.contains(now)) {

                if (answer.get(i) == now)
                    strike++;
                else
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
    }
}
