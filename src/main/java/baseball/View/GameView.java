package baseball.View;

import baseball.Controller.GameController;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class GameView {
    private int number = 3;
    private GameController gameController = new GameController(number);

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameController.startGame();
        boolean flag = true;
        while(flag){
            try{
                flag = playGame();
            }
            catch(IllegalArgumentException ex){
                System.out.println("비정상적인 입력입니다. 게임을 종료합니다.");
                throw ex;
            }
        }
        System.out.println("게임을 종료합니다.");
    }

    private boolean playGame() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        boolean restartGame = true;
        String resultString = null;
        Map<String, Integer> result;

        try {
            result = gameController.playGame(inputNumbers);

        }
        catch(IllegalArgumentException ex){
            throw ex;
        }

        int strike = result.get("strike");
        int ball = result.get("ball");

        if(ball > 0){
            resultString = String.format("%d볼", ball);
            if(strike > 0){
                resultString += String.format(" %d스트라이크", strike);
            }
        }
        else if(strike > 0){
            resultString = String.format("%d스트라이크", strike);
        }
        else{
            resultString = "낫싱";
        }
        System.out.println(resultString);

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int flag = Integer.parseInt(Console.readLine());

            restartGame = gameController.restartGame(flag);
        }

        return restartGame;
    }

}
