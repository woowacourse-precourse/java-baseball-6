package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BallAndStrike;
import baseball.domain.BaseBallNumber;
import baseball.service.BaseballService;
import baseball.view.BaseballView;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }

    public void run(){

        BaseBallNumber cpuNumber = BaseBallNumber.generateRandomNumber();
        BaseballController baseballController = new BaseballController(3);
        System.out.println(cpuNumber);

        while (true){


            BaseballService baseballService = new BaseballService(cpuNumber);

            BaseBallNumber userBaseBallNumber = baseballController.requestUserBaseBallNumberInput();
            BallAndStrike ballAndStrike = baseballService.checkBallAndStrike(userBaseBallNumber);

            BaseballView.printGuessValue(ballAndStrike);
            break;
        }



    }

}
