package baseball;

import java.util.List;

public class Application {

    public static List<Integer> computer; //컴퓨터의 숫자
    public static List<Integer> player; //플레이어의 숫자
    public static boolean CONTINUE_GAME = true; //재시작, 종료 구분하는 변수

    public static void main(String[] args) {

        gameStart(); //게임 시작 문구 출력

        while (CONTINUE_GAME) {
            game();
        }
    }

    private static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}

