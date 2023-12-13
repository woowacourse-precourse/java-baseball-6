package baseball.dto;

public class ShutDownOrReplayDto {
    private final String input;

    public ShutDownOrReplayDto(String input) {
        this.input = input;
    }


    public TerminateEnum toTerminateEnum() {
        return TerminateEnum.findTerminateEnumByValue(Integer.parseInt(input));
    }

}
