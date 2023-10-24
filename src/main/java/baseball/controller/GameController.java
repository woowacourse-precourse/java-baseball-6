package baseball.controller;

import baseball.validation.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class GameController {
    private LogicController logicController;
    private InputView inputView;
    private OutputView outputView;
    private NumberValidator numberValidator;
    private ComputerController computerController;
    private boolean endGame = false;

    public GameController(){
        this.logicController = new LogicController();
        this.outputView = new OutputView();
        this.inputView = InputView.getInstance();
        this.numberValidator = new NumberValidator();
        this.computerController = new ComputerController();
    }

    public void startGame() {
        computerController.setGameClearNumber();
        do{
            outputView.nolineDisplayMessage("숫자를 입력해주세요 : ");
            String userInput = inputView.inputNumber();
            numberValidator.isValidNumber(userInput);
            if(logicController.judge(userInput)){
                outputView.displayMessage("3스트라이크");
                outputView.displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                setEndGame(true);
            }else {
                Map<String, Integer> scoreboard = logicController.getScoreboard();
                if (scoreboard.get("ball") != 0 && (scoreboard.get("strike") == 0)) outputView.displayBallScore(scoreboard.get("ball"));
                if (scoreboard.get("strike") != 0 && (scoreboard.get("ball")==0)) outputView.displayStrikeScore(scoreboard.get("strike"));
                else if(scoreboard.get("ball") == 0 && scoreboard.get("strike") == 0 ) {
                    outputView.displayMessage("낫싱");
                } else if(scoreboard.get("strike") != 0 && scoreboard.get("ball") != 0 ){
                    outputView.displayScore(scoreboard.get("ball"),scoreboard.get("strike"));
                }
            }
        }while (!this.endGame);
    }
    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
    public boolean ynReStart(){
        boolean playAgain;
        outputView.displayMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = inputView.restartInputNumber();
        playAgain = (restartNumber.equals("1")) ? true : false;
        return playAgain;
    }
}
