package baseball;

public class Application {
    public static void main(String[] args) {
        var server = new Server();
        System.out.println("숫자 야구 게임을 시작합니다.");
        server.run();
    }
}
