package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerRandomBalls = new ArrayList<>();
    static List<Integer> userRandomBalls = new ArrayList<>();
    public static void main(String[] args) {
        ViewResult viewResult = new ViewResult();
        System.out.println(viewResult.start);

        gameStart();
    }

    private static void gameStart() {
        Score score = new Score();
        UserRandomBalls userRandomBalls = new UserRandomBalls();
        ComputerRandomBalls computerRandomBalls = new ComputerRandomBalls();
        Validator validator = new Validator();

        Application.computerRandomBalls = computerRandomBalls.outputRandomBall();

        while(true){
            validator.checkUserInputRandomBalls(userRandomBalls.input());
            int result = score.play();
            if(result == 1){
                Application.computerRandomBalls.clear();
                Application.computerRandomBalls = computerRandomBalls.outputRandomBall();
            }
            else if(result == 2){
                break;
            }
        }
    }
}
