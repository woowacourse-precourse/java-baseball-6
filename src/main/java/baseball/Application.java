package baseball;

public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");

        RandomNum randomNum = new RandomNum();
        StartGame startGame = new StartGame();
        startGame.playerNum();


    }
}

