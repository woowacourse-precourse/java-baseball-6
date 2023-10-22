package baseball.service;

import baseball.domain.Referee;
import baseball.utils.RandomNumber;
import baseball.utils.Validator;

import java.util.Arrays;
import java.util.List;

public class Service {
    private final Validator validator = new Validator();
    private Referee referee;

    public void setGame() {
        List<Integer> computer = RandomNumber.createComputerNumber();
        this.referee = new Referee(computer);
    }

    public String playGame(String input) {
        validator.checkUserInput(input);
        List<Integer> userNumber = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt).boxed().toList();
        return referee.getResult(userNumber);
    }

    public boolean finishGame(String input) {
        validator.checkUserFinishInput(input);
        return input.equals("2");
    }
}
