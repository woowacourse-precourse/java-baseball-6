package baseball;


public class Controller {
    boolean isPlaying;
    final int STRIKE = 0;
    final int BALL = 1;


    public void startGame() {
        Model baseballModel = new Model();
        View baseballView = new View();

        initGame(baseballModel, baseballView);

        do {
            savePlayerInput(baseballModel, baseballView);
            calculatePlayerScore(baseballModel, baseballView);
        } while (isPlaying);
    }

    private void initGame(Model baseballModel, View baseballView) {
        baseballModel.initComputerAnswer();
        isPlaying = true;
        baseballView.outputGameStart();

    }

    private void savePlayerInput(Model baseballModel, View baseballView) {
        String answerPlayer = baseballView.inputPlayerAnswer();
        baseballModel.validateCheckInputAnswer(answerPlayer);
    }

    private void calculatePlayerScore(Model baseballModel, View baseballView) {

        int[] score = baseballModel.countStrikeBallHits();
        baseballView.outputGameScore(score[STRIKE], score[BALL]);

        // 유저의 점수에 따라 정답 여부 결정후, 재시작 입력 받기
        if (score[STRIKE] == 3) {
            String playerInput = baseballView.inputPlayerRestart();
            baseballModel.validateCheckInputRestart(playerInput);
            isPlaying = baseballModel.restartGame(playerInput);
        }

    }


}