package baseball.domain;

import java.util.Objects;

public class CoachName {
    private String name;

    public CoachName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자 이상 입력해야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최대 5글자 이하 입력해야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachName coachName = (CoachName) o;
        return Objects.equals(name, coachName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
