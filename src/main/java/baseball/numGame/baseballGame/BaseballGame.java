package baseball.numGame.baseballGame;

import baseball.game.Config;
import baseball.game.Game;
import baseball.game.Printer;
import baseball.game.Validator;
import baseball.numGame.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame implements Game {
    List<Integer> targetNums;
    List<Integer> userNums;
    BaseballForm result;
    BaseballPrinter printer;
    RandomNumsGenerator targetNumsGenerator;
    CompareMachine compareMachine;
    BaseballValidator validator;
    BaseballConfig config;

    @Override
    public void playGame() {

    }

    @Override
    public Printer getPrinter() {
        return printer;
    }

    @Override
    public Validator getValidator() {
        return validator;
    }
    @Override
    public Config getConfig(){
        return config;
    }

    public BaseballGame() {
        config = new BaseballConfig();
        printer = new BaseballPrinter();
        targetNumsGenerator = new RandomNumsGenerator(config.getMinOfRange(), config.getMaxOfRange(),
                config.getNumOfNumbers());
        compareMachine = new CompareMachine();
        validator = new BaseballValidator(config);
    }
}
