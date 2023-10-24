package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        outer:
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            break outer;
        }
    }
}
