package baseball;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class CodeRepositoryTest {

  private final static Logger logger = Logger.getLogger("CodeRepositoryTestLogger");

  CodeRepository codeRepository = new CodeRepository();

  @Test
  void 코드_저장하기() {
    // given
    List<Integer> 대상코드1 = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> 대상코드2 = new ArrayList<>(List.of(4, 5, 6));

    // when
    Long 코드ID1 = codeRepository.save(대상코드1);
    Long 코드ID2 = codeRepository.save(대상코드2);

    // then
    assertEquals(코드ID2, codeRepository.getSequence());
    logger.info("레포지토리의 현재 sequence: " + codeRepository.getSequence());
  }

  @Test
  void 코드_저장하고_조회하기() {
    // given
    List<Integer> 대상코드1 = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> 대상코드2 = new ArrayList<>(List.of(4, 5, 6));
    List<Integer> 대상코드3 = new ArrayList<>(List.of(7, 8, 9));

    // when
    Long 코드ID1 = codeRepository.save(대상코드1);
    Long 코드ID2 = codeRepository.save(대상코드2);
    Long 코드ID3 = codeRepository.save(대상코드3);

    Code 저장된_코드2 = codeRepository.findById(코드ID2);

    // then
    assertEquals(대상코드2, 저장된_코드2.getNumber());
  }
}
