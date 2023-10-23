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
            data.setUserNumber(messageManager.getInputNumber());

            if (gameProcessor.illegalArgumentException(data)) {
                data.setIsNoError(false);
                throw new IllegalArgumentException();
            }

            messageManager.showAnswer(data, gameProcessor, messageManager);
        }
    }

    public void proceedOutro() {
        if (gameProcessor.validateFullStrike(data) && data.getIsNoError()) {
            System.out.println(messageManager.getFullStrikeText());
        }

        if (validateRestart() && data.getIsNoError()) {
            String continueResponse = messageManager.getContinueResponse();
            data.setRestartResponse(continueResponse);
        }
    }

    public boolean validateRestart() {
        boolean restart = true;
        if (data.getRestartResponse().equals(CLOSEGAMEINPUT) || !data.getIsNoError()) {
            restart = false;
        }
        return restart;
    }
}