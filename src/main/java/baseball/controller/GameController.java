package baseball.controller;

import baseball.domain.GameResult;
import baseball.domain.RandomNumbers;
import baseball.domain.UserNumbers;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;


public class GameController {

    private List<Integer> computerNumberList;
    public void StartGame() {
        Output.PrintInitialMessage();
        InitializeGame();
        //ProcessGame();
    }

    private void InitializeGame() {
        // RandomNumbers 생성
        RandomNumbers randomNumbers = new RandomNumbers();
        this.computerNumberList = randomNumbers.getComputerNumberList();
        //ystem.out.println(computerNumberList); //del
        ProcessGame();

    }

    private void ProcessGame() {
        boolean isCorrectAnswer=false;
        do {
            UserNumbers userNumbers = new UserNumbers();
            userNumbers.ValidateNumbers();
            GameResult gameResult = new GameResult();
            gameResult.calculateResult(computerNumberList, userNumbers.getUserNumberList());
            Output.PrintResultMessage(gameResult.getBallNumber(), gameResult.getStrikeNumber());
            if(gameResult.getStrikeNumber()==3) {
                isCorrectAnswer=true;
            }
        } while(!isCorrectAnswer);
        EndGame();
    }

    private void EndGame() {
        String exitNumber;
        Output.PrintExitMessage();
        exitNumber = Input.GetExitNumberInput();
        if (exitNumber.equals("1")) {
            InitializeGame();
        } else if (exitNumber.equals("2")) {

        } else {
            throw new IllegalStateException("잘못된 수");
        }
    }
}
