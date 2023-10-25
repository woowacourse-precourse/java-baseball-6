package baseball;

import java.util.Set;

import static baseball.BaseballConstants.MAX_LENGTH_USER_NUMBER_SIZE;

public class GameController {
    private final User user;
    private final Computer computer;
    private final GameSupervisor gameSupervisor;


    public GameController(User user, Computer computer, GameSupervisor gameSupervisor) {
        this.user = user;
        this.computer = computer;
        this.gameSupervisor = gameSupervisor;
    }

    public String evaluateUserNum(String userNum) {
        return processUserInput(userNum);
    }

    private String processUserInput(String userNum) {

        Set<Integer> comRandomNum = computer.getNumGenerator();
        String result = "";

        for (int i = 0; i < MAX_LENGTH_USER_NUMBER_SIZE; i++) {
            int userInputNum = Character.getNumericValue(userNum.charAt(i));
            result = supervisorResult(comRandomNum, userInputNum, i);
        }

        return result;
    }

    private String supervisorResult(Set<Integer> comRandomNum, int userInputNum, int i) {
        return gameSupervisor.evaluateResult(comRandomNum, userInputNum, i);
    }


    public User getUser() {
        return user;
    }

    public Computer getComputer() {
        return computer;
    }
}
