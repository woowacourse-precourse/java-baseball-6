package baseball.application;

import baseball.domain.BaseBallReferee;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberGenerator;
import baseball.domain.BaseballResult;
import baseball.infra.BaseballNumberGeneratorType;

public class BaseballGameService {

    private final BaseBallReferee baseBallReferee;
    private final BaseballGeneratorFactory baseballGeneratorFactory;

    public BaseballGameService(BaseBallReferee baseBallReferee, BaseballGeneratorFactory baseballGeneratorFactory) {
        this.baseBallReferee = baseBallReferee;
        this.baseballGeneratorFactory = baseballGeneratorFactory;
    }

    public BaseballNumber makeBaseballNumber(BaseballNumberGeneratorType baseballNumberGeneratorType) throws IllegalArgumentException{
        BaseballNumberGenerator baseballNumberGenerator = baseballGeneratorFactory.getBaseballNumberGenerator(baseballNumberGeneratorType);
        return new BaseballNumber(baseballNumberGenerator);
    }

    public BaseballResult returnBaseballResult(BaseballNumber userBaseballNumber, BaseballNumber computerBaseballNumber) {
        return baseBallReferee.returnBaseballResult(userBaseballNumber, computerBaseballNumber);
    }


}
