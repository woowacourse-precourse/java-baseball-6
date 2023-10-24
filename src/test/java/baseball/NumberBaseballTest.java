package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NumberBaseballTest extends NsTest {
    private final String 재시작명령 = "1";
    private final String 종료명령 = "2";
    private final String[] 예외명령들 = {"3", "ㄱ", "&", "a", "!"};

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();

        while (isContinue(readLine())) {
            startGame();
        }
    }

    private void startGame() {
        // 실행 메서드
    }

    private boolean isContinue(String command) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        checkRight(command);

        if (command.equals("1")) {
            return true;
        }

        return endGame();
    }

    private void checkRight(String command) {
        if (!command.equals("1") && !command.equals("2")) {
            throw new IllegalArgumentException("잘못된 명령어입니다.");
        }
    }

    private static boolean endGame() {
        System.out.println("게임 종료");
        return false;
    }

    @Test
    void 재시작후_종료() {
        assertSimpleTest(() -> {
            run(재시작명령, 종료명령);
        });
    }

    @Test
    void 게임_재시작_정상() {
        boolean normalCommand = isContinue(재시작명령);

        assertThat(normalCommand).isTrue();
    }

    @Test
    void 게임_종료_정상() {
        boolean exitCommand = isContinue(종료명령);

        assertThat(exitCommand).isFalse();
    }

    @Test
    void 게임_재시작_예외() {
        for (String 예외명령 : 예외명령들) {
            assertThrows(IllegalArgumentException.class, () -> isContinue(예외명령));
        }
    }

    @Override
    protected void runMain() {
        play();
    }
}
