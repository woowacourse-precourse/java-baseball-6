//package baseball.domain;
//
//import baseball.strategy.ForbidDuplicationPolicy;
//import baseball.strategy.RandomNumberGeneratePolicy;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class ComputerTest {
//
//    @Test
//    @DisplayName("랜덤 숫자 생성 정책과 중복 불가능 정책에 따라 입력받은 숫자 자리수 만큼의 서로 다른 임의의 수를 생성한다.")
//    void successGenerateThreeAnyDifferentNumber() {
//        // given
//        final var randomNumberGenerateStrategy = new RandomNumberGeneratePolicy();
//        final var duplicateAllowancePolicy = new ForbidDuplicationPolicy();
//        final int numberCount = 3;
//
//        // when
//        var computer = new NumberBaseBallComputer();
//        var numbers = computer.generateNumbers(randomNumberGenerateStrategy, duplicateAllowancePolicy, numberCount);
//
//        // then
//        assertThat(numbers).hasSize(numberCount).doesNotHaveDuplicates();
//    }
//
//}
