### 게임 과정
1. 게임 시작
2. 숫자 입력
3. 힌트 출력
4. 2 ~ 3번 과정 반복
   - 힌트 출력이 `3 스트라이크`이면, 새로 시작(1) or 종료(2) 입력
     - 새로 시작(1) : `2번`으로 이동
     - 종료(2) : 게임 종료

### 클래스 기능
- `Application` : 게임 시작 (1번 역할)
- `Exception` : 입력값이 올바른지 예외처리 (2번 역할)
- `GameController` : 게임 진행 (4번 역할)
- `GameTool` : 입력값에 따른 힌트 계산 & 랜덤 숫자 생성 (3번 역할)
- `PrintMessage` : 콘솔창에 문구 출력 


### 메소드 설명
- 📂 *Exception*
  - `isValid()` : 아래의 모든 예외처리 메소드를 실행한다. 예외가 발생하지 않는다면 String 입력을 List<Integer>로 반환한다.
  - `inRange()` : 문자열 입력이 1~9 인 숫자인지 확인한다.
  - `checkDuplicate()` : 숫자 중 중복이 없는지 확인한다.
  - `checkCount()` : 숫자 개수가 3개인지 확인한다.
  - `convertStringToIntList()` : 문자열을 List<Int>로 변환한다.  


- 📂 *GameController*
  - `start()` : 게임 시작 메소드. 게임 시작 문구를 출력하고 status가 1이라면 gaming 메소드를 계속해서 실행한다.
  - `gaming()` : 게임 진행 메소드. 숫자 입력과 힌트 출력을 반복한다. 만약 3스트라이크가 나온다면 반복이 끝나고 메소드가 종료된다. 그 후 유저의 입력(종료 여부)을 status 변수에 할당한다.


- 📂 *GameTool*
  - `generatedRandomNumbers()` : 게임에서 사용되는 랜덤 숫자를 세개 생성한다. 숫자의 범위는 1~9이다.
  - `countStrike()` : 유저 입력과 정답 숫자(랜덤 숫자)를 비교해서 스트라이크 개수를 반환한다.
  - `countBall()` : 볼 개수를 반환한다.
  - `isNothing()` : 낫싱일 경우 true, 아닐 경우 false를 반환한다.


- 📂 *PrintMessage*
  - `start()` : "숫자 야구 게임을 시작합니다." 문구를 출력한다.
  - `requestNumber()` : "숫자를 입력해주세요 : " 문구를 출력한다.
  - `hint()` : strike, ball 개수와 nothing 여부를 파라미터로 받아 힌트 결과를 출력한다.
  - `gameEnd()` : 게임 종료 문구와 새로 시작 or 종료 입력 문구를 출력한다.