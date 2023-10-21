package baseball;
import baseball.domain.Computer;
import baseball.domain.Judge;
import baseball.domain.User;
import baseball.service.ComputerService;
import baseball.service.JudgeService;
import baseball.service.UserService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ComputerService computerService = new ComputerService();
        UserService userService = new UserService();
        JudgeService judgeService = new JudgeService();

        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputSystem;

        List<Integer> computerNumber = computerService.generateRandom();

        do{
            inputSystem = ""; // 재시작 후에 초기화를 하기 위함
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = userService.generateInput();
            judgeService.judgeResult(computerNumber, userNumber);
            judgeService.printResult();

            boolean threeStrike = judgeService.checkThree();

            if (threeStrike) {
                inputSystem = Console.readLine();
            }

            if (inputSystem.equals("1")) {
                computerService.resetRandom();
                computerNumber = computerService.generateRandom();
            }

            judgeService.resetResult();
            userService.resetInput();
        }while(!inputSystem.equals("2"));
    }
}
