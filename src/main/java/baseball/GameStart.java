package baseball;

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
                Application.computerRandomBalls.clear();
                Application.userRandomBalls.clear();
                Application.computerRandomBalls = computerRandomBalls.outputRandomBall();
            }
            else if(result == viewResult.end){
                break;
            }
        }
    }
}
