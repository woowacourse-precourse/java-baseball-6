package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Round {

    private final Computer computer;

    public Round(Computer computer) {
        this.computer = computer;
    }

    public boolean isGameEnd() {
        String userStringNumber = getUserInput();
        int strikeCount = getStrikeCount(userStringNumber);
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private int getStrikeCount(String userStringNumber) {
        User user = new User(userStringNumber);
        Comparer comparer = new Comparer(computer, user);
        HashMap<String, Integer> compareResult = comparer.getCompareResult();
        return compareResult.get("strikeCount");
    }
}