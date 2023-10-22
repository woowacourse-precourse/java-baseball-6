package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseBallGame baseBallGame = BaseBallGame.baseBallGame;

        while(true){
            String result = baseBallGame.start();
            if(result.equals("게임 종료")) break;
        }
    }
}
