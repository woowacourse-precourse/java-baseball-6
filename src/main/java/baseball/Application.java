package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 : 1~9 숫자 중 3가지로 이루어진 세자리 숫자.
        // 입력 시 같은 숫자는 사용 금지.
        // 입력 시 숫자만 입력 가능.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            int[] inputArray = new int[3];
            boolean[] checkList = new boolean[9];
            for (int i=0; i<inputArray.length; i++) {
                inputArray[i] = Integer.parseInt(st.nextToken()); // 입력 값이 숫자인지 체크
                if(!checkList[inputArray[i]-1]) {
                    checkList[inputArray[i]-1] = true;
                } else { // 중복된 숫자 체크.
                    throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
