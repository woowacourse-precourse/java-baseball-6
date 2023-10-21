package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computerNumber = new Computer();
        UserNumber userNumber = new UserNumber();
        GameResult gameResult = new GameResult();
        RestartGame restartGame = new RestartGame();

        boolean flag = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (flag) {
            List <Integer> computer = computerNumber.getComputerNumbers();
            List <Integer> player = userNumber.getUserNumbers();

            String result = "";
            while (!result.equals("3스트라이크")) {
                result = gameResult.score(computer, player);
                System.out.println(result);
            }
            flag = restartGame.restart();
        }

    }
}
