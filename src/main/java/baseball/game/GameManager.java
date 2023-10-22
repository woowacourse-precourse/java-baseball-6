package baseball.game;

import static baseball.constant.Message.INIT;
import static baseball.constant.Message.INPUT;
import static baseball.constant.Message.RETRY;
import static baseball.constant.Message.WIN;

import baseball.constant.Command;
import camp.nextstep.edu.missionutils.Console;

/**
 * {@summary 게임의 전체 로직을 관리한다.}
 * <p>
 * 게임의 전체적인 로직을 관리하는 클래스. 게임 관리는 이 클래스 내에서 전부 이루어져야 하고, 단 하나의 게임만이 관리될 수 있도록 싱글톤 패턴을 적용함.
 */
public class GameManager {
    /**
     * 게임 내에서 사용할 공 정보
     */
    private Ball ball;
    /**
     * 싱글톤 관리를 위한 instance 선언
     */
    private static final GameManager instance = new GameManager();

    /**
     * 기본 생성자를 private로 선언하여 외부로부터 생성 방지
     */
    private GameManager() {
    }

    /**
     * 싱글톤 인스턴스를 불러오기 위한 메서드.
     *
     * @return 현재 사용하고 있는 인스턴스
     */
    public static GameManager getInstance() {
        return instance;
    }

    /**
     * 게임의 전체 실행 흐름을 관리하는 메서드.
     * <p>
     * 게임이 시작되고 종료되기까지 모든 과정이 이 메서드 안에서 이루어진다.
     */
    public void run() {
        Command cmd; // 재시작 구분을 위한 커맨드
        System.out.println(INIT.getValue());

        do {
            ball = new Ball();

            guess();

            System.out.println(WIN.getValue());
            System.out.println(RETRY.getValue());

            cmd = getCommand();
        } while (cmd.equals(Command.RESTART));
    }

    /**
     * 게임을 이길 때(3스트라이크)까지 사용자로부터 공을 추측하는 메서드.
     */
    private void guess() {
        Result result;

        do {
            System.out.print(INPUT.getValue());
            result = ball.calculate(Console.readLine());
            System.out.println(result);
        } while (!result.isWin());
    }

    /**
     * 사용자로부터 입력받은 커맨드를 {@link Command}의 형태로 리턴하는 메서드.
     *
     * @return 사용자가 입력한 커맨드에 알맞는 Command 상수
     * @throws IllegalArgumentException 사용자가 입력한 커맨드가 {@link Command}의 상수 중 하나가 아닐 경우 발생
     * @see Command#of(String)
     */
    private Command getCommand() {
        String command = Console.readLine();

        return Command.of(command);
    }
}
