package baseball.game;

import java.util.Scanner;

public class InputManager {
    public static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void printInfoMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public String requestInput() {
        System.out.println(REQUEST_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
