package baseball;

public class Baseball {


    public void play() {
        do {
            playOneGame();
        } while (doRestartOrNot());
    }

    private void playOneGame() {
        int answer = generateRandomNum();

        while(true) {
            int input = getUserInput();
            boolean isCorrect = getResult(input);

            if(isCorrect)
                break;
        }
    }

    private int generateRandomNum() {
        return 0;
    }

    private int getUserInput() {
        return 0;
    }

    private boolean getResult(int input) {
        return false;
    }

    private boolean doRestartOrNot() {
        return false;
    }
}
