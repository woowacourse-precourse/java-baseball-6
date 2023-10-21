프로그램 동작 흐름
===

1. 프로그램 시작
   1) 
            숫자 야구 게임을 시작합니다.
   2) 컴퓨터가 중복되지 않는 랜덤 숫자 3개 생성


2. 플레이어 입력
   1)
            숫자를 입력해주세요 : 
   2) 숫자인지 검증
   3) 숫자가 3개인지 검증
   4) 숫자가 서로 중복되지 않는지 검증
   

3. 플레이어 입력과 컴퓨터 생성 숫자 비교
   1) 전부 맞는지 비교
   2) 볼 계산
   3) 스트라이크 계산
   4) 낫싱 계산


4. 결과 처리
   1) 3-1의 경우
      1)
   
              3개의 숫자를 모두 맞히셨습니다! 게임 종료
              게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
      2) 숫자를 하나를 입력받음
         - 숫자인지 검증
         - 하나의 숫자인지 검증
      3) 숫자에 따라 아래와 같이 실행
         
         - 1의 경우 : 1-2번 부터 다시 실행
         - 2의 경우 : 프로그램 종료

   2) 3-2의 경우
      1) 3-2,3,4를 기반으로 힌트를 출력 

             1볼 1스트라이크
      2) 2-1번 부터 다시 실행

---

---
MVC에 의한 분류
==
## Model
__GameData__
- [x] computerNumber (컴퓨터가 생성한 난수 저장)
- [x] playerInput (플레이어가 입력한 숫자 저장)
- [x] ballCount (볼 수치 저장)
- [x] strikeCount (스트라이크 수치 저장)


## View
__InputView__
- [x] printNumberRequest (플레이어 입력안내 메시지 출력)

         숫자를 입력해주세요 : 
- [x] printGameEnd (게임 종료 확인 메시지 출력)

         3개의 숫자를 모두 맞히셨습니다! 게임 종료
         게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

__OutputView__
- [x] printGameStart (프로그램 첫 실행 메시지 출력)

            숫자 야구 게임을 시작합니다.
- [x] printHint (힌트 메시지 생성 후 출력)

             1볼 1스트라이크

## Controller
__Validator__


- [x] validatePlayerInput (플레이어의 입력을 검증)
   1) 숫자인지 검증
   3) 숫자가 3개인지 검증
   4) 숫자가 서로 중복되지 않는지 검증


- [x] validateEndInput (게임종료 후 1,2입력 검증)
  1) 1혹은 2인지 검증

__RandomNumberGenerator__
- [x] generateNumbers (중복되지 않는 3개의 난수 생성)
  1) 1-9범위의 숫자를 랜덤으로 생성
  2) 중복되지 않는지 검증한 뒤 computerNumber에 추가

__Comparator__
- [x] countStrikes
    * 위치가 같지 않으면서 숫자는 포함되어 있다면 스트라이크+1하고 스트라이크 숫자 반환
- [x] countBalls
    * 위치가 같으면서 숫자도 같다면 볼+1하고 볼 숫자 반환
- [x] isNothing
    * computerNumber와 playerInput가 하나도 안겹치면 낫싱true
- [x] isEndGame
    * computerNumber와 playerInput가 모두 일치하면 true

__PlayerInputController__
- [x] handlePlayerInput
  * 사용자 입력의 공백을 제거
  * validatePlayerInput에 넣고 Arraylist를 생성한 후 값을 넣고 반환

  
__MainController__

private static int state = 1;

private static int count = 0;

2. [ ] playGame
    - state가 1일때만 루프
    - count가 0이라면 generateNumbers호출
    - processInpuntAndComperate 호출
      
   

3.[ ]  processInputAndCompare
    - inputView.printNumberRequest호출
    - 사용자 입력받아 playerFirstInput변수에 저장
    - handlePlayerInput으로 사용자 입력 변환
    - 모델에 사용자 입력 저장
   

3. [ ] checkReplay
    - 전부 맞았으니 3스트라이크가 표시되게 printHint호출 후 printGameEnd호출
    - endNumber를 입력받고 validateEndInput에서 검증
    - 1이면 State를1로 유지해 설정된 while문에 따라 게임 재시작, 2면 게임종료


4. [ ] processComperater
    - compartaor를 이용해 낫싱,볼,스트라이크 계산 후 변수에 저장
    - 각 해당하는 힌트 출력






