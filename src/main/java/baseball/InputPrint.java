package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputPrint{
    public static List<Integer> ballInput(int maxBallSize, int minimumNum, int maximumNum){
        String[] userInput;
        List<Integer> returnInput = new ArrayList<>(maxBallSize);

        System.out.print("숫자를 입력해주세요 : ");
        userInput = readLine().split("");
        ErrorCatcher.errorCheck(userInput, maxBallSize, minimumNum, maximumNum);
        for(String s : userInput) returnInput.add(Integer.parseInt(s));
        return returnInput;
    }
    public static boolean isEndOfGame(){
        String userInput;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userInput = readLine();
        if (userInput == "1") return true;
        else return false;
    }
}
