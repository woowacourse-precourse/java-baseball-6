package baseball.domain.player;

import baseball.domain.game.RetryAnswer;

/**
 * 게임에 참여하는 플레이어의 핵심 로직을 정의한 인터페이스입니다.에
 */
public interface Player {
        /**
         * @implSpec 플레이어의 게임 재참여 의사를 반환합니다.
         *
         * @return 재참여하는 경우 YES, 참여하지 않는 경우 NO
         */
        RetryAnswer responseRetryPlay();
}
