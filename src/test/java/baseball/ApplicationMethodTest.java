package baseball;

import baseball.validator.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationMethodTest {

  private Application application = new Application();

  @DisplayName("함수 실행 이후 List 에는 3개의 수가 들어있어야 한다.")
  @Test
  void gameInit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    //given
    List<Integer> computer = new ArrayList<>();

    Method method = Application.class.getDeclaredMethod("gameInit", List.class);
    method.setAccessible(true);

    //when
    method.invoke(application, computer);

    //then
    assertThat(computer).hasSize(3).allMatch(c -> c >= 1 && c <= 9);
    assertThat(computer.stream().distinct().toList()).hasSize(3);
  }


  @DisplayName("strike 와 ball 수를 계산한다.")
  @Test
  void validateBaseball()
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    //given
    List<Integer> computer = new ArrayList<>();
    List<Integer> user = new ArrayList<>();
    computer.add(1);
    computer.add(2);
    computer.add(3);

    user.add(2);
    user.add(1);
    user.add(3);
    Baseball baseball = new Baseball();

    //when
    Method method = Application.class.getDeclaredMethod("validateBaseball", List.class, List.class,
        Baseball.class);
    method.setAccessible(true);

    method.invoke(application, computer, user, baseball);

    //then
    assertThat(baseball.getStrike()).isEqualTo(1);
    assertThat(baseball.getBall()).isEqualTo(2);

  }
}