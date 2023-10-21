package baseball;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbers implements NumbersObjects {
    private List<Integer> player = new ArrayList<>();

    public void add(int number) {
        player.add(number);
    }

    @Override
    public int get(int index) {
        return player.get(index);
    }

    public void deleteAll() {
        player.clear();
    }

    public int size() {
        return player.size();
    }

    public boolean contains(int number) {
        return player.contains(number);
    }

    public List<Integer> getList() {
        return player;
    }
}
