package baseball.application.numbers;

import baseball.domain.UserNumberRepository;
import camp.nextstep.edu.missionutils.Console;

public class GetUserNumbersApplication {
    private static final UserNumberRepository userNumberRepository = UserNumberRepository.getInstance();

    public GetUserNumbersApplication() {
        getNumbers();
    }

    public void getNumbers() {
        userNumberRepository.clear();
        String snum = Console.readLine();
        if (snum.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {

            if (snum.charAt(i) < '1' || snum.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            userNumberRepository.addValue(snum.charAt(i) - '0');
        }
    }
}
