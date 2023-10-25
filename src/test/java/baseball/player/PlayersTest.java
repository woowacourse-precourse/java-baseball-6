//package baseball.player;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import baseball.number.Number;
//import baseball.result.Result;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.lang.reflect.Field;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class PlayersTest {
//    static ByteArrayOutputStream outContent;
//    static Field userNumber;
//    static Field computerNumber;
//    static Field userField;
//    static Field computerField;
//
//    @BeforeEach
//    void beforeEach() throws NoSuchFieldException {
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        userNumber = User.class.getDeclaredField("number");
//        userNumber.setAccessible(true);
//
//        userField = Players.class.getDeclaredField("user");
//        userField.setAccessible(true);
//
//        computerNumber = Computer.class.getDeclaredField("number");
//        computerNumber.setAccessible(true);
//
//        computerField = Players.class.getDeclaredField("computer");
//        computerField.setAccessible(true);
//    }
//
//    @Test
//    @DisplayName("user와 player의 number를 비교한다.")
//    public void user와_player의_number가_잘_비교되는지_확인한다() throws IllegalAccessException {
//        // given
//        User user = new User();
//        Number userTestNumber = new Number(123);
//        userNumber.set(user, userTestNumber);
//
//        Computer computer = new Computer();
//        Number computerTestNumber = new Number(312);
//        computerNumber.set(computer, computerTestNumber);
//
//        Players players = new Players();
//
//        userField.set(players, user);
//        computerField.set(players, computer);
//
//        // when
//        Result result = players.compareNumbers();
//
//        // then
//        result.printResult();
//        String expectedOutput = "2볼 1스트라이크" + "\n";
//        assertThat(outContent.toString()).contains(expectedOutput);
//    }
//
//    @Test
//    @DisplayName("user와 player의 number를 비교했을 때 낫싱인지 확인한다.")
//    public void user와_player의_number를_비교했을_때_낫싱인지_확인한다() throws IllegalAccessException {
//        // given
//        User user = new User();
//        Number userTestNumber = new Number(123);
//        userNumber.set(user, userTestNumber);
//
//        Computer computer = new Computer();
//        Number computerTestNumber = new Number(456);
//        computerNumber.set(computer, computerTestNumber);
//
//        Players players = new Players();
//
//        userField.set(players, user);
//        computerField.set(players, computer);
//
//        // when
//        Result result = players.compareNumbers();
//
//        // then
//        boolean isNothing = result.checkNothing();
//        assertThat(isNothing).isTrue();
//    }
//}
