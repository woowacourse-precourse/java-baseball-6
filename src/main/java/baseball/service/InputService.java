package baseball.service;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public String getInputNumber(){ //사용자에게 야구게임 숫자를 받는 함수
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        if(!isNumberic(numbers)){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요. ");
        }
        return numbers;
    }
    public boolean isNumberic(String numbers){ //숫자인지 검사하는 함수
        return (numbers.matches("[0-9]+"));
    }

}
