package baseball.game;

import baseball.game.entity.Computer;
import baseball.game.entity.Member;
import baseball.game.repository.ComputerRepository;
import baseball.game.repository.MemberRepository;
import baseball.game.service.ComputerService;
import baseball.game.service.MemberService;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallGame {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
    private final ComputerRepository computerRepository = ComputerRepository.getInstance();
    private final MemberService memberService = MemberService.getInstance(memberRepository);
    private final ComputerService computerService = ComputerService.getInstance(computerRepository);

    private boolean isFirst = true;
    private Long computerId = 1L;


    public void run() {
        while (true) {
            // 게임 첫 시작 문구 출력
            if (isFirst) {
                NumberBaseBallGameMessage.printStart();
                isFirst = false;
            }

            // 게임 진행 문구 출력
            NumberBaseBallGameMessage.printRunning();

            // 콘솔에서 사용자의 숫자를 입력받음
            String userNumber = Console.readLine();
            Member member = memberService.readUserNumber(userNumber);

            // 게임 시작
            Computer computer = computerService.playGame(computerId);
            // 게임 결과
            String gameResult = computerService.gameResult(computer.getId(), member.getNumbers());
            // 게임 결과 출력
            NumberBaseBallGameMessage.printMessage(gameResult);

            // 게임이 종료되었으면
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
                        return;
                    }
                }
            }
        }
    }
}
