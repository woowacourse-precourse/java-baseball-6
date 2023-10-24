package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballApp{

    private final GameManager gm = new GameManager();

    void run(){
        while (true){
            start();
            ComputerNumbers computerNumber = new ComputerNumbers();
            gm.playGame(computerNumber);
            if (terminate()){
                break;
            }
        }
    }

    private void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private boolean terminate(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exitInput = readLine();
        throwIfInvalidExitInput(exitInput);
        return exitInput.equals("2");
    }

    private void throwIfInvalidExitInput(String exitInput){
        if (!exitInput.equals("1") && !exitInput.equals("2")){
            throw new IllegalArgumentException("Invalid exit input : Exit input should be 1 or 2.");
        }
    }

}
