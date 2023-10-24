package baseball.view;

import baseball.model.Balls;
import baseball.model.Ground;
import baseball.model.Referee;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final InputView inputView;

    public OutputView(InputView inputView) {
        this.inputView = inputView;
    }

    public boolean start() {
        List<Integer> computerNumber = getComputerNumber();
        Balls computer = Balls.of(computerNumber);
        Referee.setFailAnswer();
        run(computer);

        Referee.setSuccessAnswer();
        System.out.println(Referee.getAnswer());
        inputView.scanIfTerminate();

        return inputView.isTerminate();
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    private void run(Balls computer) {
        while (!Referee.getAnswer().equals("3스트라이크")) {
            System.out.println(computer);
            List<Integer> userNumbers = inputView.scanNumbers();
            Balls user = Balls.of(userNumbers);
            Ground ground = computer.computeFromBallsToGround(user);
            Referee.setAnswerToGround(ground);
            System.out.println(Referee.getAnswer());
        }
    }
}
