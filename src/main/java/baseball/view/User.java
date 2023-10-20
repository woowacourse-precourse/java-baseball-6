package baseball.view;

import java.util.Scanner;

public class User {

    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요: ";

    private Scanner sc = new Scanner(System.in);

    public void showStartMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    public int getUserInput() {
        System.out.print(USER_INPUT_MESSAGE);
        return sc.nextInt();
    }

}
