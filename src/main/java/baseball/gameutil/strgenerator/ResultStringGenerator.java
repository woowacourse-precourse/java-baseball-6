package baseball.gameutil.strgenerator;

import baseball.gameutil.Score;

/**
 * 이 인터페이스를 구현하면 점수를 문자열로 변환할 수 있다.
 */
public interface ResultStringGenerator {
    String result(Score score);
}
