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
    public void printJudgeResult(int ballCount, int strikeCount){
        if(ballCount == 0 && strikeCount == 0){
            System.out.println("낫싱");
            return;
        }
        if(ballCount > 0 && strikeCount > 0){
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
            return;
        }
        if(ballCount == 0){
            System.out.printf("%d스트라이크\n", strikeCount);
            return;
        }
        if(strikeCount == 0){
            System.out.printf("%d볼\n", ballCount);
            return;
        }
    }
    public int[] getUserNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        return getSplitedUserNumbers(Console.readLine());
    }
    private int[] getSplitedUserNumbers(String userInput){
        int[] userNumbers = new int[3];
        String trimUserInput = userInput.trim();
        Validation.validateUserInputSize(trimUserInput);
        char[] userCharNumbers = trimUserInput.toCharArray();
        boolean[] numberCheckArray = new boolean[10];
        for(int i = 0; i < 3; i++){
            Validation.validateIsNumber(userCharNumbers[i]);
            Validation.validateDuplicatedNumber(numberCheckArray, userCharNumbers[i]);
            userNumbers[i] = userCharNumbers[i] - '0';
        }
        return userNumbers;
    }
    public boolean getRestartInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean oneOrTwo = getOneOrTwo(Console.readLine());
        return oneOrTwo;
    }
    private boolean getOneOrTwo(String userInput){
        String trimUserInput = userInput.trim();
        RestartInput restartInput = new RestartInput(trimUserInput);
        if(restartInput.isOne()){
            return true;
        }
        printEndText();
        return false;
    }
    public void close(){
        Console.close();
    }
}
