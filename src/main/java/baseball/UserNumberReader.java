package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumberReader {

    private final UserNumberValidator userNumberValidator;

    public UserNumberReader(UserNumberValidator userNumberValidator) {
        this.userNumberValidator = userNumberValidator;
    }

    public List<Integer> read() {

        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();

        /*
        게임 플레이어의 숫자를 읽어오는 Reader 클래스와 숫자를 검증하는 Validator 클래스를 분리했습니다.
        - 이유 1: I/O 작업을 통해 데이터를 읽어오는 책임과 입력받은 숫자를 검증하는 책임은 다르다고 생각했습니다.
        - 이유 2: 검증 작업을 담당하는 Validator를 분리함으로써 Validator에 대한 독립적인 테스트 코드를 작성할 수 있습니다.
         */
        userNumberValidator.validateThreeDigitNumber(userNumber);
        userNumberValidator.validateDuplicatedNumber(userNumber);

        return Arrays.stream(userNumber.split(""))
                .map(Integer::valueOf).collect(Collectors.toList());
    }
}
