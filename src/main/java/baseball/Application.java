package baseball;

public class Application {
    static BaseBallGame baseBallGame = new BaseBallGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            String result = baseBallGame.start();
            if(result.equals("게임 종료")) break;
        }
    }
}
