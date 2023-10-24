# java-Baseball 게임 구현

### 🕹 구현 전 예외에 대한 고민 
1. 3자리가 아닐 경우 -> 예외
2. 0이 들어간 숫자 -> 예외
3. 재시작과 종료 시 입력값 1, 2 아닌 경우 -> 예외
---
### 🎮 컴퓨터 기능 구현
1. computerRanNumList() : 컴퓨터의 랜덤 야구 숫자 생성
   * return : List<Integer>
   * 게임 시작, 게임 재시작 시 호출 
----
### 😀 사용자 기능 구현
1. userInputNumList() : 사용자의 입력 숫자 List로 생성
   * return : List<Integer>
   * String을 split 메쏘드로 나눈 뒤에 List에 차례대로 넣는다.
   * 예외함수  : checkLength, checkZero


2. checkLength() : 사용자의 입력 값의 길이가 3인지 체크하는 함수
   * return : boolean
   * 3이 아닐 경우 IllegalArgumentException 발생 후, "3개의 숫자를 입력하세요." 문구 출력


3. checkZero() : 사용자의 입력 값이 0이 있는지 체크하는 함수
   * return : boolean
   * 0이 아닐 경우 IllegalArgumentException 발생 후, "1부터 9사이의 숫자만 입력하세요." 문구 출력
---
### ⚾️ 야구게임 기능 구현
1. checkAgainGame() : 재시작 혹은 종료를 해주는 함수
   * return : boolean
   * inGame(초기값 : true)이라는 boolean을 만들어서 종료 시 false return, 재시작 시 true return.
   

2. strikeCnt() : strike를 카운트해주는 함수
   * return : int


3. inListCnt() : 컴퓨터와 사용자의 리스트에 같은 숫자가 있는지 체크 해주는 함수 
   * return : int
   * strikeCnt - inListCnt 를 빼면 ball의 개수를 확인할 수 있다.

4. printScore() : 게임 결과를 출력해주는 함수
   * void
 
