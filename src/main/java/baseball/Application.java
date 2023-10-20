package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isChecked = true;
        List<Integer> computer = new ArrayList<>();
        while (computer.size() <3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(isChecked){
            // 사용자의 입력을 받는 부분
            try{
                System.out.print("숫자를 입력해주세요 : ");
                String[] user = br.readLine().split("");

                // 무슨 말인지 모르겠다 공부하자 새로운 언어에서의 문법
                Integer[] userNumber = Stream.of(user).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            }catch(IOException e) {
                System.out.println(e);
            }


        }
    }
}
