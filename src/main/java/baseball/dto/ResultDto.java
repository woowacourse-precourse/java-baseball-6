package baseball.dto;

public record ResultDto(
        int ball,
        int strike,
        String messageFormat
) {
}