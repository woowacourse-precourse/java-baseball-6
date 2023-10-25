package baseball;

import java.util.List;

public class CheckingAnswerProcess extends BallCases {

    public void checkingStream(List<Integer> listComputerFixed) {
        boolean win = false;
        do {
            UserInputProcess userInputProcess = new UserInputProcess();
            int correctBalls = correctBallCount(listComputerFixed,userInputProcess.listUserFixedReturn());
            int strikes = strikeCount(listComputerFixed,userInputProcess.listUserFixedReturn());
            if (correctBalls > 0) {
                checkingNoStrikes(strikes,correctBalls);
                if (checkingThreeStrike(strikes)) {
                    break;
                }
                if (strikes > 0) {
                    if (allCorrectBallIsStrike(strikes,correctBalls)) {
                        continue;
                    }
                    correctBallsAndStrikes(strikes,correctBalls);
                }
            }
            nothingCorrect(correctBalls);
        } while (!win);
    }

}
