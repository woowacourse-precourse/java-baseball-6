package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import baseball.domain.Balls;
import baseball.exception.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataController {

    private static final int BALL_MAX_SIZE = 3;
    private static final String EMPTY_STRING = "";

    private DataValidator dataValidator;

    public DataController() {
        dataValidator = new DataValidator();
    }

    private List<String> readValues() {
        String value = readLine();
        dataValidator.validateInputNumber(value);

        return List.of(value.split(EMPTY_STRING));
    }

    public List<Balls> generatePlayerNumbers() {
        List<String> values = readValues();
        List<Balls> ballsList = new ArrayList<>();
        for (int i = 0; i < BALL_MAX_SIZE; i++) {
            ballsList.add(new Balls(Integer.parseInt(values.get(i)), i));
        }
        return ballsList;
    }
}
