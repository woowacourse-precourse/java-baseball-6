package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageManager extends Messages {
    private String inputResponse;
    public void showIntro() {
        System.out.print(super.getIntroMessage());
        System.out.println();
    }

    public String getInputResponse() {
        System.out.print(super.getInputMessage());
        inputResponse = readLine();
        System.out.println();
        return inputResponse;
    }

//    public void showMessage(GameProcessor gameProcessor, String message) {
//        System.out.print(gameProcessor.getResult() + message);
//    }
}
