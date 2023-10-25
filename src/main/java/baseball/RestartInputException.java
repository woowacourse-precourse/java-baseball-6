package baseball;

public class RestartInputException {

    public int checkRestartInput(String endUserInput) {

        isNotOneandTwo(endUserInput);

        return Integer.parseInt(endUserInput);
    }

    public void isNotOneandTwo(String number) {
        int num = Integer.parseInt(number);
        if (num != 1 && num != 2) {

            throw new IllegalArgumentException("재시작 하거나 종료하기 위해선 1 또는 2를 입력하세요.");
        }
    }


}
