# java-Baseball 게임 구현

### 🕹 구현 전 예외에 대한 고민 


### 🎮 게임 기능 구현
1. computerRanNumList() : 컴퓨터의 랜덤 야구 숫자 생성
   * return : List<Integer>
   * 게임 시작, 게임 재시작 시 호출 
----
### 😀 사용자 기능 구현
1. userInputNumList() : 사용자의 입력 숫자 List로 생성.
   * return : List<Integer>
   * String을 split 메쏘드로 나눈 뒤에 List에 차례대로 넣는다.
   * 예외함수  : checkLength, checkZero


2. checkLength() : 사용자의 입력 값의 길이가 3인지 체크하는 함수.
   * return : boolean
   * 3이 아닐 경우 IllegalArgumentException 발생 후, "3개의 숫자를 입력하세요." 문구 출력


3. checkZero() : 사용자의 입력 값이 0이 있는지 체크하는 함수.
   * return : boolean
   * 0이 아닐 경우 IllegalArgumentException 발생 후, "1부터 9사이의 숫자만 입력하세요." 문구 출력
---


