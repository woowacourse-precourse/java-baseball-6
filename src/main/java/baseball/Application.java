package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
 * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
 * 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
 *
 * exam
 * List<Integer> computer = new ArrayList<>();
 * while (computer.size() < 3) {
 *     int randomNumber = Randoms.pickNumberInRange(1, 9);
 *     if (!computer.contains(randomNumber)) {
 *         computer.add(randomNumber);
 *     }
 * }
 */
public class Application {

    public void start(){
        System.out.println(BaseballConstants.START_MESSAGE);
        //값 저장
        Set<String> computer = new HashSet<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //값 String으로 변환
        String result = computer.stream()
                .collect(Collectors.joining());

        System.out.println("result = " + result);

        //사용자 인풋 받기
        System.out.print(BaseballConstants.PLAY_MESSAGE);
        String input = Console.readLine();
        if(!isNumericAndThreeDigits(input)){
            throw new IllegalArgumentException("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
        }

        //값체크
        System.out.println("정답인가요?"+result.equals(input));
    }

    //서로 다른 수 체크하기
    private boolean isNumericAndThreeDigits(String input) {
        if (!Pattern.matches("^[1-9]{3}$",input)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.start();

    }
}
