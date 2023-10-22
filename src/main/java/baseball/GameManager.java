package baseball;

public class GameManager {
    private MessageManager messageManager = new MessageManager();
    private Data data = new Data();
    private GameProcessor gameProcessor = new GameProcessor();

    public void proceedIntro() {
        messageManager.showIntro();
    }

    public void proceedMainGame() {
        while (!gameProcessor.validateCompleteAnswer(data)) {
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

    public boolean validateCompleteAnswer() {
        return gameProcessor.validateCompleteAnswer(data);
    }

    public void proceedOutro() {
        messageManager.getUserContinueResponse();
        data.setWillRestartResponse(messageManager.getWillRestartMessage());
    }

    public boolean validateRestart() {
        boolean restart = false;
        if (messageManager.getWillRestartMessage().equals("1")) {
            restart = true;
        }
        return restart;
    }
}
