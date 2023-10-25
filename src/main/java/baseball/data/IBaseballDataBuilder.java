package baseball.data;

import baseball.util.IRandomValueGenerator;

public interface IBaseballDataBuilder<T> {

    IBaseballData<T> createComputerData();

    IBaseballData<T> createUserData(String userData);
}
