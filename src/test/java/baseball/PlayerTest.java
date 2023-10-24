package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  Player player = new Player();

  /**
   * 사용자가 게임 진행을 위한 입력 테스트
   */
  @Test
  public void 사용자_입력_성공() throws Exception {
    //given
    //when
    Assertions.assertThatNoException()
        .isThrownBy(() -> player.getInput("123"));

    //then
  }

  @Test
  public void 사용자가_3개_이하의_숫자_입력() throws Exception {
    //given
    //when
    Assertions.assertThatThrownBy(
            () ->
                player.getInput("12"))
        .isInstanceOf(IllegalArgumentException.class);
    //then
  }

  @Test
  public void 사용자가_3개_이상의_숫자_입력() throws Exception {
    //given
    //when
    Assertions.assertThatThrownBy(
            () ->
                player.getInput("1234"))
        .isInstanceOf(IllegalArgumentException.class);
    //then
  }

  @Test
  public void 사용자가_문자_입력 () throws Exception {
    //given
    //when
    Assertions.assertThatThrownBy(
            () ->
                player.getInput("a"))
        .isInstanceOf(IllegalArgumentException.class);

    //then
  }

  @Test
  public void 사용자가_중복된_숫자_입력() throws Exception {
    //given
    //when
    Assertions.assertThatThrownBy(
            () ->
                player.getInput("111"))
        .isInstanceOf(IllegalArgumentException.class);
    //then
  }

  /**
   * 사용자가 재시작 입력 테스트
   */
  @Test
  public void 사용자가_재시작에_문자_입력() throws Exception {
    //given
    //when
    Assertions.assertThatIllegalArgumentException()
        .isThrownBy(() -> player.getRestart("a"));

    //then
  }

  @Test
  public void 사용자가_재시작에_다른_숫자_입력() throws Exception {
    //given
    //when
    Assertions.assertThatIllegalArgumentException()
        .isThrownBy(() -> player.getRestart("0"));

    //then
  }

  @Test
  public void 사용자가_재시작에_재시작_숫자_입력() throws Exception {
    //given
    //when
    boolean restart = player.getRestart("1");

    //then
    Assertions.assertThat(restart)
        .isTrue();
  }

  @Test
  public void 사용자가_재시작에_종료_숫자_입력() throws Exception {
    //given
    //when
    boolean restart = player.getRestart("2");

    //then
    Assertions.assertThat(restart)
        .isFalse();
  }
}
