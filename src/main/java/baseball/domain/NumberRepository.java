package baseball.domain;

public interface NumberRepository {
    boolean contain(int pickNumber);
    Integer findById(int index);
    void addValue(int pickNumber);
    void clear();
}
