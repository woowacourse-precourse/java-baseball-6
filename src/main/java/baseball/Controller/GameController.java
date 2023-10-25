package baseball.Controller;

import baseball.Model.Ball;

import java.util.Map;

public class GameController {
    private Ball ball =null;
    public GameController(int numbersLength){
        ball = new Ball(numbersLength);
    }
    public void startGame(){
        ball.randomNumber();
    }

    public Map<String, Integer> playGame(String inputNumbers) throws IllegalArgumentException{
        try{
            ball.checkNumber(inputNumbers);
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }

        Map<String, Integer> result = ball.gameResult(inputNumbers);

        return result;
    }

}
