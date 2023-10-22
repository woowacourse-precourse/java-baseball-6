package baseball;

public class GameManager {
    private MessageManager messageManager = new MessageManager();
    private Data data = new Data();
    private GameProcessor gameProcessor = new GameProcessor();

    public void proceedIntro() {
        messageManager.showIntro();
        data.setUserAnswerNumber(messageManager.getUserAnswerNumber());

        gameProcessor.IllegalArgumentException(data);
    }

    public void proceedMainGame() {
        messageManager.showAnswer(data, gameProcessor, messageManager);
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
