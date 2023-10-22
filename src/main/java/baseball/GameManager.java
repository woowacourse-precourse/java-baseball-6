package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameManager {
    private MessageManager messageManager = new MessageManager();
    private Data data = new Data();
    private GameProcessor gameProcessor = new GameProcessor();

    public void proceedIntro() {
        messageManager.showIntro();
        data = new Data();
    }

    public void proceedMainGame() {
        IllegalArgumentException e = new IllegalArgumentException("게임 종료");
        while (!data.getIsCompleteAnswer() && data.getIsNoError()) {
            data.setUserAnswerNumber(messageManager.getUserAnswerNumber());

            if (gameProcessor.illegalArgumentException(data)) {
                data.setIsNoError(false);
                throw e;
            }

            messageManager.showAnswer(data, gameProcessor, messageManager);
        }
    }

    public boolean validateAnswerComplete() {
        return gameProcessor.validateCompleteAnswer(data);
    }

    public void proceedOutro() {
        if (validateAnswerComplete() && data.getIsNoError()) {
            System.out.println(messageManager.getOutroMessage());
        }

        if (validateRestart() && data.getIsNoError()) {
            String continueResponse = messageManager.getUserContinueResponse();
            data.setWillRestartResponse(continueResponse);
        }
    }

    public boolean validateRestart() {
        boolean restart = true;
        if (data.getWillRestartResponse().equals("2") || !data.getIsNoError()) {
            restart = false;
        }
        return restart;
    }
}
