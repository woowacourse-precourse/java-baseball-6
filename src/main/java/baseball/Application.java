package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    static List<Integer> answerList;
    static String input;
    static List<Integer> inputList ;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        answerList = makeNewAnswer();  // 1. 자동 정답 생성

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");

            input = Console.readLine();
            inputValidation(input);  // 2. 입력값 검증

            int[] ballStrikeCount = {0, 0}; // 3. ball : 0 strike : 1  ball strike 개수 확인

            for (int i = 0; i < 3; i++) {
                int inputValue = inputList.get(i);
                if (answerList.contains(inputValue)) {
                    int answerValue = answerList.get(i);
                    if (answerValue == inputValue) {
                        ballStrikeCount[1]++;
                        continue;
                    }
                    ballStrikeCount[0]++;
                }
            }

            if (printResult(ballStrikeCount)) {  // 1볼, 1볼 1스트라이크, 1스트라이크
                break;
            }
        }
    }

    private static boolean printResult(int[] check) {
        if(check[0] != 0 && check[1] != 0){
            System.out.printf("%d볼 %d스트라이크\n", check[0], check[1]);
        }else if(check[0] != 0 && check[1] == 0){
            System.out.printf("%d볼\n", check[0]);
        }else{ // check[0] == 0
            if(check[1]== 3){
                System.out.printf("%d스트라이크\n",check[1]);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = Console.readLine();
                if(input.equals("1")) {
                    answerList = makeNewAnswer();
                }else if(input.equals("2")){
                    return true;
                }else{
                    throw new IllegalArgumentException();
                }
            }else if(check[1]== 0){
                System.out.println("낫싱");
            }else{
                System.out.printf("%d스트라이크\n", check[1]);
            }
        }

        return false;
    }

    private static void inputValidation(String input) {
        if(input.length()!=3) {
            throw new IllegalArgumentException();
        }

        String[] inputArr = input.split("");
        List<String> strList= new ArrayList<>(Arrays.asList(inputArr));

        try {
                inputList = strList
                    .stream()
                    .map(s->Integer.parseInt(s))
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> makeNewAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
