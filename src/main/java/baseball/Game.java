package baseball;

import baseball.constant.NumberConst;
import baseball.util.MessageUtil;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Game implements Runnable {
    private int compareRestartNum = NumberConst.RESTART_NUMBER; // 재시작, 종료 여부를 입력받기 위한 변수
    private int countBall = 0; // Ball 개수 확인 용도
    private int countStrike = 0; // Strike 개수 확인 용도

    public Game() {
    }

    /**
     * Game 진행 Thread 생성, Exception 처리를 위하여 메소드로 추출
     */
    public void start() {
        // TODO: Game 진행
        Thread game = new Thread("Game");

        try {
            game.start();
            run();
        } catch (NoSuchElementException exception) {
            System.out.println("error code: 000");
            stop();
        } finally {
            stop();
        }

    }

    /**
     * 숫자 야구 게임 랜덤 숫자를 생성하며 유저에게 입력받은 값과 랜덤 생성한 값을 비교하여 볼, 스트라이크, 낫싱 확인 이후 출력 게임 종료 이후 재시작 종료 여부 확인
     */
    @Override
    public void run() {
        // TODO: Game 진행

        // 컴퓨터 랜덤 숫자 생성
        List<Integer> computer = createRandomNumber();

        // 입력받은 숫자 리스트로 변환하기 위한 임시 변수
        String InputString;

        // user 에게 입력받은 숫자
        List<Integer> user;

        // 게임 시작 메시지 출력
        MessageUtil.initGame();

        while (true) {
            // 유저에게 숫자 입력 요청
            MessageUtil.inputNumber();
            InputString = Console.readLine();

            // 입력 값 유효성 검사 및 리스트로 변환
            user = Validator.validateInputValueAndReturnList(InputString);

            // 볼과 스트라이크 개수 확인하여 업데이트
            updateBallAndStrikeCounts(user, computer);

            // 결과 출력
            MessageUtil.printResultGame(countBall, countStrike);

            // 게임 성공 시 처리(countStrike 가 maxCountStrike 와 같은 경우)
            if (countStrike == NumberConst.MAX_COUNT_STRIKE) {
                // 성공 메시지 출력
                MessageUtil.printSuccessGame();

                // 게임 재시작 혹은 종료 여부 입력
                InputString = Console.readLine();

                // 입력 받은 값이 숫자인지 확인
                Validator.validateInputIsNumeric(InputString);

                // 입력 받은 값 숫자로 변환
                compareRestartNum = Integer.parseInt(InputString);

                // 입력받은 값이 1 혹은 2만 입력했는지 확인
                Validator.validationRestartAndStopValue(compareRestartNum);
            }

            // 게임 성공이면서 게임 재시작인 경우 새로운 랜덤 숫자 생성
            if (countStrike == NumberConst.MAX_COUNT_STRIKE && compareRestartNum == NumberConst.RESTART_NUMBER) {
                computer = createRandomNumber();
            }

            // 게임 성공 이후 중지 번호 입력 받을 경우 게임 종료
            if (countStrike == NumberConst.MAX_COUNT_STRIKE && compareRestartNum == NumberConst.STOP_NUMBER) {
                break;
            }

            // 볼과 스트라이크 개수 초기화
            countBall = 0;
            countStrike = 0;
        }

        // Scanner 입력 Stream 중지
        Console.close();
    }

    /**
     * Thread 중지 목적
     */
    private static void stop() {
        Thread.interrupted();
    }

    /**
     * 컴퓨터가 생성하는 랜덤 숫자 (3자리 수이며 각 숫자 간 중복은 없음)
     *
     * @return : List, 길이 = NumberConst.EXPECTED_INPUT_LENGTH, 랜덤 숫자
     */
    private List<Integer> createRandomNumber() {
        // TODO: 랜덤 숫자 생성 (inputLength 자리 수)
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NumberConst.EXPECTED_INPUT_LENGTH) {
            // minInputValue 부터 maxInputValue 랜덤 값 생성
            int randomNumber = Randoms.pickNumberInRange(
                    NumberConst.MIN_INPUT_VALUE,
                    NumberConst.MAX_INPUT_VALUE
            );

            // 중복 값이 있는지 확인
            if (!randomNumbers.contains(randomNumber)) {
                // 중복 값이 없을 경우 List Element 추가
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    /**
     * 컴퓨터가 생성한 숫자와 유저에게 입력 받은 숫자를 확인하여 Strike, Ball 개수 증가
     *
     * @param: 1. computer : 컴퓨터가 랜덤으로 생성한 숫자 2. user : 유저에게 입력받은 숫자
     */
    private void updateBallAndStrikeCounts(List<Integer> user, List<Integer> computer) {
        // TODO: 입력받은 값과 생성한 랜덤 숫자 비교하여 Ball, Strike 개수 증가
        for (int i = 0; i < NumberConst.EXPECTED_INPUT_LENGTH; i++) {
            int userNumber = user.get(i);
            int computerNumber = computer.get(i);

            // 동일 위치 동일 숫자 경우 스트라이크 증가
            if (userNumber == computerNumber) {
                countStrike++;
                continue;
            }
            // 현재 위치는 아니나 다른 위치 값 존재 시 볼 증가
            if (computer.contains(userNumber)) {
                countBall++;
            }
        }
    }
}
