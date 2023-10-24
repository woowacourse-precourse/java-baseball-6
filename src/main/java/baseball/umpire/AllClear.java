package baseball.umpire;

import baseball.input.ComputerInput;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class AllClear {
    private String gameSet ="";
    private final ComputerInput computerInput = new ComputerInput();

    public boolean restartOrExit() {
        computerInput.reset();
        gameSet = readLine();

        if(gameSet.equals("1")) return true;
        else if(gameSet.equals("2")) return false;
        throw new IllegalArgumentException("잘못된 재시작/종료번호 입니다 :"+gameSet);
    }
}
