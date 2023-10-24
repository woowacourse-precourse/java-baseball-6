package baseball.gamesystem;

import baseball.exception.IllegalArgumentException;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class GameSystem {
    public void validate(String userInput){
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
}
