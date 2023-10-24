package baseball;

/**
 * 숫자 야구 게임의 결과값 경우의 수를 나타내기 위한 DTO.
 *
 * @param strike 스트라이크 개수
 * @param ball   볼 개수
 */
public record Result(
        int strike,
        int ball
) {
}
