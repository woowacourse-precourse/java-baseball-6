package baseball;

import java.util.ArrayList;

public class Game {
    private Computer computer = new Computer();
    private User user = new User();
    Game(){
    }

    public void printStartMessage(){ //게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void startGame(){ //숫자 야구 게임을 시작하는 메소드
        this.computer.setNumbers(); //컴퓨터의 숫자 정하기
        while(true){ //종료 조건 : 3스트라이크
            System.out.print("숫자를 입력해주세요: ");
            this.user.setGuessNumber(); //플레이어의 숫자 입력 받기
            int[] strikeAndBall = this.checkNumber(); //strikeAndBall[0]: 스트라이크, strikeAndBall[1]: 볼
            if(strikeAndBall[0]==3){ //3스트라이크: 반복문 종료 조건
                //종료 멘트 출력
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else if(strikeAndBall[0]+strikeAndBall[1]!=0){ //스트라이크와 볼이 둘다 0이 아닌 경우
                if(strikeAndBall[1]!=0){//볼이 0이 아닐 때 개수 출력
                    System.out.printf("%d볼 ", strikeAndBall[1]);
                }
                if(strikeAndBall[0]!=0){//스트라이크가 0이 아닐 시 개수 출력
                    System.out.printf("%d스트라이크",strikeAndBall[0]);
                }
                System.out.println(); //줄바꿈
            } else{ //둘 다 0인 경우
                System.out.println("낫싱");
            }
        }
    }

    private int[] checkNumber(){ //컴퓨터의 숫자와 플레이어가 입력한 숫자를 비교하여 스트라이크와 볼의 개수를 리턴하는 메소드
         int [] strikeAndBall = {0,0}; // 0번째 인덱스: 스트라이크, 1번째 인덱스: 볼

        ArrayList<Integer> comp = this.computer.getNumbers(); //컴퓨터의 숫자
        ArrayList<Integer> player = this.user.getNumbers(); //유저가 입력한 숫자

        for(int i=0;i<comp.size();i++){
            for(int j=0;j<player.size();j++){
                if(comp.get(i).equals(player.get(j))){
                    if(i==j){ //컴퓨터와 유저의 숫자가 서로 같고 위치도 같다면 스트라이크
                        strikeAndBall[0]++;
                    } else{ //값만 서로 같으면 볼
                        strikeAndBall[1]++;
                    }
                }
            }
        }
        return strikeAndBall;
    }

}
