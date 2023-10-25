package baseball;

import java.util.ArrayList;
import java.util.List;

public class ResultOfGame {
    private List<String> resultOfGame = new ArrayList<>();


    public void initResult() {
        while (resultOfGame.size() < 3) {
            resultOfGame.add("nothing");
        }
    }

    public void add(String result) {
        resultOfGame.add(result);
    }

    public String get(int index) {
        return resultOfGame.get(index);
    }


    public void deleteAll() {
        resultOfGame.clear();
    }


    public int size() {
        return resultOfGame.size();
    }

    public void update(int index, String result) {
        resultOfGame.set(index, result);
    }


    public List<String> getList() {
        return resultOfGame;
    }
}
