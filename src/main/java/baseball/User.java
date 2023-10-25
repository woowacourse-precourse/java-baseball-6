package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> prediction;
    private String continued;

    public User() {
        prediction = new ArrayList<>();
        continued = "1";
    }

    public List<Integer> getPrediction() {
        return prediction;
    }

    public boolean isContinued() throws IllegalArgumentException {
        if (continued.equals("1")) {
            return true;
        }

        if (continued.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public void setPrediction(List<Integer> prediction) {
        this.prediction.clear();
        this.prediction.addAll(prediction);
    }

    public void decide() {
        Application.printReGameMessage();
        this.continued = Console.readLine();
    }
}
