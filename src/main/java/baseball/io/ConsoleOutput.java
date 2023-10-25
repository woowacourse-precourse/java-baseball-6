package baseball.io;

/**
 * 콘솔로 출력을 하는 Output 인터페이스의 구현체
 */
public class ConsoleOutput implements Output {

    /**
     * 콘솔로 출력한다.
     * @param s 출력할 문자열
     */
    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
