package baseball.config;

import baseball.domain.game.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameConfigFactoryTest {

    @Test
    void 단_하나의_인스턴스_생성_테스트() {
        // given
        Game baseBallGame1 = BaseBallGameConfigFactory.createBaseBallGame();
        Game baseBallGame2 = BaseBallGameConfigFactory.createBaseBallGame();

        // when & then
        assertThat(baseBallGame1).isSameAs(baseBallGame2);
    }

}