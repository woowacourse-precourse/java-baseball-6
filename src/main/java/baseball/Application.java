package baseball;

import baseball.game.NumberBaseBallGameMessage;
import baseball.game.entity.Computer;
import baseball.game.entity.Member;
import baseball.game.repository.ComputerRepository;
import baseball.game.repository.MemberRepository;
import baseball.game.service.ComputerService;
import baseball.game.service.MemberService;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static boolean isFirst = true;
    private static Long computerId = 1L;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /**
         * 입력
         *  - 서로 다른 3자리의 수
         *  - 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수(재시작:1, 종료:2)
         */
        MemberRepository memberRepository = new MemberRepository();
        ComputerRepository computerRepository = new ComputerRepository();

        MemberService memberService = new MemberService(memberRepository);
        ComputerService computerService = new ComputerService(computerRepository);

        while (true) {
            // 게임 첫 시작 문구 출력
            if(isFirst) {
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
            if(NumberBaseBallGameMessage.isEnd(gameResult)) {
                while (true) {
                    // 게임 재시작 문구 출력
                    NumberBaseBallGameMessage.printContinue();
                    // 사용자의 게임 재시작 의사를 입력받음
                    String playAgainInput = Console.readLine();
                    if (playAgainInput.equals("1")) {
                        computerId++;
                        break;
                    }
                    else if (playAgainInput.equals("2")) {
                        // 애플리케이션 종료
                        Console.close();
                        return;
                    }
                }
            }
        }
    }
}
