package baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coachs {
    private final int MIN_COACH_NUMBER = 2;
    private final int MAX_COACH_NUMBER = 5;
    private final List<Coach> coachs;

    public Coachs(List<String> coachNames) {
        if (isDuplicated(coachNames)) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복을 허용하지 않습니다.");
        }
        if (coachNames.size() < MIN_COACH_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coachNames.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 이하 입력해야 합니다.");
        }
        this.coachs = coachNames.stream().map(Coach::new).collect(Collectors.toList());
    }

    private static boolean isDuplicated(List<String> coachNames) {
        return coachNames.stream().distinct().count() != coachNames.size();
    }

    public List<Coach> getCoachs() {
        return Collections.unmodifiableList(coachs);
    }

    public List<String> getCoachNames() {
        return coachs.stream().map(Coach::getName).collect(Collectors.toList());
    }

    public Coach findCoachByName(String coachName) {
        return coachs.stream()
                .filter(coach -> coach.hasName(coachName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
    }
}
