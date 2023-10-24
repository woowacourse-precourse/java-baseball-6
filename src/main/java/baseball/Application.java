package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame baseballGame = new BaseballGame();
        while(baseballGame.run() == 1);
        System.out.println("게임 종료");
    }
}
