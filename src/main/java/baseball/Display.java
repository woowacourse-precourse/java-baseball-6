package baseball;
import camp.nextstep.edu.missionutils.Console;
public class Display {
    public void printStartText(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        int[] userInputs = new int[3];
        String trimedUserInput = Console.readLine().trim();
        return trimedUserInput;
    }
}
