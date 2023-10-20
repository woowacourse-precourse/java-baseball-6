package baseball;

public class Application {
    static int[] answer = {2, 2, 4};
    static int[] keyNum = new int[3];

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void main(String[] args) {
        Application startGame = new Application();
        startGame.startGame();
    }
}
