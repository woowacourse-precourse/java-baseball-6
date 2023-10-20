package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> user = new ArrayList<>();

    public void getIntArray(String input) {
        String[] temp = input.split("");
        for (String str : temp) {
            if (!user.contains(Integer.parseInt(str))) {
                user.add(Integer.parseInt(str));
            }
        }
    }

    public void clearList() {
        user.clear();
    }

    public List<Integer> getList() {
        return user;
    }
}
