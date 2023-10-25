package baseball.dto;

public record BaseballResultDto(
        int ballCnt,
        int strikeCnt,
        String messageFormat
) {
}
