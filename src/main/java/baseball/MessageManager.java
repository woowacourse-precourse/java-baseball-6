package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageManager extends Messages {
    public void showIntro() {
        System.out.print(super.getIntroMessage());
        System.out.println();
    }

    public String getInput() {
        System.out.print(super.getInputMessage());
        String input = readLine();
        System.out.println();
        return input;
    }

    public void showMessage(GameProcessor gameProcessor, String message) {
        System.out.print(gameProcessor.getResult() + message);
    }
}
