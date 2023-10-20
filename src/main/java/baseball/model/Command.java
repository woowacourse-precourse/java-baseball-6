package baseball.model;

public enum Command {
    RESTART("1"),
    QUIT("2");

    final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    // TODO: 과연 정말 괜찮은 메서드인지 고민해보기
    public static Command getCommand(String value) {
        for (Command command : Command.values()) {
            if (command.getValue().equals(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException("잘못된 재시작/종료 입력입니다.");
    }

    @Override
    public String toString() {
        return this.value;
    }
}
