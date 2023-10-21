## 흐름에 따른 기능 이해
1. 게임시작
   1. 숫자 야구 게임을 시작합니다를 출력 후 자동으로 camp.nextstep.edu.missionutils randoms값을 이용하여
      ComputerNumber(3자리 난수)을 생성해준다.
   2. (1-9) 3자리 숫자를 입력한다 -> 정답 맞출 때까지 반복한다
      i. 사용자가 입력한 숫자가 유효한 숫자인지 확인
         - 세 자리
         - 숫자인지 
         - 서로 다른 숫자인지
           (이 과정에서 사용자가 잘못된 값을 입력할 경우)
      ii. 정답인지 확인
         - ComputerNumber(3자리 난수)랑 비교하여 확인(동일한지)
   3. 정답이 아니라면 플레이어에게 힌트를 제공한다
      i. 같은 수가 같은 자리 -> 스트라이크
      ii. 같은 수 다른 자리 -> 볼
      iii. 같은 수가 전혀 없으면 -> 낫싱
   4. 게임을 맞히면 게임이 종료된다
      i. 사용자가 1입력 -> 게임을 다시 시작
      ii. 사용자가 2입력 -> 완전히 종료

## 수행 기능 정리
1. Model
   i. PlayerNumber
   ii. ComputerNumber
2. View
   i. OutputView
      - [] 숫자 야구 게임 시작 메시지 출력
      - [] 성공메시지 및 게임종료 메시지
      - [] 힌트 메시지
   ii. InputView
      - [] 사용자가 숫자입력하는 View
      - [] 재시작 아니면 끝내는 View
3. Controller
   i. GameController
      - [] 게임시작 메시지 출력하고 BaseBallControll연결 시키기
      - [] PlayerNumber와 GameNumber가 동일할 때까지 반복
      - [] 게임이 끝나면 InputView에서 재시작 아니면 끝내는 View 사용하기
   
   ii. BaseBallController
      - [] 스트라이크, 볼 변수 0으로 초기화
      - [] 난수 생성 후 ComputerNumber에 저장
      - [] 게임 시작 사용자에게 알리기
      - [] 사용자가 입력한 PlayerNumber와 GameNumber가 동일한지 비교하기
      - [] 힌트 
        - [] 같은 수 같은 자리: 스트라이크
        - [] 같은 수 다른 자리: 볼
        - [] 같은 수가 아예 없으: 낫싱
        - [] 모두 맞음: 3개의 숫자를 모두 맞히셨습니다!를 출력
   
   iii. NumberValidator
      - [] PlayerNumber의 유효성 검사
        - [] IllegalArgumentException 발생 후 종료
        - [] 세자리
        - [] 1~9사이 숫자
        - [] 3자리 모두 다 다른 숫자
   iV. RandomUtil
        - [] 1~9사이 난수 생성
        - [] 세자리 모두 다 다른 숫자
        - [] ComputerNumber이랑 연결
