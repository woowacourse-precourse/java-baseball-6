package baseball.baseballGame;

import baseball.game.Config;
import baseball.game.Game;
import baseball.game.Printer;
import baseball.game.RandomNumsGenerator;
import baseball.game.Validator;
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
        preset();
        while (!result.getCorrect()) {
            printer.printGuessNumMessage();
            inputUserNumber();
            judge();
            printer.printScore(result);
        }
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

    void preset() {
        targetNums = new ArrayList<>();
        targetNums = targetNumsGenerator.generate();
        result = new BaseballForm();
    }

    void judge() {
        compareMachine.compare(targetNums, userNums, config.getNumOfNumbers());
        result = compareMachine.getResult();
    }

    void inputUserNumber() {
        userNums = new ArrayList<>();
        String inStr;
        inStr = Console.readLine();
        validator.validateLength(inStr);
        for (char cur : inStr.toCharArray()) {
            validator.validateRange(cur);
            validator.validateDuplication(cur, userNums);
            userNums.add(cur - '0');
        }
    }
}
