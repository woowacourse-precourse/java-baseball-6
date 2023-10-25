package baseball.io;


import camp.nextstep.edu.missionutils.Console;

/**
 * 콘솔로 부터 입력을 받는 Input 인터페이스의 구현체
 */
public class ConsoleInput implements Input{

    /**
     * 콘솔로 부터 입력을 받는다.
     * @return 입력값
     */
    @Override
    public String getInput() {
        return Console.readLine().trim();
    }
}
