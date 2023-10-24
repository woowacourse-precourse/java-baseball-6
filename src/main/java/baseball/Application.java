package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GenerateRandomNumber randomNumber = new GenerateRandomNumber();
        InputNumber inputNumber = new InputNumber();
        JudgementResult judgementResult = new JudgementResult();
        RestartGame restartGame = new RestartGame();
        boolean restart = true;



        while (restart) {
            List<Integer> computer = randomNumber.create();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = judgementResult.judgementResult(computer, inputNumber.playerNumber());
                System.out.println(result);
            }
            restart = restartGame.restartGame();
        }
    }
}
