package baseball.data;

public interface IBaseballData<T> {


    BaseballDataCompareResult compare(IBaseballData<T> baseballData);

    T getValue();

    int getSize();
}
