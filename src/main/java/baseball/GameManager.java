package baseball;

import java.util.ArrayList;

public class GameManager {
    private MessageManager messageManager = new MessageManager();
    private Data data = new Data();
    private GameProcessor gameProcessor = new GameProcessor();

    public void proceedIntro() {
        messageManager.showIntro();
//        data.setRandomNumberList(new ArrayList<>());
        data = new Data();
    }

    public void proceedMainGame() {
        while (!data.getIsCompleteAnswer()) {
            try {
                data.setUserAnswerNumber(messageManager.getUserAnswerNumber());

                if (gameProcessor.illegalArgumentException(data)) {
                    throw new IllegalArgumentException();
                }

                messageManager.showAnswer(data, gameProcessor, messageManager);
            } catch (IllegalArgumentException e) {
                data.setDigitSizeError(true);
                break;
            }
        }
    }

    public boolean validateAnswerComplete() {
        return gameProcessor.validateCompleteAnswer(data);
    }

    public void proceedOutro() {
        if (validateAnswerComplete()) {
            System.out.println(messageManager.getOutroMessage());
        }

        if (validateRestart()) {
            String continueResponse = messageManager.getUserContinueResponse();
            data.setWillRestartResponse(continueResponse);
        }
    }

    public boolean validateRestart() {
        boolean restart = true;
        if (data.getWillRestartResponse().equals("2")) {
            restart = false;
        }
        return restart;
    }
}
