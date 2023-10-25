package baseball.domain;

import java.util.HashMap;

public class BaseballResultRepository {
    private Integer strike;
    private Integer ball;
    private static HashMap<String, Integer> baseball = new HashMap<>();
    private static final BaseballResultRepository instance = new BaseballResultRepository();

    public BaseballResultRepository() {
        baseball.put("strike", 0);
        baseball.put("ball", 0);
    }

    public static BaseballResultRepository getInstance() {
        return instance;
    }

    public Integer getStrike() {
        return baseball.get("strike");
    }

    public void setStrike(Integer strike) {
        baseball.replace("strike", strike);
    }

    public Integer getBall() {
        return baseball.get("ball");
    }

    public void setBall(Integer ball) {
        baseball.replace("ball", ball);
    }

    public void addBall() {
        setBall(baseball.get("ball") + 1);
    }

    public void subBall() {
        setBall(baseball.get("ball") - 1);
    }

    public void addStrike() {
        setStrike(baseball.get("strike") + 1);
    }

    public void clear() {
        baseball.clear();
        baseball.put("strike", 0);
        baseball.put("ball", 0);
    }
}
