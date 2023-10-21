package baseball;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

  CodeRepository codeRepository = new CodeRepository();
  GameService gameService = new GameService();

  @Test
  @DisplayName("생성된 3자리의 수가 서로 다른 수로 이루어졌는지 확인한다.")
  void 랜덤_컴퓨터숫자_생성하기() {
    // given && when
    Long 코드ID1 = gameService.createComputerCode();
    Long 코드ID2 = gameService.createComputerCode();

    // then
    Code 코드1 = codeRepository.findById(코드ID1);
    Code 코드2 = codeRepository.findById(코드ID2);

    List<Integer> 랜덤숫자1 = 코드1.getNumber();
    List<Integer> 랜덤숫자2 = 코드2.getNumber();
    Set<Integer> 랜덤숫자1_집합 = new HashSet<>(랜덤숫자1);
    Set<Integer> 랜덤숫자2_집합 = new HashSet<>(랜덤숫자2);

    assertEquals(랜덤숫자1.size(), 랜덤숫자1_집합.size());
    assertEquals(랜덤숫자2.size(), 랜덤숫자2_집합.size());
  }

  @Test
  @DisplayName("숫자를 올바르게 추론한다.")
  void 숫자_추론하기() {
    // given
    Long 컴퓨터코드ID = codeRepository.save(List.of(5, 4, 9));

    // when
    Map<Grade, Integer> 결과1 = gameService.guessCode(List.of(4, 3, 5), 컴퓨터코드ID);
    Map<Grade, Integer> 결과2 = gameService.guessCode(List.of(1, 5, 9), 컴퓨터코드ID);
    Map<Grade, Integer> 결과3 = gameService.guessCode(List.of(1, 4, 9), 컴퓨터코드ID);
    Map<Grade, Integer> 결과4 = gameService.guessCode(List.of(5, 4, 9), 컴퓨터코드ID);

    // then
    assertEquals(2, 결과1.get(Grade.BALL));
    assertEquals(0, 결과1.get(Grade.STRIKE));
    assertEquals(1, 결과2.get(Grade.BALL));
    assertEquals(1, 결과2.get(Grade.STRIKE));
    assertEquals(0, 결과3.get(Grade.BALL));
    assertEquals(2, 결과3.get(Grade.STRIKE));
    assertEquals(0, 결과4.get(Grade.BALL));
    assertEquals(3, 결과4.get(Grade.STRIKE));
  }
}