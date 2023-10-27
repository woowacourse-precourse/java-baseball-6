package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {
//    RandomNumbers randomNumbers;
//    GameLogic result;
//
//    @BeforeEach
//    void createNewRandomNumbers() {
//        randomNumbers = new RandomNumbers();
//        List<Integer> playerNumbers = List.of(5, 9, 7);
//        result = new GameLogic(randomNumbers, playerNumbers);
//        System.out.println("randomNumbers = " + randomNumbers.toString());
//    }
//
//    @Nested
//    class randomNumbers {
//        @DisplayName("컴퓨터 랜덤 숫자 생성 테스트")
//        @Test
//        void getComputerRandomNumbers() {
//            assertThat(randomNumbers.size()).isEqualTo(3);
//        }
//    }

    @Nested
    class hintTest {
//        @BeforeEach
//        void getGameResult() {
//            List<Integer> playerNumbers = List.of(5, 9, 7);
//            result = new GameLogic(computerNumbers, playerNumbers);
//            System.out.println(computerNumbers.toString());
//        }

//        @DisplayName("스트라이크 개수 테스트")
//        @Test
//        void getStrikeCount() {
//            final List<Integer> playerNumbers = List.of(5, 9, 7);
//
//            try {
//                Method method = result.getClass().getDeclaredMethod("getStrikeCount",RandomNumbers.class, List.class);
//                method.setAccessible(true);
//                String ret = (String) method.invoke(result, 1,2);
//                assertThat(30, is(ret));
//            } catch (NoSuchMethodException e) {
//                throw new RuntimeException(e);
//            });
//        }
//
//        @DisplayName("볼 개수 테스트")
//        @Test
//        void getBallCount() {
//            final List<Integer> computerNumbers = List.of(5, 8, 9);
//            final List<Integer> playerNumbers = List.of(5, 9, 7);
//
//            assertThat(Application.getBallCount(computerNumbers, playerNumbers)).isEqualTo(1);
//        }
//
//        @DisplayName("결과 로직 메소드")
//        @Test
//        void baseBallGame() {
//            final List<Integer> computerNumbers = List.of(5, 8, 9);
//            final List<Integer> playerNumbers = List.of(5, 9, 7);
//            System.out.println(Application.baseBallGame(computerNumbers, playerNumbers));
//            assertThat(result).isEqualTo("2볼");
//        }
    }
}