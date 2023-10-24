package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumber {
    private final static int NUMBER_LENGTH = 3;
    private final static int START_NUMBER = 1;
    private final static int FINAL_NUMBER = 9;
    private final static String PLAYER_INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    private final List<Integer> playerNumber;

    public PlayerNumber() {
        this.playerNumber = createPlayerNumber();
    }


    private List<Integer> createPlayerNumber() throws IllegalArgumentException {

        int[] numbers = takePlayerInput();

        if (validatePlayerInput(numbers)){
            return Arrays.stream(numbers).boxed().collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }

    private boolean validatePlayerInput(int[] numbers){
        return isRightNumberLength(numbers)&&isRightNumberRange(numbers)&&isNumberDuplicated(numbers);
    }
    private boolean isRightNumberLength(int[] numbers){
        return numbers.length==NUMBER_LENGTH;
    }
    private boolean isRightNumberRange(int[] numbers){
        return Arrays.stream(numbers).allMatch(number->START_NUMBER<=number&&number<=FINAL_NUMBER);
    }
    private boolean isNumberDuplicated(int[] numbers){
        return Arrays.stream(numbers).distinct().count()==NUMBER_LENGTH;
    }

    private int[] takePlayerInput(){
        System.out.print(PLAYER_INPUT_SENTENCE);
        String input = Console.readLine();
        int[] numbers = convertPlayerInputInteger(input);

        return numbers;
    }
    private int[] convertPlayerInputInteger(String playerInput){
        int[] numbers = playerInput.chars()
                .map(number -> number - '0').toArray();

        return numbers;
    }


    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }
}
