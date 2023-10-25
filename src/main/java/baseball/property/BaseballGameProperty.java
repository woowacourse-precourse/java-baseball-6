package baseball.property;

/**
 * @author 민경수
 * @description base ball game property
 * @since 2023.10.23
 **********************************************************************************************************************/
public class BaseballGameProperty {

    private Integer digit;
    private Integer usableSingleNumberFrom;
    private Integer usableSingleNumberTo;

    public BaseballGameProperty(Integer digit, Integer usableNumberFrom, Integer usableSingleNumberTo) {
        this.digit = digit;
        this.usableSingleNumberFrom = usableNumberFrom;
        this.usableSingleNumberTo = usableSingleNumberTo;
    }

    public Integer digit() {
        return digit;
    }

    public Integer usableSingleNumberFrom() {
        return usableSingleNumberFrom;
    }

    public Integer usableSingleNumberTo() {
        return usableSingleNumberTo;
    }

    public Integer minimumRange() {
        StringBuilder builder = new StringBuilder();
        builder.append(1);

        for (int i = 1; i < digit; ++i) {
            builder.append(0);
        }

        return Integer.parseInt(builder.toString());
    }

    public Integer maximumRange() {
        return this.minimumRange() * 10 - 1;
    }

}