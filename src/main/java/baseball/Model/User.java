package baseball.Model;

public class User {
    private String number;
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) throws IllegalArgumentException{
        if(number.length() != 3){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
        }

        if (hasDuplicatePattern(number)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        this.number = number;
    }

    public static boolean hasDuplicatePattern(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

}