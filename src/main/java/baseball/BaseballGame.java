package baseball;

public class BaseballGame {
    private String answerComputer;
    private String answerPlayer;
    private boolean isPlaying;
    final int STRIKE = 0;
    final int BALL = 1;


    public void startGame() {
        Model baseballModel = new Model();
        initGame();
        View.outputGameStart();
        Integer[] score;
        do {
            answerPlayer = View.inputPlayerAnswer();
            baseballModel.validateCheckInputAnswer(answerPlayer);

            //answer player
            score = baseballModel.countStrikeBallHits(answerPlayer, answerComputer);
            View.outputGameScore(score[STRIKE], score[BALL]);

            //answer player
            if (score[STRIKE] == 3) {
                String playerInput = View.inputPlayerRestart();
                baseballModel.validateCheckInputRestart(playerInput);
                restartGame(playerInput);
            }
        } while (isPlaying);
    }

    public void initGame() {
        answerPlayer = "";
        initAnswer();
        isPlaying = true;
    }

    public void initAnswer() {
       this.answerComputer = Model.initComputerAnswer();
    }

    public void restartGame(String playerInput) {
        if (playerInput.equals("1")) {
            initAnswer();
            isPlaying = true;
        }
        if (playerInput.equals("2")) {
            isPlaying = false;
        }

    }

}