package baseball;

public class Illegalcheck {

    public void commandCheck(int commandNumber){
        if(commandNumber == 1 || commandNumber == 2){
            return;
        }
        throw new IllegalArgumentException("입력값은 1 or 2 입니다.");
    }

    public void gameNumberFilter(String inputNumberLine){
        if(inputNumberLine.length() != 3){
            throw new IllegalArgumentException("3자리수의 숫자를 입력해야 합니다.");
        }

        for(int i = 0; i < inputNumberLine.length(); i++){
            if(inputNumberLine.charAt(i) == '0'){
                throw new IllegalArgumentException("1에서 9까지의 수를 입력해주세요");
            }

            if(inputNumberLine.charAt(i) > '9' || inputNumberLine.charAt(i) < '1'){
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }

        for(int i = 0; i < inputNumberLine.length(); i++){
            for(int j = 0; j < inputNumberLine.length(); j++){
                if(i == j){
                    continue;
                }

                if(inputNumberLine.charAt(i) == inputNumberLine.charAt(j)){
                    throw new IllegalArgumentException("같은 수는 입력될 수 없습니다.");
                }
            }
        }
    }
}
