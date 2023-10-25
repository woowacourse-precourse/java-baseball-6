package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {
    HashMap<Integer, Boolean> exist = new HashMap<>();
    HashMap<String,Integer> result = new HashMap<>();
    List<Integer> computer = new ArrayList<>();
    String input;

    public void initGame() {
        exist.clear(); computer.clear(); result.clear(); input = null;
    }

    public void initInputAndResult() {
        result.clear();
        input = null;
    }

    public void saveInput(String input) {
        this.input = input;
    }

}
