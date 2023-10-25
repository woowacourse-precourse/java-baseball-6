package baseball.controller;

import baseball.model.Ball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountControllerTests {

    private CountController countController = new CountController();
    @Test
    @DisplayName("strike 테스트")
    void count_strike() throws Exception {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(1,0));
        user.add(new Ball(2,1));
        user.add(new Ball(3,2));

        List<Ball> com = new ArrayList<>();
        com.add(new Ball(1,0));
        com.add(new Ball(2,1));
        com.add(new Ball(3,2));

        countController.count_ball(com, user);
        assertThat(countController.getStrike()).isEqualTo(3);
        assertThat(countController.getBall()).isEqualTo(0);
    }
    @Test
    @DisplayName("nothing 테스트")
    void count_nothing() throws Exception {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(4,0));
        user.add(new Ball(5,1));
        user.add(new Ball(6,2));

        List<Ball> com = new ArrayList<>();
        com.add(new Ball(1,0));
        com.add(new Ball(2,1));
        com.add(new Ball(3,2));

        countController.count_ball(com, user);
        assertThat(countController.getStrike()).isEqualTo(0);
        assertThat(countController.getBall()).isEqualTo(0);
    }
    @Test
    @DisplayName("ball 테스트")
    void count_ball() throws Exception {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(3,0));
        user.add(new Ball(4,1));
        user.add(new Ball(1,2));

        List<Ball> com = new ArrayList<>();
        com.add(new Ball(1,0));
        com.add(new Ball(2,1));
        com.add(new Ball(3,2));

        countController.count_ball(com, user);
        assertThat(countController.getStrike()).isEqualTo(0);
        assertThat(countController.getBall()).isEqualTo(2);
    }

    //TODO : add @ParameterizedTest
    @Test
    @DisplayName("1strike 2ball 테스트")
    void count_ballAndStrike() {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(3,0));
        user.add(new Ball(2,1));
        user.add(new Ball(1,2));

        List<Ball> com = new ArrayList<>();
        com.add(new Ball(1,0));
        com.add(new Ball(2,1));
        com.add(new Ball(3,2));

        countController.count_ball(com, user);
        assertThat(countController.getStrike()).isEqualTo(1);
        assertThat(countController.getBall()).isEqualTo(2);
    }
    @Test
    @DisplayName("1strike 2ball 테스트2")
    void count_ballAndStrike2() {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(4,0));
        user.add(new Ball(5,1));
        user.add(new Ball(7,2));

        List<Ball> com = new ArrayList<>();
        com.add(new Ball(5,0));
        com.add(new Ball(4,1));
        com.add(new Ball(7,2));

        countController.count_ball(com, user);
        assertThat(countController.getStrike()).isEqualTo(1);
        assertThat(countController.getBall()).isEqualTo(2);
    }
    @Test
    @DisplayName("ballList 길이 Exception 테스트")
    void validate_test(){
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(3,0));
        user.add(new Ball(2,1));
        user.add(new Ball(1,2));

        List<Ball> com = new ArrayList<>();
        com.add(new Ball(1,0));
        com.add(new Ball(2,1));
        com.add(new Ball(3,2));
        com.add(new Ball(4,2));

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            countController.count_ball(com, user);
        });
    }
}