package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumberList;
    private List<Integer> userNumberList;

    public void start() {
        showStart();
        Computer computer = new Computer();
        computerNumberList = computer.generateComputerNumber();
        showInputUserNumber();
        userNumberList = getUsetNumberList();
        int[] compareResult = new int[]{};
        compareResult = new CompareNumber().getCompareResult(userNumberList, computerNumberList);
    }

    private static void showStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void showInputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    private static List<Integer> getUsetNumberList() {
        List<Integer> userNumberList = new ArrayList<>();
        User user = new User();
        String userNumberStr = new String();
        user.inputUserNumber(userNumberStr);
        userNumberList = user.convertInputToList();

        return userNumberList;
    }

    private static void showBallCount(int[] compareResult) {
        if (compareResult[0] != 0) {
            if (compareResult[1] != 0) {
                System.out.println(compareResult[0] + "볼 ");
            } else {
                System.out.println(compareResult[0] + "볼");
            }
        }
    }

    private static void showStrikeCount(int[] compareResult) {
        if (compareResult[1] != 0) {
            System.out.println(compareResult[1] + "스트라이크");
        }
    }
}
