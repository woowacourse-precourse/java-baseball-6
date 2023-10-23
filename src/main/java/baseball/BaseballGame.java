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

}
