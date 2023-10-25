package baseball;


public class Controller {
    boolean isPlaying;
    final int STRIKE = 0;
    final int BALL = 1;


    public void startGame() {
        Model baseballModel = new Model();
        View baseballView = new View();
        initGame(baseballModel, baseballView);

        isPlaying = true;

        do {
            savePlayerInput(baseballModel, baseballView);
            calculatePlayerScore(baseballModel, baseballView);
        } while (isPlaying);
    }

    public void initGame(Model baseballModel, View baseballView) {
        baseballModel.initComputerAnswer();
        baseballView.outputGameStart();
    }

    public void savePlayerInput(Model baseballModel, View baseballView) {
        String answerPlayer = baseballView.inputPlayerAnswer();
        baseballModel.validateCheckInputAnswer(answerPlayer);
    }

    public void calculatePlayerScore(Model baseballModel, View baseballView) {
        int[] score = baseballModel.countStrikeBallHits();
        baseballView.outputGameScore(score[STRIKE], score[BALL]);
        if (score[STRIKE] == 3) {
            String playerInput = baseballView.inputPlayerRestart();
            baseballModel.validateCheckInputRestart(playerInput);
            isPlaying = baseballModel.restartGame(playerInput);
        }
    }


}