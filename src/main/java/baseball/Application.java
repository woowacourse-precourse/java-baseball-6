package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static baseball.MessageConstants.*;

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
    private final int NUMBER_LENGTH = 3;

    public void start(){
        System.out.println(START_MESSAGE);
        //값 저장
        Set<String> computer = initComputer();

        //값 String으로 변환
        String result = computer.stream().collect(Collectors.joining());
        System.out.println("result = " + result);

        while (true){
            //사용자 인풋 받기
            System.out.print(PLAY_MESSAGE);
            String input = Console.readLine();
            inputCheck(input);
            if(isResult(input,result)){
                System.out.println(COMPLETE_MESSAGE);
                break;
            }
        }
    }

    private Set<String> initComputer() {
        Set<String> computer = new HashSet<>();
        while (computer.size() < NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            computer.add(randomNumber);
        }
        return computer;
    }

    private Boolean isResult(String input, String result){
        int strikeCount = 0;
        int ballCount = 0;
        for (int i=0; i<NUMBER_LENGTH; i++){
            if (input.charAt(i) == result.charAt(i)){
                strikeCount++;
            } else {
                String c = String.valueOf(input.charAt(i));
                boolean contains = result.contains(c);
                if (contains) {
                    ballCount++;
                }
            }
        }
        return isResult(strikeCount, ballCount);
    }
    private Boolean isResult(int strikeCount, int ballCount) {

        if (strikeCount == NUMBER_LENGTH){
            System.out.println(String.format(STRIKE_FORMAT, strikeCount));
            return true;
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(String.format(BALL_AND_STRIKE_FORMAT, ballCount, strikeCount));
        } else if (strikeCount > 0) {
            System.out.println(String.format(STRIKE_FORMAT, strikeCount));
        } else if (ballCount > 0) {
            System.out.println(String.format(BALL_FORMAT, ballCount));
        } else {
            System.out.println(EMPTY_FORMAT);
        }
        return false;
    }
    private void inputCheck(String input){
        if (!isNumericAndThreeDigits(input)){
            throw new IllegalArgumentException("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
        } else if (!hasDuplicateDigits(input)) {
            throw new IllegalArgumentException("입력값은 중복되면 안됩니다.");
        }

    }
    //서로 다른 수 체크하기
    private boolean isNumericAndThreeDigits(String input) {
        if (!Pattern.matches("^[1-9]{3}$",input)){
            return false;
        }
        return true;
    }

    private boolean hasDuplicateDigits(String input){
        int length = input.chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values()
                .size();
        System.out.println("length = " + length);

        return length == 3 ? true : false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        String playNumber = "1";
        while (playNumber.equals("1")){
            application.start();
            System.out.println(END_MESSAGE);
            playNumber = Console.readLine();
            if (!(playNumber.equals("1") || playNumber.equals("2"))){
                throw new IllegalArgumentException("입력값 \""+playNumber+"\"는 잘못된 요청 정보입니다.");
            }
        }

    }
}
