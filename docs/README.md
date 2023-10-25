문제 출제
1부터 9까지 서로 다른 임의의 수로 이루어진 3자리의 수가 생성된다
문제 풀기
숫자를 입력해주세요 :  가 콘솔에 출력된다
사용자로부터 서로 다른 3자리의 수를 입력 받는다
잘못 입력된 경우 IllegalArgumentException을 발생시키고 애플리케이션을 종료시킨다
정상 입력된 경우 입력에 따른 결과를 판정한다
1볼 1스트라이크 와 같이 볼과 스트라이크 갯수를 표기한다
하나도 맞추지 못했을 때에는 낫싱 을 표기한다
정답 이후 처리
정답을 맞췄을 때에는 3스트라이크에 추가로 게임 종료 메시지 출력 및 재시작 분기를 시작한다

* 구현메서드

Main : 게임 플레이 시작

checkValues(String[] values, List<Integer> number)
: Console로 입력받은 값들의 유효성검사를 하는 메서드
숫자형식인지, 3자리 숫자 인지 아닌지에 대해 IllegalArgumentException을 발생시킨다.

boolean replay()
: 게임 재시작여부에대해 Console로 입력받은 값에 따라 다시 실행할지 결정

void printCnt(int ballCnt, int strikeCnt)
: 스트라이크, 볼 횟수에 따라 출력을 하는 함수

void generateComputer(List<Integer> computer)
: 랜덤난수를 통해 1부터 9까지 중복되지않는 수를 생성하는 매서드
