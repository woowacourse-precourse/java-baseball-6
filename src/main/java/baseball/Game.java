package baseball;

import static baseball.message.Message.BALL;
import static baseball.message.Message.CAPACITY_STR;
import static baseball.message.Message.COMPUTER;
import static baseball.message.Message.END_MSG;
import static baseball.message.Message.INPUT_MSG;
import static baseball.message.Message.PLAYER;
import static baseball.message.Message.REGAME_MSG;
import static baseball.message.Message.START_MSG;
import static baseball.message.Message.STRIKE;

import baseball.repository.ComputerRepository;
import baseball.repository.GameSetRespository;
import baseball.repository.PlayerRepository;
import baseball.utils.CheckUtils;
import baseball.view.InputView;
import baseball.view.PrintMessage;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // 컴퓨터 저장소
    private ComputerRepository computerRepository;

    // 플레이어 저장소
    private PlayerRepository playerRepository;

    public Game() {
        // 게임 설정 저장소
        new GameSetRespository();
        this.computerRepository = new ComputerRepository();
        this.playerRepository = new PlayerRepository();
        // 최초 게임 시작 메시지
        PrintMessage.println(START_MSG);
    }

    public void baseballStart() {
        // 게임 진행 true 의 경우 에만 진행
        while (GameSetRespository.isGameStatus()) {
            // 컴퓨터 초기화 ( 컴퓨터 정보 초기화 및 메모리 정보 초기화 ) - 게임 종료 후 재시작 시 start line
            computerInit();

            do {
                // 플레이어 초기화
                playerInit();

                // 플레이어 입력
                playerInput();

                // 플레이어 컴퓨터 매치 확인
                playerComputerMatchCheck();

                // 결과 확인
                resultCheck();

            } while (!playerRepository.isSuccess());

            // 게임 재 시작 여부 확인
            retry();
        }
    }

    /**
     * 게임 재시작
     */
    private void retry() {
        PrintMessage.println(END_MSG);
        PrintMessage.print(REGAME_MSG);
        String retry = InputView.getInput();
        if (!retry.equals("1")) {
            GameSetRespository.gameStatusEnd();
        }
    }

    /**
     * 결과 확인
     */
    private void resultCheck() {
        int ball = (int) playerRepository.getStore(BALL);
        int strike = (int) playerRepository.getStore(STRIKE);
        if (strike == GameSetRespository.getGameSet(CAPACITY_STR)) {
            // 성공 상태로 변경
            playerRepository.success();
        }
        // 결과 출력
        PrintMessage.outputMessage(ball, strike);
    }

    /**
     * 플레이어 입력
     */
    private void playerInput() {
        // 입력 요청 메시지
        PrintMessage.print(INPUT_MSG);
        // 사용자 입력 받기 - 진행 루프
        String inputStr = InputView.getInput();
        // 입력값 검증
        // 입력된 값 - 빈값 / 숫자 / 3자리 숫자 / 중복 확인
        CheckUtils.userInputCheck(inputStr, GameSetRespository.getGameSet(CAPACITY_STR));

        // 플레이어 저장
        playerSave(inputStr);
    }

    /**
     * 플레이어 저장
     */
    private void playerSave(String inputStr) {
        // 입력 받은 사용자 값 리스트 등록
        List<Integer> player = new ArrayList<>(GameSetRespository.getGameSet(CAPACITY_STR));
        char[] charArray = inputStr.toCharArray();
        for (char c : charArray) {
            player.add(Integer.parseInt(c + ""));
        }
        // 저장소에 플레이어 저장
        playerRepository.addPlayer(player);
    }

    /**
     * 플레이어와 컴퓨터 매치 확인
     */
    private void playerComputerMatchCheck() {
        List<Integer> computer = computerRepository.getStore(COMPUTER); // 컴퓨터 get
        List<Integer> player = (List<Integer>) playerRepository.getStore(PLAYER); // 플레이어 get
        for (int i = 0; i < computer.size(); i++) {
            int computerValue = computer.get(i);
            int playerValue = player.get(i);
            // 게임 결과 저장
            gameResultSave(computerValue, playerValue, computer);
        }
    }

    /**
     * 게임 결과 저장 스트라이크, 볼 여부
     */
    private void gameResultSave(int computerValue, int playerValue, List<Integer> computer) {
        if (computerValue == playerValue) {
            // 스트라이크 저장
            playerRepository.addStrike();
        } else if (computer.contains(playerValue)) {
            // 볼 저장
            playerRepository.addBall();
        }
    }

    /**
     * 컴퓨터 난수 초기화 사용자 정보 메모리 초기화
     */
    private void computerInit() {
        // 컴퓨터 랜덤 숫자 저장
        computerRepository.addComputer();
    }

    /**
     * 플레이어 정보 초기화
     */
    private void playerInit() {
        // 사용자 메모리 초기화
        playerRepository.playerReset();
    }
}
