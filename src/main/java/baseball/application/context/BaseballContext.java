package baseball.application.context;

import baseball.application.config.BaseballConfig;
import baseball.application.converter.StringConverter;
import baseball.application.random.RandomGenerator;
import baseball.domain.baseballnumber.BaseballNumbers;
import baseball.domain.compararesult.CompareResult;
import baseball.domain.comparator.Comparator;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import baseball.domain.restartflag.RestartFlag;
import baseball.util.random.Range;
import java.util.List;

public class BaseballContext {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    private final StringConverter stringConverter;
    private final RandomGenerator random;

    private Computer computer;
    private Player player;

    public BaseballContext(BaseballConfig config) {
        this.stringConverter = config.stringConverter();
        this.random = config.randomGenerator();
    }

    public void init() {
        computer = new Computer(generateRandomComputerNumbers());
        player = new Player();
    }

    public void changePlayerNumber(String input) {
        List<Integer> numbers = stringConverter.toIntList(input);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        player.changeNumbers(baseballNumbers);
    }

    public CompareResult compareNumbers() {
        Comparator comparator = new Comparator(computer, player);
        return comparator.compare();
    }

    public RestartFlag inputRestartFlag(String input) {
        int flag = stringConverter.toInt(input);
        return new RestartFlag(flag);
    }

    private BaseballNumbers generateRandomComputerNumbers() {
        Range range = new Range(START_INCLUSIVE, END_INCLUSIVE);
        List<Integer> randomNumbers = random.pickUniqueNumbersInRange(range, COUNT);
        System.out.println(randomNumbers);
        return new BaseballNumbers(randomNumbers);
    }
}
