package baseball;

public class Application {
    public static void main(String[] args) {

        boolean continuePlaying = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            play();
            continuePlaying = askContinue();

        }while(continuePlaying);

    }

    private static void play(){
        int randomNum = generateRandomNumber();
        String userInput;
        boolean win = false;

        do{
            System.out.print("숫자를 입력해주세요:");
            userInput = camp.nextstep.edu.missionutils.Console.readLine();
            checkUserInput(userInput);

            if(getResult(randomNum, Integer.parseInt(userInput))){
                win = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

        }while(!win);
    }

    public static int generateRandomNumber(){
        int randomNum;
        do{
            randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(100,999);
        }while(!checkNumber(randomNum));

        return randomNum;
    }

    private static boolean checkNumber(int number){
        int[] numArr = new int[3];
        boolean[] checkNum = {false, false, false, false, false, false, false, false, false};

        for(int i = 0; i < 3; i++){

            if(number % 10 == 0){
                return false;
            }

            if(checkNum[number % 10 - 1]){
                return false;
            }

            numArr[2 - i] = number % 10;
            checkNum[number % 10 - 1] = true;
            number /= 10;

        }
        return true;
    }

    public static void checkUserInput(String userInput){
        if(userInput.length() > 3){
            throw new IllegalArgumentException("입력값은 세자리 숫자여야 합니다.: "+userInput);
        }

        char temp = 0;
        for(int i = 0; i<userInput.length();i++){
            temp = userInput.charAt(i);
            if(temp < '0' || temp > '9'){
                throw new IllegalArgumentException("입력값은 세자리 숫자여야 합니다.: "+userInput);
            }
        }

        if(!checkNumber(Integer.parseInt(userInput))){
            throw new IllegalArgumentException("입력값은 세자리 숫자여야 합니다.: "+userInput);
        }
    }

    public static boolean getResult(int randomNum, int userNum){
        int[] randomArr = intToArray(randomNum);
        int[] userArr = intToArray(userNum);
        int strike = 0;
        int ball = 0;

        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3;j++){
                if(userArr[i] == randomArr[j]){
                    if(i == j){
                        strike++;
                        break;
                    }
                    ball++;
                }
            }
        }

        if(strike != 0 && ball != 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        } else if (strike != 0) {
            System.out.println(strike+"스트라이크");
        } else if (ball != 0) {
            System.out.println(ball+"볼");
        }else{
            System.out.println("낫싱");
        }

        if(strike == 3){
            return true;
        } else{
            return false;
        }
    }

    public static int[] intToArray(int n){
        int[] arr = new int[3];

        for(int i = 0; i < 3; i++){
            arr[2 - i] = n % 10;
            n /= 10;
        }

        return arr;
    }

    public static boolean askContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = camp.nextstep.edu.missionutils.Console.readLine();

        if(userInput.equals("1")){
            return true;
        } else if(userInput.equals("2")){
            return false;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
