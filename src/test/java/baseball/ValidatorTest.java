package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

  public Computer computer = null;
  public Validator validator = null;

  @BeforeEach
  void preSet() {
    computer = new Computer();
    //TODO: validator 생성할 때, computer의 난수를 받아야해서 불필요하게 생성하게 된다.
    validator = new Validator(computer.getRandomNumber());
  }

  @Test
  void 공백이_포함되어서는_안된다() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateContainsSpace("123 "));
    assertEquals(e.getMessage(), "공백을 제거하고 입력해주세요.");
  }

  @Test
  void 숫자_이외의_문자는_허용하지_않는다() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateOnlyNumber("ㄱ12"));
    assertEquals(e.getMessage(), "숫자만 입력해주세요.");
  }

  @Test
  void _3자리_숫자여야_한다_3개_미만() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateLengthThree("58"));
    assertEquals(e.getMessage(), "3개의 숫자로 입력해주세요.");
  }

  @Test
  void _3자리_숫자여야_한다_3개_초과() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateLengthThree("5894"));
    assertEquals(e.getMessage(), "3개의 숫자로 입력해주세요.");
  }


  @Test
  void 중복된_숫자는_허용하지_않는다1() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateDuplicate("224"));
    assertEquals(e.getMessage(), "서로 다른 3개의 숫자로 입력해주세요.");
  }

  @Test
  void 중복된_숫자는_허용하지_않는다2() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateDuplicate("777"));
    assertEquals(e.getMessage(), "서로 다른 3개의 숫자로 입력해주세요.");
  }

  @Test
  void _1과_9사이의_숫자만_허용한다1() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateZero("103"));
    assertEquals(e.getMessage(), "1과 9 사이의 숫자만 입력해주세요.");
  }

  @Test
  void _1과_9사이의_숫자만_허용한다2() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateZero("530"));
    assertEquals(e.getMessage(), "1과 9 사이의 숫자만 입력해주세요.");
  }

  @Test
  void _1_또는_2_입력만_허용한다() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> validator.validateOneOrTwo("3"));
    assertEquals(e.getMessage(), "1과 2 중 하나만 선택해주세요.");
  }

}