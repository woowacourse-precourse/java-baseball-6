package baseball.game;

import baseball.dto.GameResult;
import baseball.constant.GameConstant;
import baseball.generator.ComputerNumberGenerator;
import baseball.generator.ResultGenerator;
import baseball.input.ChoiceInputProcessor;
import baseball.input.GuessInputProcessor;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final ChoiceInputProcessor choiceInputProcessor;
    private final GuessInputProcessor guessInputProcessor;
    private final ComputerNumberGenerator computerNumberGenerator;
    private final OutputView outputView;
    private final ResultGenerator resultGenerator;
    private List<Integer> computerNumbers;

    public GameController(ChoiceInputProcessor choiceInputProcessor,
                          GuessInputProcessor guessInputProcessor,
                          ComputerNumberGenerator computerNumberGenerator,
                          OutputView outputView,
                          ResultGenerator resultGenerator) {
        this.choiceInputProcessor = choiceInputProcessor;
        this.guessInputProcessor =guessInputProcessor;
        this.computerNumberGenerator = computerNumberGenerator;
        this.outputView = outputView;
        this.resultGenerator = resultGenerator;
    }

    public void initializeGameSession(){
        computerNumbers = computerNumberGenerator.makeUniqueNumbers();
        outputView.printStartMessage();
    }

    public boolean playGameSession(){
        while(true){
            if (playSingleRound())
                break;
        }
        return askForGameRestart();
    }

    private boolean playSingleRound(){
        outputView.printInputMessage();
        List<Integer> userGuess = guessInputProcessor.obtainValidUserGuess();
        return checkGuessResult(userGuess);
    }

    private boolean checkGuessResult(List<Integer> userNumbers) {
        GameResult gameResult = resultGenerator.makeResult(userNumbers, computerNumbers);
        outputView.printResultMessage(gameResult);
        return gameResult.strike() == GameConstant.GAME_DIGIT.getValue();
    }

    private boolean askForGameRestart() {
        outputView.printEndMessage();
        outputView.printRestartMessage();
        int restartChoice = choiceInputProcessor.obtainValidUserChoice();
        return restartChoice == GameConstant.RESTART_CHOICE.getValue();
    }
}
