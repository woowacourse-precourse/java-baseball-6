package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = new ArrayList<>(); // computer 숫자 (정답)
        List<Integer> user = new ArrayList<>(); // computer 숫자 (정답)
        int strike = 0;
        int ball = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (user.size() < 3){
            user = Arrays.stream(Console.readLine().split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        }
        while(true) {
            //과정2 : inputArr.length만큼 반복해 유저가 입력한 숫자를 순서대로 inputArr에 넣는다.
            String num = Console.readLine();
            for(int i  = 0; i < userNumArr.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(userNumArr[j] == userNumArr[i]) {
                        //유저가 입력한 i인덱스에 들어갈 숫자가 중복된 숫자인지 확인
                        System.out.println("중복된 값을 입력했습니다.");
                        break;
                    }
                }
            }
            for (int x : computer){
                System.out.println(x+" ");
            }
            for (int x : userNumArr){
                System.out.println(x+" ");
            }
            //과정3 : 유저가 입력한 숫자와 정답숫자를 비교하여 Strike인지 Ball인지 구분한다.
            for(int i = 0; i < numArr.length; i++) {
                for(int j = 0; j < userNumArr.length; j++) {
                    //numArr의 i번째 인덱스와 inputArr의 모든 원소들을 비교
                    if(numArr[i] == userNumArr[j] && i == j) {
                        //같은 숫자가 있고 인덱스도 같으면 스트라이크
                        strike++;
                    }else if(numArr[i] == userNumArr[j] && i != j) {
                        //같은 숫자만 있으면 볼
                        ball++;
                    }
                }
            }

            System.out.println(strike + "스트라이크" + ball + "볼");
            if(strike == 3) {
                System.out.println("정답!");
                break;
            }
            strike = 0;
            ball = 0;
        }
    }
}
