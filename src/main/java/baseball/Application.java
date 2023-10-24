package baseball;

public class Application {

    public static void main(String[] args) {

        int gameLength = 3; //몇자리 야구 게임

        BaseballGame baseballGame = new BaseballGame(gameLength);

        while (baseballGame.startGame()) ;

    }

}
