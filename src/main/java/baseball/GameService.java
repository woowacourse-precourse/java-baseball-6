package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class GameService {

  private final CodeRepository codeRepository = new CodeRepository();

  public Long createComputerCode() {
    List<Integer> randomCode = new ArrayList<>();
    while (randomCode.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!randomCode.contains(randomNumber)) {
        randomCode.add(randomNumber);
      }
    }
    return codeRepository.save(randomCode);
  }

  public Map<Grade, Integer> guessCode(List<Integer> inputCode, Long computerCodeId) {
    List<Integer> computerCode = codeRepository.findById(computerCodeId).getNumber();
    Map<Grade, Integer> response = new HashMap<>(){{
      put(Grade.STRIKE, 0);
      put(Grade.BALL, 0);
    }};

    for(int i = 0; i < 3; i++) {
      if(computerCode.get(i) == inputCode.get(i))
        response.compute(Grade.STRIKE, (key, value) -> value + 1);
      else if(computerCode.contains(inputCode.get(i)))
        response.compute(Grade.BALL, (key, value) -> value + 1);
    }

    return response;
  }

  public boolean determineStatus(Map<Grade, Integer> result) {
    // 게임 종료
    if(result.get(Grade.STRIKE) == 3)
      return true;
    // 게임 지속
    return false;
  }

  public boolean determineRestarting(Integer command) {
    // 게임 재시작
    if(command == 1)
      return true;
    // 게임 종료
    return false;
  }

  public void removeComputerCode(Long computerCodeId) {
    codeRepository.delete(computerCodeId);
  }
}
