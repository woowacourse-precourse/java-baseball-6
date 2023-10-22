package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumber {

    private final static int NUMBER_LENGTH = 3;

    private final List<Integer> playerNumber;

    public PlayerNumber() {
        this.playerNumber = createPlayerNumber();
    }


    private List<Integer> createPlayerNumber() throws IllegalArgumentException {
        
        String playerInput = takePlayerInput();

        //문자열을 정수배열로 변환
        int[] numbers = convertPlayerInputInteger(playerInput);

        //정수 개수 확인
        if(numbers.length!=NUMBER_LENGTH){
            throw new IllegalArgumentException();
        }
        
        //범위 확인(1~9)
        if (!Arrays.stream(numbers).allMatch(number->1<=number&&number<=9)){
            throw new IllegalArgumentException();
        }

        //중복 확인
        if (Arrays.stream(numbers).distinct().count()!=NUMBER_LENGTH){
            throw new IllegalArgumentException();
        }

        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }

    private String takePlayerInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return input;
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
