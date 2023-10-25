package baseball.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BallTests {
    private Ball ball;

    @Test
    @DisplayName("Ball 정상적인 case로 생성")
    void ballCreateTest() {
        ball = new Ball(1, 0);
        assertThat(ball.getDigits()).isLessThan(3);
        assertThat(ball.getDigits()).isGreaterThan(-1);
        assertThat(ball.getNumber()).isLessThan(10);
        assertThat(ball.getNumber()).isGreaterThan(0);

    }
    @Test
    @DisplayName("Ball digit 에러 case 생성")
    void ballCreate_digitErrorTest(){
        Assertions.assertThrows(Exception.class, ()->{
            new Ball(1, 10);
        });
    }
    @Test
    @DisplayName("Ball number 에러 case 생성")
    void ballCreate_numberErrorTest(){
        Assertions.assertThrows(Exception.class, ()->{
            new Ball(10, 1);
        });
    }



}