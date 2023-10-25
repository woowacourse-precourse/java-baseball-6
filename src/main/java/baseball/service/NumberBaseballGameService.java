package baseball.service;

import baseball.domain.BaseballNumberMaker;
import baseball.domain.dto.GameResult;
import baseball.domain.gamedata.BaseballNumber;
import baseball.domain.gamedata.GameData;
import baseball.exception.BusinessException;
import baseball.exception.ExceptionCode;

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

    private void validateType(final GameData data) {
        if (!(data instanceof BaseballNumber)) {
            throw new BusinessException(ExceptionCode.NOT_GAMEDATA_TYPE, this.getClass());
        }
    }
}
