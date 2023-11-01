package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 랜덤한 값 서로 다른 수 3자리를 생성한다. TODO 함수로 뺄 예정
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        Set<Integer> targetSet = new HashSet<>();
        while (targetSet.size() < 3) {
            int randomNum = random.nextInt(9)+1;
            targetSet.add(randomNum);
        }

        // 사용자 수 받아오기


        // 사용자 수와 컴퓨터 수 검증하기


        //



    }
}
