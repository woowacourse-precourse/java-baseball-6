package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restart = 1;
        while (restart == 1) {
            BaseballGame baseBallGame = new BaseballGame();
            User user = new User();
            baseBallGame.gameStart(user);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = user.inputRestartNumber();
        }
    }
}
