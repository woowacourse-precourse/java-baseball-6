package baseball.domain;

import java.util.List;

public class User {
    private Baseball baseball;

    public void applyBaseball(final List<Integer> balls) {
        this.baseball = Baseball.of(balls);
    }

    public List<Integer> getBaseball() {
        return baseball.getBalls();
    }
}
