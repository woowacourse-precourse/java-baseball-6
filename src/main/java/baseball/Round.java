package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Round {
    private final int NUMBER_LENGTH = 3;
    private final int roundResult;

    public Round(Computer computer) {
        Comparer comparer = generateComparer(computer);
        roundResult = getRoundResult(comparer);
    }

    public boolean isGameEnd() {
        if (roundResult == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}