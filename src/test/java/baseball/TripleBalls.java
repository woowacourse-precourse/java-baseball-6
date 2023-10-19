package baseball;

import java.util.ArrayList;
import java.util.List;

public class TrippleBalls {
    private final List<Ball> trippleBalls;

    public TrippleBalls(List<Ball> trippleBalls) {
        this.trippleBalls = trippleBalls;
    }

    public List<Ball> getTrippleBalls() {
        return new ArrayList<>(trippleBalls);
    }
}
