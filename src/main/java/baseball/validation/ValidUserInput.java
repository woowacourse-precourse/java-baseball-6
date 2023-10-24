package baseball.validation;

public class ValidUserInput {

    public int[] valid(String input, int size) throws IllegalArgumentException{
        notThreeNumber(input, size);
        return notNumber(input, size);
    }

    //3의 자리가 아닐 때,
    public void notThreeNumber(String input, int size) throws IllegalArgumentException{
        if(input.length() != size){
            throw new IllegalArgumentException();
        }
    }

    public int[] notNumber(String input, int size) throws IllegalArgumentException{

        int[] resInput = new int[size];

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c < '1' || c > '9'){
                throw new IllegalArgumentException();
            } else {
                resInput[i] = notDifferNumber(resInput, c, i);
            }
        }
        return resInput;
    }

    //서로 다른 3개의 숫자가 아닌 경우
    public int notDifferNumber(int[] resInput, char c, int index) throws IllegalArgumentException {
        int num = c - '0';
        for(int i=0; i<index; i++){
            if(resInput[i] == num) throw new IllegalArgumentException();
        }
        return num;
    }

}
