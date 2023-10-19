package baseball;
import camp.nextstep.edu.missionutils.Console;
public class Display {
    public void printStartText(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public int[] getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String trimedUserInput = Console.readLine().trim();
        return splitUserInput(trimedUserInput);
    }
    public int[] splitUserInput(String input){
        int[] result = new int[3];
        char[] userInputs = input.toCharArray();
        for(int i = 0; i < 3; i++){
            result[i] = userInputs[i] - '0';
        }
        return result;
    }
}
