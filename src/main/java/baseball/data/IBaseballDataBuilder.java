package baseball.data;

import baseball.util.IRandomValueGenerator;

public interface IBaseballDataBuilder {

    IBaseballData createComputerData();

    IBaseballData createUserData(String userData);
}
