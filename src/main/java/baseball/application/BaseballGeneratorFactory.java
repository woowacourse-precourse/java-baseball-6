package baseball.application;

import baseball.domain.BaseballNumberGenerator;
import baseball.infra.BaseballNumberGeneratorType;
import baseball.infra.ComputerBaseballNumberGenerator;
import baseball.infra.UserBaseballNumberGenerator;

public class BaseballGeneratorFactory {
    private static BaseballNumberGenerator userBaseballNumberGenerator = new UserBaseballNumberGenerator();
    private static BaseballNumberGenerator computerBaseballNumberGenerator = new ComputerBaseballNumberGenerator();

    public BaseballNumberGenerator getBaseballNumberGenerator(BaseballNumberGeneratorType baseballNumberGeneratorType) {
        switch (baseballNumberGeneratorType) {
            case USER -> {
                return userBaseballNumberGenerator;
            }
            case COMPUTER -> {
                return computerBaseballNumberGenerator;
            }
            default -> {
                throw new EnumConstantNotPresentException(baseballNumberGeneratorType.getDeclaringClass(), "not define");
            }
        }
    }
}
