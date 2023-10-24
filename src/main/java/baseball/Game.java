package baseball;

import baseball.constant.NumberConst;
import baseball.util.MessageUtil;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {
    private static final int restartNumber = NumberConst.RESTART_NUMBER; // 게임 재 시작 상수
    private static final int stopNumber = NumberConst.STOP_NUMBER; // 게임 중지 상수
    private static final int minInputValue = NumberConst.MIN_INPUT_VALUE; // 입력할 수 있는 숫자의 최솟 값
    private static final int maxInputValue = NumberConst.MAX_INPUT_VALUE; // 입력할 수 있는 숫자의 최대 값
    private static final int inputLength = NumberConst.EXPECTED_INPUT_LENGTH; // 입력할 수 있는 숫자의 최대 길이(3)
    private static final int maxCountStrike = NumberConst.MAX_COUNT_STRIKE; // 성공의 기준이 되는 스트라이크 개수

    private int compareRestartNum = restartNumber; // 재시작, 종료 여부를 입력받기 위한 변수
    private int countBall; // Ball 개수 확인 용도
    private int countStrike; // Strike 개수 확인 용도

    public void start() throws InterruptedException {
        // TODO: Game 진행
        Thread game = new Thread("Game");
        game.start();
        run();
        stop();
    }

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

        // 게임 종료 조건: compareRestartNum 이 stopNumber 인 경우
        while (compareRestartNum != stopNumber) {
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
            if (countStrike == maxCountStrike) {
                MessageUtil.printSuccessGame();
                InputString = Console.readLine();
                compareRestartNum = Integer.parseInt(InputString);
                Validator.validationRestartAndStopValue(compareRestartNum);
            }

            // 게임 성공이면서 게임 재시작인 경우 새로운 랜덤 숫자 생성
            if (countStrike == maxCountStrike && compareRestartNum == restartNumber) {
                computer = createRandomNumber();
            }

            // 볼과 스트라이크 개수 초기화
            countBall = 0;
            countStrike = 0;
        }
        Console.close();
    }

    public Game() {
    }

    /*
     * Thread 중지 목적
     */
    public void stop() {
        Thread.interrupted();
    }

    /* *
     * 컴퓨터가 생성하는 랜덤 숫자 (3자리 수이며 각 숫자 간 중복은 없음)
     */
    private List<Integer> createRandomNumber() {
        // TODO: 랜덤 숫자 생성 (inputLength 자리 수)
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < inputLength) {
            // minInputValue 부터 maxInputValue 랜덤 값 생성
            int randomNumber = Randoms.pickNumberInRange(
                    minInputValue,
                    maxInputValue
            );

            // 중복 값이 있는지 확인
            if (!randomNumbers.contains(randomNumber)) {
                // 중복 값이 없을 경우 List Element 추가
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    /*
     * 컴퓨터가 생성한 숫자와 유저에게 입력 받은 숫자를 확인하여 Strike, Ball 개수 증가
     * 매개 변수:
     *  1. computer : 컴퓨터가 랜덤으로 생성한 숫자
     *  2. user : 유제에게 입력받은 숫자
     */
    private void updateBallAndStrikeCounts(List<Integer> user, List<Integer> computer) {
        // TODO: 입력받은 값과 생성한 랜덤 숫자 비교하여 Ball, Strike 개수 증가
        for (int i = 0; i < inputLength; i++) {
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
