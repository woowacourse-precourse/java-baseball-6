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

    public GameController(Builder builder){
        this.choiceInputProcessor = builder.choiceInputProcessor;
        this.resultGenerator = builder.resultGenerator;
        this.computerNumberGenerator = builder.computerNumberGenerator;
        this.guessInputProcessor = builder.guessInputProcessor;
        this.outputView = builder.outputView;
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

    public static class Builder{
        private ChoiceInputProcessor choiceInputProcessor;
        private GuessInputProcessor guessInputProcessor;
        private ComputerNumberGenerator computerNumberGenerator;
        private OutputView outputView;
        private ResultGenerator resultGenerator;

        public Builder withChoiceInputProcessor(ChoiceInputProcessor processor) {
            this.choiceInputProcessor = processor;
            return this;
        }

        public Builder withGuessInputProcessor(GuessInputProcessor processor) {
            this.guessInputProcessor = processor;
            return this;
        }

        public Builder withComputerNumberGenerator(ComputerNumberGenerator computerNumberGenerator) {
            this.computerNumberGenerator = computerNumberGenerator;
            return this;
        }

        public Builder withOutputView(OutputView outputView){
            this.outputView = outputView;
            return this;
        }

        public Builder withResultGenerator(ResultGenerator resultGenerator){
            this.resultGenerator = resultGenerator;
            return this;
        }

        public GameController build() {
            return new GameController(this);
        }
    }
}
