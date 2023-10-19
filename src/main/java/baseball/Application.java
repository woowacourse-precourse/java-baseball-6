package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1.컴퓨터 숫자 생성 메소드
        //2.사용자 숫자 입력 받기
        //3.비교 연산 메소드
        //숫자, 자리가 모두 만족 시 스트라이크
        //숫자가 맞지만 자리가 다른 경우 ball

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(br.readLine());
        }catch()
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
