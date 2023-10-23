package baseball.umpire;

import baseball.input.ComputerInput;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class AllRightAnswer {
    private String gameSet ="";
    private ComputerInput computerInput = new ComputerInput();
    public String restartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        computerInput.reset();
        gameSet = readLine();

        if(gameSet.equals("1")) return "재시작";
        else if(gameSet.equals("2")) return "게임 종료";
        throw new IllegalArgumentException("잘못된 재시작/종료번호 입니다 :"+gameSet);
    }
}
