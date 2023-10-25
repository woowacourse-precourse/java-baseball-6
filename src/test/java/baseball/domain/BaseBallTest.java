package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseBallTest {

    @Test
    void getInstance() {
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(100));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(1111));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(121));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(1));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(12));
    }
}