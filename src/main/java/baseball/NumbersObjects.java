package baseball;

import java.util.List;

public interface NumbersObjects {
    public void add(int number);

    public void deleteAll();

    public int size();

    public boolean contains(int number);

    public List<Integer> getList();
}
