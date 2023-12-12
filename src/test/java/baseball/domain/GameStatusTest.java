//package baseball.domain;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import baseball.domain.entity.game.GameStatus;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//@DisplayName("GameStatus 클래스")
//class GameStatusTest {
//    @Test
//    void 유효하지_않은_수를_입력하면_예외_발생() {
//        assertThrows(IllegalArgumentException.class, () -> GameStatus.from(3));
//    }
//
//    @Test
//    void 유효한_수를_입력하면_올바른_값을_반환() {
//        assertEquals(GameStatus.CONTINUE, GameStatus.from(0));
//        assertEquals(GameStatus.RESTART, GameStatus.from(1));
//        assertEquals(GameStatus.END, GameStatus.from(2));
//    }
//}