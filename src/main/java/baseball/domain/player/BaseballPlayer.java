package baseball.domain.player;

/**
 * 야구 게임에 참여하는 플레이어의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface BaseballPlayer extends Player {
        /**
         * @implSpec 제한된 길이의 숫자열을 반환합니다.
         *
         * @param limitLength 숫자열의 제한 길이
         * @return 숫자열을 반환
         */
        String provideLimitedNumber(int limitLength);
}
