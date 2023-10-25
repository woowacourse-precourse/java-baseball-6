package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Round {

    private final int roundResult;

    public Round(Computer computer) {
        Comparer comparer = generateComparer(computer);
        roundResult = getRoundResult(comparer);
    }

    public boolean isGameEnd() {
        if (roundResult == Constant.NUMBER_LENGTH) {
            System.out.println(SystemMessage.GAME_END_MESSAGE);
            return true;
        }
        return false;
    }

    private int getRoundResult(Comparer comparer) {
        return comparer.getStrikeCount();
    }

    private Comparer generateComparer(Computer computer) {
        User user = generateUser();
        return new Comparer(computer, user);
    }

    private User generateUser() {
        return new User(getUserInput());
    }

    private String getUserInput() {
        System.out.print(SystemMessage.NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}