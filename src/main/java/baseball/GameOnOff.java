package baseball;

public class GameOnOff {

    int inputNum;

    public int gameStart() {
        return 1;
    }

    // 게임 지속 의사 확인
    public int gameContinue(String input) {
        validationNumber(input);
        validationOneTwo();
        return inputNum;
    }

    // 입력값 유효성 확인: 숫자 여부
    private void validationNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            inputNum = num;
        }
        catch (NumberFormatException ex){
            System.out.println("잘못된 값을 입력하였습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 입력값 유효성 확인: 1 or 2
    private void validationOneTwo() {
        if (inputNum != 1 && inputNum != 2) {
            throw new IllegalArgumentException();
        }
    }

}
