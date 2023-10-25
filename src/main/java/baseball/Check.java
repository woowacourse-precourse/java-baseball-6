package baseball;

public class Check {

    //3자리 숫자를 입력했는지 확인
    private void checkingRange(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        }
    }
    //숫자인지 중복되는 숫자가 있는지 확인
    private void checkingNumber(String input){

        char list[] = input.toCharArray();
        boolean duplicate[] = new boolean[10];
        for(int i=0; i<list.length; i++){
            int num = list[i] - '0';
            if(num <= 0 || num > 9){
                throw new IllegalArgumentException("1~9까지의 숫자만 입력해야합니다.");
            }
            if(duplicate[num]){
                throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해야합니다.");
            }
            duplicate[num] = true;
        }

    }
    public void checkingInput(String input){
        checkingRange(input);
        checkingNumber(input);
    }


}
