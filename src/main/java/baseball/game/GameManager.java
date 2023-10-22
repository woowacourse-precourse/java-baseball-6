package baseball.game;

import static baseball.constant.ExceptionMessage.DUPLICATE;
import static baseball.constant.ExceptionMessage.LENGTH;
import static baseball.constant.ExceptionMessage.NUMBER;
import static baseball.constant.GameConstant.MAX_BALL_NUM;
import static baseball.constant.GameConstant.MIN_BALL_NUM;
import static baseball.constant.GameConstant.TOTAL_BALL_CNT;
import static baseball.constant.Message.INIT;
import static baseball.constant.Message.INPUT;
import static baseball.constant.Message.RETRY;
import static baseball.constant.Message.WIN;

import baseball.constant.Command;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

/**
 * {@summary 게임의 전체 로직을 관리한다.}
 * <p>
 * 게임의 전체적인 로직을 관리하는 클래스. 게임 관리는 이 클래스 내에서 전부 이루어져야 하고, 단 하나의 게임만이 관리될 수 있도록 싱글톤 패턴을 적용함.
 */
public class GameManager {
    /**
     * 게임 내에서 사용할 공 정보
     */
    private int[] balls;
    /**
     * 공 중복 확인을 위한 Set 자료구조
     */
    private final Set<Character> validation;
    /**
     * 싱글톤 관리를 위한 instance 선언
     */
    private static final GameManager instance = new GameManager();

    /**
     * 기본 생성자를 private로 선언하여 외부로부터 생성 방지
     */
    private GameManager() {
        validation = new HashSet<>();
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
            generateBalls();

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
            result = calculate(Console.readLine());
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

    /**
     * 사용자가 추측한 공 정보를 토대로 알맞은 결과를 {@link Result}의 형태로 리턴하는 메서드.
     *
     * @param guess 사용자가 추측한 공 정보
     * @return 추측한 공 정보와 현재 선택된 공 정보를 토대로 계산된 결과
     * @throws IllegalArgumentException 사용자의 입력이 올바르지 않은 경우(숫자가 아닌 입력, 자릿수가 다른 입력, 중복 입력 등) 발생
     * @see #validateBall(String)
     */
    private Result calculate(String guess) {
        validateBall(guess);

        int strike = 0;
        int ball = 0;

        for (int idx = 0; idx < TOTAL_BALL_CNT.getValue(); idx++) {
            int current = balls[idx];
            int guessIdx = guess.indexOf(current + '0');
            if (guessIdx == idx) {
                strike += 1;
            } else if (guessIdx > 0) {
                ball += 1;
            }
        }

        return new Result(strike, ball);
    }

    /**
     * 사용자의 공 정보 입력이 올바른 형태인지 체크하는 메서드.
     *
     * @param input 사용자의 입력
     * @throws IllegalArgumentException 사용자의 입력이 올바르지 않은 경우(숫자가 아닌 입력, 자릿수가 다른 입력, 중복 입력 등) 발생
     * @see baseball.constant.ExceptionMessage
     * @see #isNotBall(char)
     */
    private void validateBall(String input) {
        if (input.length() != TOTAL_BALL_CNT.getValue()) {
            throw new IllegalArgumentException(LENGTH.build(input.length()));
        }

        validation.clear();

        for (char ch : input.toCharArray()) {
            if (validation.contains(ch)) {
                throw new IllegalArgumentException(DUPLICATE.build(input));
            }
            if (isNotBall(ch)) {
                throw new IllegalArgumentException(NUMBER.build(input));
            }
            validation.add(ch);
        }
    }

    /**
     * 주어진 글자가 공과 관련된 문자인지 확인하는 메서드.
     *
     * @param ch 주어진 글자
     * @return 공이 아니라면 false, 공이라면 true
     * @see #validateBall(String)
     */
    private boolean isNotBall(char ch) {
        int num = ch - '0';

        return num < MIN_BALL_NUM.getValue() || num > MAX_BALL_NUM.getValue();
    }

    /**
     * 서로 다른 무작위의 세 공을 생성하는 메서드. 생성된 공은 {@link #balls}에 저장된다.
     *
     * @see Randoms#pickNumberInRange(int, int)
     * @see #isUniqueBall(int, int)
     */
    private void generateBalls() {
        balls = new int[TOTAL_BALL_CNT.getValue()];
        int ballIdx = 0;

        while (ballIdx < TOTAL_BALL_CNT.getValue()) {
            int num = Randoms.pickNumberInRange(MIN_BALL_NUM.getValue(), MAX_BALL_NUM.getValue());
            if (isUniqueBall(num, ballIdx)) {
                balls[ballIdx++] = num;
            }
        }
    }

    /**
     * 주어진 숫자가 이미 선택된 공들과 중복되지 않는 유일한 숫자인지 확인하는 메서드.
     *
     * @param num     주어진 숫자
     * @param lastIdx 현재까지 선택된 공의 인덱스
     * @return 유일한 공 번호라면 true, 유일하지 않다면 false
     * @see #generateBalls()
     */
    private boolean isUniqueBall(int num, int lastIdx) {
        for (int idx = 0; idx < lastIdx; idx++) {
            if (balls[idx] == num) {
                return false;
            }
        }
        return true;
    }
}
