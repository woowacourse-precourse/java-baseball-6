package baseball.service;

import baseball.domain.Coachs;

import java.util.Collections;
import java.util.List;

public class CoachsDTO {
    private final List<String> coachNames;

    public CoachsDTO(Coachs coachs) {
        this.coachNames = coachs.getCoachNames();
    }

    public List<String> getCoachNames() {
        return Collections.unmodifiableList(coachNames);
    }
}
