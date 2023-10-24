package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private final int digitalCount;
    private final int minimumCanCreatedValue;
    private final int maximumCanCreatedValue;
    Validator(){
        this.digitalCount = Config.DEFAULT_DIGIT_COUNT;
        this.minimumCanCreatedValue = Config.DEFAULT_CAN_CREATED_MINIMUM_VALUE;
        this.maximumCanCreatedValue = Config.DEFAULT_CAN_CREATED_MAXIMUM_VALUE;
    }
    Validator(int digitCount,int minimumCanCreatedValue,int maximumCanCreatedValue) {
        this.digitalCount = digitCount;
        this.minimumCanCreatedValue = minimumCanCreatedValue;
        this.maximumCanCreatedValue = maximumCanCreatedValue;
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
}
