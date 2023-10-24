package baseball;


import baseball.baseballGame.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        // 숫자 3개로 숫자 야구 게임 시작
        BaseBallGame bGame = new BaseBallGame(3);
        bGame.start();
    }
}
