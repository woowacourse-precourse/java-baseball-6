package baseball.counter;

import java.util.stream.IntStream;

public class Ball {
    // 첫 번째 기능: 주어진 인덱스의 문자가 다른 위치에 존재하는지 확인
    private static boolean isCharacterAtDifferentPosition(String answer, char character, int index) {
        int position = answer.indexOf(character);
        return position != index && position != -1;
    }

    // 두 번째 기능: 볼 카운트 계산
    public static int countBalls(String answer, String input) {
        return (int) IntStream.range(0, 3)
                .filter(i -> isCharacterAtDifferentPosition(answer, input.charAt(i), i))
                .count();
    }
}
