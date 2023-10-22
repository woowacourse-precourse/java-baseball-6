package baseball;

public class Game {
    Computer computer = new Computer();
    User user = new User();
    CheckNum checkNum = new CheckNum();
    boolean goNot = true;

    public void gameStart() {
        while (goNot) {
            computer.start_Com();
            guessingAnswer();
        }
    }

    private void guessingAnswer() {
        while (true) {
            user.start_user();
            checkNum.start_score();
            if (checkNum.print_score(user.userNum, computer.comNum)) {
                goNot = user.restart();
                break;
            }
        }
    }
}