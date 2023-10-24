package baseball.gamesystem;

import baseball.broadcaster.Broadcaster;
import baseball.broadcaster.RESULT;
import baseball.computer.Computer;
import baseball.exception.IllegalArgumentException;
import baseball.umpire.Umpire;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameSystem {

    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static RESULT doGame(List<Integer> computerNumbers){
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        validate(userInput);
        List<Integer> userNumbers = convertIntoNumbers(userInput);

        return Broadcaster.broadcast(Umpire.judge(computerNumbers, userNumbers));
    }

    private static void validate(String userInput){
        Set<Character> uniqueInputs = new HashSet<>();
        if(userInput.length() != 3){
            throw new IllegalArgumentException("서로 다른 3개의 수를 입력해주세요.");
        }
        for(char ch : userInput.toCharArray()){
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("입력 가능한 수의 범위는 1에서 9까지 입니다.");
            }
            if(!uniqueInputs.add(ch)){
                throw new IllegalArgumentException("중복이 발생했습니다.");
            }
        }
    }

    private static List<Integer> convertIntoNumbers(String userInput){
        List<Integer> numbers = new ArrayList<>();
        for (char ch : userInput.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
}
