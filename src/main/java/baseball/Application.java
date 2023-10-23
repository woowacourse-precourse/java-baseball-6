package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        RandomNum randomNum = new RandomNum();
        StartGame startGame = new StartGame();
        Judge judge = new Judge();
        RestartGame restartGame = new RestartGame();

        boolean again = true;

        while (again) {
            List<Integer> computer = randomNum.RandomNumber();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = judge.judge(computer, startGame.playerNum());
                System.out.println(result);
            }

            again = restartGame.restart();

        }
    }
}
