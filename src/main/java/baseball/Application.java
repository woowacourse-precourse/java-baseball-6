package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computerNumber = new Computer();
        UserNumber userNumber = new UserNumber();
        GameResult gameResult = new GameResult();
        RestartGame restartGame = new RestartGame();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean flag = true;

        List<Integer> computer = computerNumber.randomNumber();
        List<Integer> player;

        while (flag) {
            // System.out.println(computer);
            player = userNumber.player();


            String result = gameResult.score(computer, player);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                flag = restartGame.restart();
            }
        }
    }
}