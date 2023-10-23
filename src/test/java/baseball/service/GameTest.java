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
        return captor.toString().replace("\r\n", ",").trim();
    }

    //2. 게임 실행
    @Test
    void runGame() {
        //입력 받음
        //게임 실행
    }


    @Test
    void compareNumbers() {
        //given
        //컴퓨터 랜덤 수 초기화
        String computer_number = "123";
//        int strikeCnt = 0, ballCnt = 0;

        //when & then
        //3볼
        game.compareNumbers(computer_number, "312", 0, 0);
        //2볼
        game.compareNumbers(computer_number, "352", 0, 0);
        //1볼
        game.compareNumbers(computer_number, "347", 0, 0);
        //1볼 1스트라이크
        game.compareNumbers(computer_number, "142", 0, 0);
        //1스트라이크
        game.compareNumbers(computer_number, "147", 0, 0);
        //2스트라이크
        game.compareNumbers(computer_number, "127", 0, 0);
        //3스트라이크
        game.compareNumbers(computer_number, "123", 0, 0);
        //낫싱
        game.compareNumbers(computer_number, "456", 0, 0);

        String output = "";
        output = output();
        assertEquals(output, "3볼,2볼,1볼,1볼 1스트라이크,1스트라이크,2스트라이크,3스트라이크,낫싱,");
    }

    //3. 게임 초기화
    @Test
    void resetGame() {

    }

}