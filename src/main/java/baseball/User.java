package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> prediction;
    private boolean continued;

    public User() {
        prediction = new ArrayList<>();
        continued = true;
    }

    public List<Integer> getPrediction() {
        return prediction;
    }

    public boolean isContinued() {
        return continued;
    }

    public void setPrediction(List<Integer> prediction) {
        this.prediction.clear();
        this.prediction.addAll(prediction);
    }

    public void setContinued(boolean continued) {
        this.continued = continued;
    }

}
