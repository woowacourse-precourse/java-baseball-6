package baseball.controller;

import baseball.*;
import baseball.global.Validator;
import baseball.model.Score;
import baseball.view.ComputerRandomBalls;
import baseball.view.UserRandomBalls;
import baseball.view.ViewResult;

public class GameStart {
    public static void Start() {
        ComputerRandomBalls computerRandomBalls = new ComputerRandomBalls();
        UserRandomBalls userRandomBalls = new UserRandomBalls();
        ViewResult viewResult = new ViewResult();
        Validator validator = new Validator();
        Score score = new Score();

        System.out.println(viewResult.start);
        Application.computerRandomBalls = computerRandomBalls.outputRandomBall();

        while(true){
            validator.check(userRandomBalls.input());
            int result = score.play();

            if(result == viewResult.restart){
                initAllRandomBalls();
                Application.computerRandomBalls = computerRandomBalls.outputRandomBall();
            }
            else if(result == viewResult.end){
                break;
            }
        }
    }

    private static void initAllRandomBalls() {
        Application.computerRandomBalls.clear();
        Application.userRandomBalls.clear();
    }
}
