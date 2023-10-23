package baseball;

public class SequenceManager {

    private MessageManager messageManager = new MessageManager();
    private Data data = new Data();
    private GameProcessor gameProcessor = new GameProcessor();

    public void proceedIntro() {
        messageManager.showIntro();
        data = new Data();
    }

    public void proceedMainGame() {
        while (!data.getIsCompleteAnswer() && data.getIsNoError()) {
            data.setUserAnswerNumber(messageManager.getUserAnswerNumber());

            if (gameProcessor.illegalArgumentException(data)) {
                data.setIsNoError(false);
                throw new IllegalArgumentException("게임 종료");
            }

            messageManager.showAnswer(data, gameProcessor, messageManager);
        }
    }

    public boolean validateCompleteAnswer() {
        return gameProcessor.validateCompleteAnswer(data);
    }

    public void proceedOutro() {
        if (validateCompleteAnswer() && data.getIsNoError()) {
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
