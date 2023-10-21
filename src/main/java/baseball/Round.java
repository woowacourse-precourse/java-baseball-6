package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Round {

    private final Computer computer;

    public Round (Computer computer) {
        this.computer = computer;
    }

    public boolean getRoundResult() {
        System.out.print("숫자를 입력해주세요 : ");
        String userStringNumber = Console.readLine();
        User user = new User(userStringNumber);
        Comparer comparer = new Comparer(computer, user);
        ArrayList<Integer> compareResult = comparer.compare();
        int strikeCount = compareResult.get(0);

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
