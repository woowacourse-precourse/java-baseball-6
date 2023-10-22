package baseball;

public class ValidateNum {
    public static void validatePlayerInput(String input){
        if (input==null || input.length() !=3){
            throw new IllegalArgumentException("입력 값은 3자리 숫자여야 합니다.");
        }
        for (char ch : input.toCharArray()){
            if (ch<'1' || ch>'9'){
                throw new IllegalArgumentException("입력 값은 1부터 9가지의 숫자여야 합니다.");
            }
        }
        if(hasDuplicateChars(input)){
            throw new IllegalArgumentException("입력 값은 중복된 숫자를 포함할 수 없습니다.");
        }
    }

    public static void validateRestartInput(String input){
        if(!input.equals("1") && !"2".equals(input)){
            throw new IllegalArgumentException("입력 값은 1 또는 2여야 합니다.");
        }
    }

    private static boolean hasDuplicateChars(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
               if(str.charAt(i)==str.charAt(j)){
                   return true;
               }
            }
        }
        return false;
    }
}
