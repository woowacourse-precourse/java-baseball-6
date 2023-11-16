package baseball.game;

import baseball.game.entity.Computer;
import baseball.game.entity.Member;
import baseball.game.repository.ComputerRepository;
import baseball.game.repository.GameResultRepository;
import baseball.game.repository.MemberRepository;
import baseball.game.service.ComputerService;
import baseball.game.service.MemberService;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallGame {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
    private final ComputerRepository computerRepository = ComputerRepository.getInstance();
    private final GameResultRepository gameResultRepository = GameResultRepository.getInstance();
    private final MemberService memberService = MemberService.getInstance(memberRepository);
    private final ComputerService computerService
            = ComputerService.getInstance(computerRepository, gameResultRepository);

    private boolean isFirst = true;
    private Long computerId = 1L;


    public void run() {
        while (true) {
            // 게임 시작 로직
            String gameResult = playGameLogic();

            // 게임결과에 따른 재시작 로직
            if (reStartGameLogic(gameResult)) {
                return;
            }
        }
    }

    private boolean reStartGameLogic(String gameResult) {
        if (NumberBaseBallGameMessage.isEnd(gameResult)) {
            while (true) {
                // 게임 재시작 문구 출력
                NumberBaseBallGameMessage.printContinue();
                // 사용자의 게임 재시작 의사를 입력받음
                String playAgainInput = Console.readLine();

                // 재시작
                if (NumberBaseBallGameMessage.isReStart(playAgainInput)) {
                    computerId++;
                    break;
                }
                // 종료
                else if (NumberBaseBallGameMessage.isExit(playAgainInput)) {
                    Console.close();
                    return true;
                }
            }
        }

        return false;
    }

    private String playGameLogic() {
        // 게임 첫 시작 문구 출력
        if (isFirst) {
            NumberBaseBallGameMessage.printStart();
            isFirst = false;
        }

        // 게임 진행 문구 출력
        NumberBaseBallGameMessage.printRunning();

        // 터미널에서 사용자의 입력값을 읽는다.
        String userNumber = Console.readLine();
        // 사용자가 입력한 숫자 저장
        Member member = memberService.saveUserNumber(userNumber);

        // 게임 생성
        Computer computer = computerService.createGame(computerId);
        // 게임 시작
        String gameResult = computerService.startGame(computer.getId(), member.getNumbers());
        // 게임 결과 출력
        NumberBaseBallGameMessage.printMessage(gameResult);

        return gameResult;
    }
}
