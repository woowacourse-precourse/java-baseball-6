package utility;

public class Check {
    private Check(){}

    public static boolean checkUserInput(String input){
        if (!checkNumber(input)) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }else if(!checkLength(input)){
            throw new IllegalArgumentException("입력값이 3자리 미만 혹은 이상입니다.");
        } else if (!checkRepetition(input)) {
            throw new IllegalArgumentException("입력값에 중복되는 값이 있습니다.");
        }
        return true;
    }

    //입력값이 3자리인지 체크
    public static boolean checkLength(String input) {
        if (input.length() != 3) return false;
        return true;
    }

    //입력값 중 중복되는 숫자 체크
    public static boolean checkRepetition (String input)  {
        int[] checkArr = new int[9];
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            checkArr[inputArr[i] - 49]++;
        }
        for (int i = 0; i < checkArr.length; i++) {
            if (checkArr[i] > 1) return false;
        }
        return true;
    }

    //입력값이 1~9 인지 체크
    public static boolean checkNumber(String input){
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] < 49 || inputArr[i] > 57) return false;
        }
        return true;
    }
}
