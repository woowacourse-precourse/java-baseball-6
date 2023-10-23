package baseball.domain;

public interface NumberRepository {
    public boolean contain(int pickNumber);
    public Integer findById(int index);
    public void addValue(int pickNumber);
    public void clear();
}
