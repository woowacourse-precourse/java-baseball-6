package baseball.baseballgame;

import baseball.baseballgame.variables.Variables;

import java.util.List;

public class BaseballGameController {

    private BaseballGameViewer viewer;
    private BaseballGameService service;

    public BaseballGameController(BaseballGameViewer viewer, BaseballGameService service) {
        this.viewer = viewer;
        this.service = service;
    }

    public void playGame() {
        boolean restart = true;
        while (restart) {
            List<Integer> computerNumbers = service.generateComputerNumbers();

            boolean userflag = true;

            while (userflag) {
                String input = viewer.getUserGuess();
                List<Integer> userNumbers = service.parseInput(input);
                service.countStrikes(computerNumbers, userNumbers);
                service.countBalls(computerNumbers, userNumbers);
                viewer.displayResult(service.getStrikes(), service.getBalls());

                if (service.getStrikes() == Variables.NUM.getValue()) {
                    userflag = false;
                }
            }

            restart = viewer.hasNewGameMessage();
        }
    }

}

