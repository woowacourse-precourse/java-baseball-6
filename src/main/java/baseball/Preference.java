package baseball;

/**
 * 숫자 야구 게임의 설정값을 전달하기 위한 DTO.
 *
 * @param answerSize 정답 숫자의 길이
 * @param lowerBound 각 자리의 최소값
 * @param upperBound 각 자리의 최대값
 */
public record Preference(
        int answerSize,
        int lowerBound,
        int upperBound
) {
}
