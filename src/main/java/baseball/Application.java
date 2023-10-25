package baseball;

public class Application {

    public static void main(String[] args) {
        SequenceManager sequenceManager = new SequenceManager();

        while (sequenceManager.validateRestart()) {

            sequenceManager.proceedIntro();

            sequenceManager.proceedMainGame();

            sequenceManager.proceedOutro();
        }
    }
}