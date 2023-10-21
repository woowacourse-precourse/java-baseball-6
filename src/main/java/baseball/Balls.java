package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Integer> balls;

    public Balls() {
        createRandomNumbers();
    }

    public Balls(String ballsStr) {
        isValidation(ballsStr);

        balls = new ArrayList<>();
        for (int i = 0; i < ballsStr.length(); i++) {
            balls.add(ballsStr.charAt(i) - '0');
        }
    }

    private void isValidation(String ballsStr) {
        //사용자 숫자 유효성 검사
        boolean isNumbers = ballsStr.matches("[1-9]+");
        if (!isNumbers) {
            throw new IllegalArgumentException("1~9 숫자가 아닙니다.");
        }
        if (ballsStr.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }

        for (int i = 0; i < ballsStr.length() - 1; i++) {
            char searchChar = ballsStr.charAt(i);
            int searchIndex = ballsStr.indexOf(searchChar, i + 1);
            if (searchIndex > -1) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
    }

    private void createRandomNumbers() {
        balls = new ArrayList<>();

        while (balls.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(number)) {
                balls.add(number);
            }
        }
    }


}
