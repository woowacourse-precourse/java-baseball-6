package baseball.controller;

import baseball.exception.Exception;
import baseball.domain.Score;
import baseball.service.Service;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Service service = new Service();

    public void generateRandomValue()   {
        service.generateRandomValue();
    }

    public Score getScore (String input) {
        return service.getScore(input);
    }

}
