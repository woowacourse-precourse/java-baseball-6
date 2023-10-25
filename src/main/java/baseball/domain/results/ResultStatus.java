package baseball.domain.results;

public enum ResultStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃");

    private final String description;

    ResultStatus(String description) {
        this.description = description;
    }

    public String getDescriptionWithCount(int count) {
        if (count == 0) {
            return "";
        }
        String description = getDescription();
        return count + description;
    }

    private String getDescription() {
        return description;
    }
}
