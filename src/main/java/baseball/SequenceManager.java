package baseball;

public class SequenceManager {

    private final String CLOSEGAMEINPUT = "2";
    private MessageManager messageManager = new MessageManager();
    private Data data = new Data();
    private GameProcessor gameProcessor = new GameProcessor();

    public void proceedIntro() {
        messageManager.showIntro();
        data = new Data();
    }

    public void proceedMainGame() {
        while (!data.getIsCompleteAnswer() && data.getIsNoError()) {
            data.setUserNumber(messageManager.getUserAnswerNumber());

            if (gameProcessor.illegalArgumentException(data)) {
                data.setIsNoError(false);
                throw new IllegalArgumentException();
            }

            messageManager.showAnswer(data, gameProcessor, messageManager);
        }
    }

    public void proceedOutro() {
        if (gameProcessor.validateCompleteAnswer(data) && data.getIsNoError()) {
            System.out.println(messageManager.getOutroMessage());
        }

        if (validateRestart() && data.getIsNoError()) {
            String continueResponse = messageManager.getUserContinueResponse();
            data.setWillRestartResponse(continueResponse);
        }
    }

    public boolean validateRestart() {
        boolean restart = true;
        if (data.getWillRestartResponse().equals(CLOSEGAMEINPUT) || !data.getIsNoError()) {
            restart = false;
        }
        return restart;
    }
}