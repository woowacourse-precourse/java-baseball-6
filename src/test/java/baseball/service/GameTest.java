package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.service.handler.Computer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    Computer computer;

    Game game = new Game();

    private OutputStream captor;
    private PrintStream standardOut;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString();
    }


    //2. 게임 실행
    @Test
    void runGame() {
        //given
        //컴퓨터 랜덤 수 초기화
        String computer_number = "123";
//        int strikeCnt = 0, ballCnt = 0;

        //when & then
        //3볼
        game.runGame(computer_number, "312");
        assertEquals(output(), "3볼");
        //2볼
        game.runGame(computer_number, "352");
        assertEquals(output(), "2볼");
        //1볼
        game.runGame(computer_number, "347");
        assertEquals(output(), "1볼");
        //1볼 1스트라이크
        game.runGame(computer_number, "142");
        assertEquals(output(), "1볼 1스트라이크");
        //1스트라이크
        game.runGame(computer_number, "147");
        assertEquals(output(), "1스트라이크");
        //2스트라이크
        game.runGame(computer_number, "127");
        assertEquals(output(), "2스트라이크");
        //3스트라이크
        game.runGame(computer_number, "123");
        assertEquals(output(), "3스트라이크");
        //낫싱
        game.runGame(computer_number, "456");
        assertEquals(output(), "낫싱");

    }

    //3. 게임 초기화
    @Test
    void resetGame() {

    }

}