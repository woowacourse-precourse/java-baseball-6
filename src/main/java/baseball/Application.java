package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("낫싱");
        a.add("3스트라이크");
        a.add("1볼 1스트라이크");
        a.add("게임 종료");
        System.out.println(a);
        throw new IllegalArgumentException("1234");
    }
}
