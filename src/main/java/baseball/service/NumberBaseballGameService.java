package baseball.service;

import baseball.domain.BaseballNumberMaker;
import baseball.domain.GameResult;
import baseball.domain.gamedata.BaseballNumber;
import baseball.domain.gamedata.GameData;

public class NumberBaseballGameService implements GameService {

    private final BaseballNumberMaker baseballNumberMaker;
    private BaseballNumber target;

    public NumberBaseballGameService(final BaseballNumberMaker baseballNumberMaker) {
        this.baseballNumberMaker = baseballNumberMaker;
    }

    @Override
    public GameResult calculateResult(final GameData data) {
        validateType(data);
        return target.calculateResult((BaseballNumber) data);
    }

    @Override
    public void init() {
        this.target = baseballNumberMaker.make();
    }

    private static void validateType(final GameData data) {
        if (!(data instanceof BaseballNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
