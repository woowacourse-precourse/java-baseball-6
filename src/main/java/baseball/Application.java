package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View.printStartMessage();
        do {
            Game game = new Game();
            game.run();
        }while (continueOrExit());

    }
    public static boolean continueOrExit(){
        String answer = View.continueOrExitGame();
        if(answer.equals("1")) return true;
        return false;
    }
}
