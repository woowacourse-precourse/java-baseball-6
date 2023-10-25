package baseball;

import baseball.domain.Judge;
import baseball.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumber();


        Judge judge = new Judge();
        String result = "";
        while(!result.equals("0 볼 3 스트라이크")){
            result = judge.compare(computer, askNumbers());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> askNumbers() {
        System.out.println("숫자를 입력해주세요: ");

        String input = Console.readLine();

        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            strList.add(String.valueOf(input.charAt(i)));
        }
        Set<String> strSet = new HashSet<>(strList);
        if (strList.size() != strSet.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자가 아닙니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public String restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");

        return Console.readLine();
    }
}
