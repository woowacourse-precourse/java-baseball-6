package baseball;
import camp.nextstep.edu.missionutils.Console;
public class Display {
    public void printStartText(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private void printEndText(){
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
    public void printGameOverText(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public int[] getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        return getSplitedUserInput(Console.readLine());
    }
    public int[] getSplitedUserInput(String input){
        int[] result = new int[3];
        String trimInput = input.trim();
        validateUserInputSize(trimInput);
        char[] userInputs = trimInput.toCharArray();
        boolean[] numberCheckArray = new boolean[10];
        for(int i = 0; i < 3; i++){
            validateIsNumber(userInputs[i]);
            validateDuplicatedNumber(numberCheckArray, userInputs[i]);
            result[i] = userInputs[i] - '0';
        }
        return result;
    }
    public boolean getRestartInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean oneOrTwo = getOneOrTwo(Console.readLine());
        return oneOrTwo;
    }
    public boolean getOneOrTwo(String input){
        String trimInput = input.trim();
        validateOneOrTwo(trimInput);
        if(trimInput.equals("1")){
            return true;
        }
        printEndText();
        return false;
    }
    private void validateOneOrTwo(String input){
        if(!(input.equals("1") || input.equals("2"))){
            throw new IllegalArgumentException("1 혹은 2를 입력하세요.");
        }
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
