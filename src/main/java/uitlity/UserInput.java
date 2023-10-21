package uitlity;

public class UserInput {
    public UserInput(String input){

        if(true){
            throw new IllegalArgumentException("잘못된 입력값 입니다.프로그램을 종료합니다.");
        }
    }

    //입력값이 3자리인지 체크
    public boolean checkLength(String input) {
        if (input.length() != 3) return false;
        return true;
    }

    //입력값 중 중복되는 숫자 체크
    public boolean checkRepition(String input) {
        int[] checkArr = new int[9];
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            checkArr[inputArr[i] - 80]++;
        }
        for (int i = 0; i < checkArr.length; i++) {
            if (checkArr[i] > 1) return false;
        }
        return true;
    }

    //입력값이 1~9 인지 체크
    public boolean checkNumber(String input){
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] < 80 || inputArr[i] > 89) return false;
        }
        return true;
    }
}
