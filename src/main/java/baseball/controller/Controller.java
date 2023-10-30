package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.model.Model;
import baseball.utility.Utility;
import jdk.jshell.execution.Util;
import baseball.model.Count;
import baseball.verification.Verification;
import java.util.List;

public class Controller {
    public Controller(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Model model = new Model();
        Utility utility = new Utility();
        Verification verification = new Verification();

        boolean finish = false;

        while (finish == false) {
            List<Integer> randomList = utility.getRandomList(3);
            boolean correct = false;

            outputView.printStart();

            while(correct == false) {
                String stringOfNum = inputView.getStringOfNum();

                verification.checkStringIsNum(stringOfNum);
                verification.checkStringLength(stringOfNum);

                Count count = model.getResult(stringOfNum, randomList);
                outputView.printResult(count);

                correct = model.isCorrect(count);
            }

            String finishInput = inputView.getFinishInput();
            verification.checkFinishInput(finishInput);

            finish = model.isFinish(finishInput);
        }
    }
}
