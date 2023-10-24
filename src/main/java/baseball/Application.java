package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        String play = "1";

        while (play.equals("1")){
            List<Integer> computer = createComputerNumber();
            System.out.println("숫자 야구 게임을 시작합니다.");

            boolean isGameFinish = false;
            while(!isGameFinish) {
                System.out.print("숫자를 입력해주세요 : ");

                String input = Console.readLine();
                if (!checkLength(input) || !checkIsNumber(input)) throw new IllegalArgumentException();

                List<Integer> numbers = Stream.of(input.split("")).map(Integer::valueOf).toList();
                if (checkDuplicateNumber(numbers)) throw new IllegalArgumentException();

                Result result = getResult(computer, numbers);
                isGameFinish = true;
            }
            play = "2";
        }
    }

    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean checkLength(String input) {
        return input.length() == 3;
    }

    private static boolean checkIsNumber(String input) {
        for(int i = 0; i < input.length() ; i++){
            if(!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean checkDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> integers = new HashSet<>(numbers);
        if(integers.size()!=3){
            return true;
        }
        return false;
    }

    private static Result getResult(List<Integer> computer, List<Integer> numbers) {
        int ballCnt = 0, strikeCnt = 0;
        for(int i = 0; i < 3; i++){
            if(Objects.equals(numbers.get(i), computer.get(i))){
                strikeCnt += 1;
            }else if(computer.contains(numbers.get(i))){
                ballCnt += 1;
            }
        }
        Result result = new Result(ballCnt, strikeCnt);
        return result;
    }

    private record Result(int ballCnt, int strikeCnt) {
    }
}
