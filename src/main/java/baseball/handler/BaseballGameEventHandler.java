package baseball.handler;

import baseball.info.BaseballGameInfo;
import camp.nextstep.edu.missionutils.Randoms;


/**
 * 야구게임 진행을 위한 이벤트들을 구현한 핸들러
 */
public class BaseballGameEventHandler {

    // 야구게임 정보 객체 생성 필드
    BaseballGameInfo info = new BaseballGameInfo();

    // computer의 랜덤 값을 담아둘 StringBuilder 필드
    StringBuilder computer;

    // computer의 랜덤 값 설정 메소드
    public void setComputerNumber(){
        // 컴퓨터 StringBulider 객체 재생성 - 게임을 재시작했을 경우 기존 값을 지워주기 위함
        computer = new StringBuilder();

        // 컴퓨터의 랜덤 값을 골라서 StringBuilder에 넣는 과정
        while(computer.length() < 3){
            info.setRandomNumber(Integer.toString(Randoms.pickNumberInRange(1, 9)));
            if (!computer.toString().contains(info.getRandomNumber())) {
                computer.append(info.getRandomNumber());
            }

        }

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 진행 메소드 - 사용자의 입력값을 받아 Strike와 Ball 값을 기록한다.
    public void progressGame(){

        System.out.println("숫자를 입력해주세요 : ");
        // 사용자가 입력하는 야구게임 숫자
        info.setBaseballNum(info.getInput().nextLine().trim());

        // 예외처리 - 입력 길이가 3이 아니거나 입력값이 숫자로 변환되지 않는 경우 IllegalArgumentException 예외 처리
        if (info.getBaseballNum().length() != 3 || !info.getBaseballNum().chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        // 사용자의 입력값과 컴퓨터의 값을 비교해서 Strike와 Ball 값을 설정
        for (int i = 0; i < computer.length(); i++) {
            for (int j = 0; j < info.getBaseballNum().length(); j++) {
                if (computer.charAt(i) == info.getBaseballNum().charAt(j)) {
                    if (i == j) {
                        info.setStrike(info.getStrike()+1);
                    } else {
                        info.setBall(info.getBall()+1);
                    }
                }
            }
        }

    }


    // 사용자의 Strike 값과 Ball 값을 검증하는 메소드
    public void validate(){

        // Ball 값과 Strike 값을 점검하여, 해당 값들을 출력하는 검증 과정
        if(info.getBall() == 0 && info.getStrike() == 0) {
            System.out.println("낫싱");
        }else if (info.getStrike() == 0) {
            System.out.println(info.getBall() + "볼");
        }else if (info.getBall() == 0) {
            System.out.println(info.getStrike() + "스트라이크");
        }else {
            System.out.println(info.getBall() + "볼 " + info.getStrike() + "스트라이크");
        }

        // Strike 값이 3인경우 게임이 종료되므로, 해당 내용을 추가 출력함
        if(info.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }


    // 게임 재시작 여부를 결정하는 메소드
    public void gameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        // 게임 재시작 여부를 입력받는 과정
        info.setSelect(info.getInput().nextLine().trim());

        // 예외처리 - 입력 값이 숫자로 변환되지 않는 경우
        if(!info.getSelect().chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException();
        }


        // 예외처리 - 입력 값이 1이나 2가 아닌 경우
        if(!info.getSelect().equals("1") && !info.getSelect().equals("2")){
            throw new IllegalArgumentException();
        }

        // 게임 재시작
        if(info.getSelect().equals("2")) {
            info.setGameEnding(true); // 게임 종료
        }

    }


    // 설정 Ball 값과 Strike 값을 초기화하는 메소드
    public void reset(){
        info.setBall(0);
        info.setStrike(0);
    }

    // Strike 점수를 반환하는 메소드
    public int score(){
        return info.getStrike();
    }

    // 게임 종료 여부를 반환하는 메소드
    public boolean end(){
        return info.getGameEnding();
    }


}
