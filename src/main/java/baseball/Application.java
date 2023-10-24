package baseball;

import java.util.List;


public class Application {
    static List<Integer> computer;  // 컴퓨터 랜덤값
    static List<Integer> user;      // 사용자 입력값
    static int strike;              // strike 수
    static int ball;                // ball 수
    static int digitNumber;         // 대상값 자릿수
    public static void main(String[] args) {
        digitNumber = 3;  // 대상값 자릿수 설정(3자리)
    }
}
