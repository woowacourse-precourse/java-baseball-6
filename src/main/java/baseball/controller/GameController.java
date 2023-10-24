package baseball.controller;

import baseball.Service.GameService;
import baseball.model.Score;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;
    private Score score;
    private final String RETRY = "1";
    private final String END = "2";


    public GameController () {
        gameService = new GameService();
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printStartMessage();
    }//의존 연결 및 시작 메시지 출력

    public void start() {
        play();
        retry();
    }

    private void play() {
        gameService.setGame();

        do{
            inputView.printNumberRequestMessage();
            UserNumber userNumber = new UserNumber(Console.readLine());
            score = gameService.playGame(userNumber);
            outputView.printScoreMessage(score.getStrikeCount(), score.getBallCount());
        } while(!(score.getStrikeCount()==3));
        outputView.printGameEndingMessage();
    }

    private void retry() {
        inputView.printRetryMessage();
        askRetry();
    }

    private void askRetry() throws IllegalArgumentException{
        String userRetryInput = Console.readLine();
        if(userRetryInput.equals(RETRY)) {
            start();
            return;
        }
        if(userRetryInput.equals(END))
            return;
        throw new IllegalArgumentException();
    }
}
