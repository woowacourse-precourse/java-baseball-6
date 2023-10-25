package baseball;

public class BaseballGame {
    private boolean isPlaying;
    final int INPUT_LENGTH_MAX = 3;
    final int STRIKE = 0;
    final int BALL = 1;

    public void startGame() {
        isPlaying = true;
        Model baseballModel = new Model();

        String playerInput = "";
        String answerComputer = "";
        answerComputer = baseballModel.initComputerAnswer();
        View.outputGameStart();

        Integer[] score;
        do {
            playerInput = View.inputPlayerAnswer();
            baseballModel.validateCheckInputAnswer(playerInput);

            //answer player
            score = baseballModel.countStrikeBallHits(playerInput, answerComputer);
            View.outputGameScore(score[STRIKE], score[BALL]);

            //answer player
            if (score[STRIKE] == INPUT_LENGTH_MAX) {
                playerInput = View.inputPlayerRestart();
                baseballModel.validateCheckInputRestart(playerInput);
                answerComputer = baseballModel.initComputerAnswer();
                restartGame(playerInput);
            }
        } while (isPlaying);
    }


    public void restartGame(String playerInput) {
        if (playerInput.equals("1")) {
            isPlaying = true;
        }
        if (playerInput.equals("2")) {
            isPlaying = false;
        }

    }


}
