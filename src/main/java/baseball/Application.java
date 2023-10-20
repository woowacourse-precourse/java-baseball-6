package baseball;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	
    	System.out.print("서로 다른 세자리 수를 입력하세요 >> ");
    	Scanner sc = new Scanner(System.in);
    	
    	ArrayList<Integer> availableDigits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            availableDigits.add(i);
        }
        Random random = new Random();
        int[] randomThreeDigitNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(availableDigits.size());
            randomThreeDigitNumber[i] = availableDigits.get(index);
            availableDigits.remove(index);
        }

        // 생성된 3자리 숫자를 출력
        int result = randomThreeDigitNumber[0] * 100 + randomThreeDigitNumber[1] * 10 + randomThreeDigitNumber[2];
        System.out.println(result);
    	
    	
    	
    	
    }
}
