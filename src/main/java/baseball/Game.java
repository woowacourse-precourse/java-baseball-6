package baseball;
public class Game {
    static final int NumberLength = 3;
    static final String REGAME = "1";
    static final String EXIT = "2";
    int strikes; // 스트라이크 개수
    int balls; // 볼 개수
    static boolean correct; //정답 유무
    String answerNumber; // 정답 숫자
    String inputNumber; // 사용자가 입력한 숫자
    Numbers numbers = new Numbers();
    Msg msg = new Msg();

    // 게임을 시작하는 메소드
    void startGame(){
        msg.printMsg(msg.STARTING_Msg);// 시작 메시지 출력
        answerNumber = Numbers.listToNumber(numbers.drawNumber()); // 랜덤번호 추첨
        correct = false; // 정답 유무를 못맞춘 것으로 초기화
        while (!correct){ // 아직 정답을 맞추지 못했을 때 반복
            msg.printMsg(msg.INPUT_Msg); // 입력 메시지 출력
            inputNumber = numbers.getNumber(); //사용자에게 숫자를 입력받기
            countStrikes(); // 스트라이크 개수 세기
            countBalls(); // 볼 개수 세기
            correct = caluateResult();
        }
    }

    // 스트라이크 개수를 세는 메소드
    void countStrikes(){
        strikes = 0; // 스트라이크 개수 초기화
        for (int i = 0; i < NumberLength; i++){
            if (inputNumber.charAt(i) == answerNumber.charAt(i))
                strikes++; // 스트라이크 개수 증가
        }
    }

    // 볼 개수를 세는 메소드
    void countBalls(){
        balls = 0; //볼 개수 초기화
        for (int i = 0; i < NumberLength; i++){
            for(int j = 0; j < NumberLength; j++){
                if ((i != j) && (balls <= 3) && (inputNumber.charAt(i) == answerNumber.charAt(j))){// 자리가 다르지만 같은 수가 있으면
                    balls++; // 볼 개수 증가
                }
            }
        }
    }

    // 재게임 의사를 판별하는 메소드
    boolean doRegame(){
        String regameInput =  camp.nextstep.edu.missionutils.Console.readLine();
        if(regameInput.equals(REGAME)){// 게임을 다시 하기를 원하는 경우
            return true;
        }else if (regameInput.equals(EXIT)){// 게임에서 나가기를 원하는 경우
            return false;
        }else throw new IllegalArgumentException("비정상적인 값을 입력하셨습니다. 게임을 자동으로 종료합니다."); //비정상적인 값인 경우 -> 오류처리
    }

    // 점수를 계산하는 메소드
    boolean caluateResult(){
        if(strikes + balls != 0){
            if (strikes == 3){// 정답인 경우
                msg.printOneCase(strikes, msg.STRIKE);
                 msg.printMsg(msg.ENDING_Msg);
                 return true;
            } else if (strikes == 0 || balls == 0) { // 볼만 있거나 스트라이크만 있는 경우
                if(balls == 0) { //스트라이크만 있는 경우 메시지 출력
                    msg.printOneCase(strikes, msg.STRIKE); 
                }else msg.printOneCase(balls, msg.BALL); //볼만 있는 경우 메시지 출력
            }else msg.printTwoCase(balls, strikes); // 볼과 스트라이크가 모두 있는 경우
        }else {// 낫싱인 경우
            msg.printMsg(msg.NOTHIG);
        }
        return false;
    }
}
