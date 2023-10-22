package baseball;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Computer {
    List<Integer>  numbers;

    // 생성자는 리턴 자료형을 정의하지 않는다
    Computer() {
        this.numbers = new ArrayList<>();
        setRandomNumbers(numbers);
    }
    void setRandomNumbers(List<Integer> list) {
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
    }


    // 입력 숫자가 컴퓨터 숫자와 얼마나 일치하는지 판단.
    List<Integer> guessScore(String userNums) {
        int strike = 0, ball = 0, userNum;
        for (int i = 0; i < 3; ++i) {
            userNum = intger(userNums.get(i));
            if (userNums.get(i) == numbers.get(i))
                strike++;
            else if (numbers.contains(userNum))
                ball++;
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(strike);
        answer.add(ball);
        return answer;
    }


}

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // computer 리스트에 세 랜덤한 넘버를 추가한다.
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer cp = new Computer();
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            System.out.println(input);
        }

    }
}
