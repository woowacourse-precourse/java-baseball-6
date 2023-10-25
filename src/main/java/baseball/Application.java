package baseball;

public class Application {
    public static void main(String[] args) {

        boolean start = true;

        while (start) {

            Player computer = new ComputerPlayer();
            Player human = new HumanPlayer();
            Judge judge = new Judge(computer, human);

            start = judge.startGame();
        }
    }
}
