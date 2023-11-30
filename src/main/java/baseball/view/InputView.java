package baseball.view;

import baseball.service.ValidCheckService;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {


    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        return userInput;
    }
    public boolean inputAfterFinish(){
        String input = inputAfterEnd();
        //유효한 숫자인지 검증하는 로직 필요
        ValidCheckService.validExitNumber(input);
        if (input.equals("1")) {
            return true;
        }
        System.out.println("프로그램을 종료합니다.");
        return false;
    }
    private String inputAfterEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        return input;
    }
}
