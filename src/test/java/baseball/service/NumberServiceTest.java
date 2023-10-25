package baseball.service;

import baseball.model.Game;
import baseball.model.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {
    NumberService ns ;

    @BeforeEach
    void setUp(){
        ns = new NumberService();
    }

    @Test
    @DisplayName("랜덤숫자 생성 테스트")
    void generate() {
        Number testList = ns.generate();

        assertThat(testList).isNotNull();
        assertThat(testList.getList()).hasSize(Game.SIZE);
        assertThat(testList.getList()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("사용자의 입력 테스트")
    void validateInput() {
        assertThat(ns.validateInput("123")).isTrue();
        assertThat(ns.validateInput("323")).isFalse();
        assertThat(ns.validateInput("1234")).isFalse();
        assertThat(ns.validateInput("a11")).isFalse();
        assertThat(ns.validateInput("abc")).isFalse();
        assertThat(ns.validateInput("000")).isFalse();
    }

}