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
        validateUserInputSize(input);
        char[] userInputs = input.toCharArray();
        boolean[] numberCheckArray = new boolean[10];
        for(int i = 0; i < 3; i++){
            validateIsNumber(userInputs[i]);
            validateDuplicatedNumber(numberCheckArray, userInputs[i]);
            result[i] = userInputs[i] - '0';
        }
        return result;
    }
    private void validateUserInputSize(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
    private void validateIsNumber(char input){
        if(input <= '0' || input > '9'){
            throw new IllegalArgumentException("1에서 9사이 숫자를 입력해주세요.");
        }
    }
    private void validateDuplicatedNumber(boolean[] numberCheckArray, char number){
        if(numberCheckArray[number - '0']){
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요");
        }
        numberCheckArray[number - '0'] = true;
    }
}
