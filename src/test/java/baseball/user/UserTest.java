package baseball.user;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class UserTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setupStream() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    // TODO GameDispatch.dispatch의 출력값, GameResponse.result = SUCCESS 이면 msg를 출력한다.

    // TODO GameDispatch.dispatch의 출력값, GameResponse.result = FAIL 이면 에러를 쓰로우한다.

    // TODO GameDispatch.dispatch의 출력값, GameResponse.nextCmd = END 면 프로그램을 종료한다.

    // TODO GameDispatch.dispatch의 출력값, GameResponse.nextCmd = "command" 면 User.doGame(command, nargs)를 호출한다.

}
