package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static baseball.MessageConstants.*;

public class Application {
    private static boolean playFlag = true;
    private final int NUMBER_LENGTH = 3;

    public void run(){
        //값 저장
        Set<String> computer = initComputer();
        String result = computer.stream().collect(Collectors.joining());

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
        String message = "";

        if (strikeCount > 0 && ballCount > 0) {
            message = String.format(BALL_AND_STRIKE_FORMAT, ballCount, strikeCount);
        } else if (strikeCount > 0) {
            message = String.format(STRIKE_FORMAT, strikeCount);
        } else if (ballCount > 0) {
            message = String.format(BALL_FORMAT, ballCount);
        } else {
            message = EMPTY_FORMAT;
        }

        System.out.println(message);
        return strikeCount == NUMBER_LENGTH;
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

        return length == 3 ? true : false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        while (playFlag){
            System.out.println(START_MESSAGE);
            application.run();
            System.out.println(END_MESSAGE);
            application.isPlay(Console.readLine());
        }

    }

    private void isPlay(String playNumber) {
        switch (playNumber){
            case "1" -> playFlag = true;
            case "2" -> playFlag = false;
            default -> {
                throw new IllegalArgumentException(String.format("입력값 \"%s\"는 잘못된 요청 정보입니다.", playNumber));
            }
        }
    }
}
