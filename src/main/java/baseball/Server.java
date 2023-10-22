package baseball;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private static final int defaultDigitalCount = 3;
    private static final int minimumCanCreatedValue = 1;
    private static final int maximumCanCreatedValue = 9;

    private int gameStatusCode=1;
    private Computer computer;
    private Player player;
    Server(){
        this.computer = new Computer();
        this.player = new Player();
    }
    public void start(){
        var userInput = player.getPlayerInput();
        validatePlayerInputCommand(userInput);

        var userCommand = Integer.parseInt(userInput);
        if (userCommand == 1) {
            restart();
        }
        if (userCommand == 2) {
            quit();
        }
    }

    private void restart(){
        computer = new Computer();
        gameStatusCode = 1;
        return;
    }
    private void quit(){
        gameStatusCode = 0;
        return;
    }
    /**
     * 사용자가 입력한 값 검증
     *
     * 사용자가 입력한 값이 유효할 시 , 통과한다
     * 사용자가 잘못된 값을 입력한 경우 , IllegalArgumentException 을 발생시킨다.
     *
     * @param playerInput 사용자가 입력한 값
     */
    public void validatePlayerInput(String playerInput){
        validateInputIsNumber(playerInput);

        var playerNumber = Integer.parseInt(playerInput);
        validateNumberLength(playerNumber);

        var validateNumberList = Util.parsingNumberToNumberList(playerNumber,defaultDigitalCount);
        validateListNumberInRange(validateNumberList);
        validateListNumberIsNotDuplicated(validateNumberList);
        return;
    }
    public void validatePlayerInputCommand(String playerInput){
        validateInputIsNumber(playerInput);

        var playerCommand = Integer.parseInt(playerInput);
        validateCommandIsAppropriate(playerCommand);

        return;
    }
    private void validateInputIsNumber(String playerInput){
        try{
            Integer.parseInt(playerInput);
        }catch(NumberFormatException e){
            // 문자열 -> 정수 변환 못하는 NumberFormatException 이나,
            // 요구사항에서 의도한 대로 IllegalArgumentException throw
            throw new IllegalArgumentException("숫자를 입력해주세요!");
        }

    }
    private void validateNumberLength(int playerNumber){
        var numberLength = Integer.toString(playerNumber).length();
        if (numberLength == defaultDigitalCount){
            return;
        }
        throw new IllegalArgumentException("자리수가 다릅니다!");
    }
    private void validateListNumberInRange(int[] numberList){
        for (int number : numberList){
            if ( minimumCanCreatedValue <= number && number <=maximumCanCreatedValue){
                continue;
            }
            throw new IllegalArgumentException("숫자가 범위밖에 있습니다!");
        }
        return;
    }
    private void validateListNumberIsNotDuplicated(int[] numberList){
        Set<Integer> numberSet = new HashSet<>();
        for(int number:numberList){
            numberSet.add(number);
        }
        if (numberSet.size()==numberList.length){
            return;
        }
        throw new IllegalArgumentException("중복된 숫자가 있습니다!");
    }
    private void validateCommandIsAppropriate(int playerCommand){
        if (playerCommand == 1 || playerCommand ==2)
            return;
        throw new IllegalArgumentException("없는 명령입니다!");
    }
    public int getGameStatusCode(){
        return gameStatusCode;
    }

}
