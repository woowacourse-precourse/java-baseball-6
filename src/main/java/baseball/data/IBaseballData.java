package baseball.data;

public interface IBaseballData<T> {


    BaseballDataCompareResult compare(IBaseballData baseballData);

    T getValue();

    int getSize();
}
