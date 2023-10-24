package baseball.player;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String number;

    public void setNumber(String number)  {
        isCorrectLength(number, 3);
        isDist(number);
        isDuplication(number);

        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void askNumber() {
        setNumber(Console.readLine());
    }
    public String askRestart(){
        String restart = Console.readLine();
        isCorrectLength(restart, 1);
        isDist(restart);
        isCorrectInput(restart);

        return restart;
    }

    private void isCorrectLength(String number, int length) throws IllegalArgumentException {
        if(number.length() != length){
            throw new IllegalArgumentException("입력이 " + length +"자리 값이 아닙니다.");
        }
    }

    private void isDist(String number)throws IllegalArgumentException {
        for(int i = 0; i < number.length(); i++) {
            if(!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
                throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
            }
        }
    }

    private void isDuplication(String number) throws IllegalArgumentException {
        for(int i = 0; i < number.length()-1; i++){
            for(int j = i + 1; j < number.length(); j++){
                if(number.charAt(i) == number.charAt(j)){
                    throw new IllegalArgumentException("입력에 중복 값이 있습니다.");
                }
            }
        }
    }

    private void isCorrectInput(String number) throws IllegalArgumentException {
        if (!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다");
        }
    }
}
