package baseball.model;
/*
* 재시작
* */
public class ReStart {

    public static void RetryNumber_C(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }
    }
}
