package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        startMessage();
        doGame();
        endMessage();
        restartGame();
    }

    static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void doGame() {
        System.out.println("숫자를 입력해주세요 : 123");
        System.out.println("1볼 1스트라이크");


        ArrayList<String> a = new ArrayList<>();
        a.add("낫싱");
        a.add("3스트라이크");
        a.add("1볼 1스트라이크");
        a.add("게임 종료");
        System.out.println(a);
    }

    static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
