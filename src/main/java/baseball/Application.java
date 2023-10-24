package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        do{
            BaseballGame baseballGame=new BaseballGame();
            baseballGame.startBaseballGame();
        }while(GameInstructions.askRetryOrExit()==1);
    }
}
