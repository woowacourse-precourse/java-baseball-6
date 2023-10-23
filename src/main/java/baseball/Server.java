package baseball;

import java.util.HashSet;
import java.util.Set;

public class Server {
    private int gameStatusCode=1;
    private Computer computer;
    private Player player;

    private final int digitalCount;
    private final int minimumCanCreatedValue;
    private final int maximumCanCreatedValue;
    Server(){
        this.digitalCount = Config.DEFAULT_DIGIT_COUNT;
        this.minimumCanCreatedValue = Config.DEFAULT_MINIMUM_CAN_CREATED_VALUE;
        this.maximumCanCreatedValue = Config.DEFAULT_MAXIMUM_CAN_CREATED_VALUE;
        this.computer = new Computer(
            digitalCount,
            minimumCanCreatedValue,
            maximumCanCreatedValue
        );
        this.player = new Player();
    }
    public void start(){
        while(gameStatusCode==1){
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                var playerInput = player.getPlayerInput();
                validatePlayerInput(playerInput);

                var playerNumber = Integer.parseInt(playerInput);
                var isPlayerWin = computer.checkUserNumberAndResponse(playerNumber);
                if (isPlayerWin == true){
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            var playerInput = player.getPlayerInput();
            validatePlayerInputCommand(playerInput);

            var userCommand = Integer.parseInt(playerInput);
            if (userCommand == 1) {
                restart();
            }
            if (userCommand == 2) {
                quit();
            }
        }
    }

    private void restart(){
        computer.numberList = computer.generateRandomNumberListWithNotRepeating();
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

        var validateNumberList = Util.parsingNumberToNumberList(playerNumber,digitalCount);
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
        if (numberLength == digitalCount){
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
