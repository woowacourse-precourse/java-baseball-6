package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import baseball.domain.Balls;
import baseball.exception.DataValidator;
import baseball.service.BallsGenerator;

import java.util.List;

public class DataController {

    private static final String EMPTY_STRING = "";

    private final DataValidator dataValidator;

    private final BallsGenerator ballsGenerator;

    public DataController() {
        this.dataValidator = new DataValidator();
        this.ballsGenerator = new BallsGenerator();
    }

    protected List<String> readValues() {
        String value = readLine();
        dataValidator.validateInputNumber(value);

        return List.of(value.split(EMPTY_STRING));
    }

    public List<Balls> generatePlayerNumbers() {
        List<String> values = readValues();
        return ballsGenerator.generatePlayerNumbers(values);
    }
}
