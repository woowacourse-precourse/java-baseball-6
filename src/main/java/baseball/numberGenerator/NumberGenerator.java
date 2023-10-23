package baseball.numberGenerator;

import baseball.constants.Constants;
import baseball.validation.ValidationPlayerNumber;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    ValidationPlayerNumber validationPlayerNumber = new ValidationPlayerNumber(); //
    List<Integer> playerNumber = new ArrayList<>();

    public List<Integer> getPlayerNumber() { // 플레이어가 3개의 번호를 입력받아 Integer List로 반환하게 해주는 메서드
        System.out.println(Constants.REQUIRE_NUMBER); // 숫자를 입력해주세요
        String playerNumberString = Console.readLine();

        if (validationPlayerNumber.validatePlayerNumber(playerNumberString)) {
            throw new IllegalArgumentException("잘못된 입력값이에요.");
        }

        playerNumber = validationPlayerNumber.changeListNumber(playerNumberString);

        return playerNumber;
    }

    public List<Integer> getCpuRandomNumber() { // cpu가 랜덤으로 3개의 번호를 생성해서 Integer List로 반환하게 해주는 메서드
        List<Integer> cpuNumber = new ArrayList<>();
        while (cpuNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!cpuNumber.contains(randomNumber)) {
                cpuNumber.add(randomNumber);
            }
        }
        return cpuNumber;
    }
}
