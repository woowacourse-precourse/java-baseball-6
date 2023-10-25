package baseball;

public class Input {
    private Check check;
    public Input(){
        check = new Check();
    }
    //숫자 3자리 입력받기
     public int[] validateInput(String input){
        check.checkingInput(input);
        int[] inputList = new int[3];
        for(int i=0; i<inputList.length; i++){
            inputList[i] = input.charAt(i) - '0';
        }
        return inputList;
     }
    //1또는 2 입력받기
    public boolean choiceRetryOrEnd(String input){
        check.checkingRetryOrEnd(input);
        if(input.equals("2")){
            return true;
        }
        else{
            return false;
        }
    }
}
