package model;

import controller.InputGameNumber;
import controller.InputReOrEnd;
import view.InputText;
import view.OutputBallCount;
import view.StartText;

import java.util.List;

public class GameMC {

    public void gameStart() {
        int coin = 1;
        while(coin == 1) {
            StartText startText = new StartText();
            startText.printStartText();

            CreateGameNumber createGameNumber = new CreateGameNumber();
            List<Integer> comNum = createGameNumber.createNum();
            InputGameNumber inputGameNumber = new InputGameNumber();
            InputValidation inputValidation = new InputValidation();

            BallCounter ballCounter = new BallCounter();
            OutputBallCount outputBallCount = new OutputBallCount();
            InputText inputText = new InputText();

            int[] result = new int[2];
            while (result[0] != 3) {
                inputText.inputNum();
                List<Integer> userNum = inputGameNumber.inputNum();
                inputValidation.gameNumValidation(userNum);

                result = ballCounter.ballCount(userNum, comNum);
                outputBallCount.printCount(result);
            }

            InputReOrEnd inputReOrEnd = new InputReOrEnd();
            inputText.coinNum();
            coin = inputReOrEnd.inputCoin();
            inputValidation.coinValidation(coin);
        }
    }
}
