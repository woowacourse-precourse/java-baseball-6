## 요구 사항 명세서(SRS)
- 참고 블로그 : [기능 명세서](https://velog.io/@pengoose_dev/%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-%EA%B8%80%EC%93%B0%EA%B8%B0-1-%EA%B8%B0%EB%8A%A5%EB%AA%85%EC%84%B8%EC%84%9C)
1. 어떤 기능들이 있는가?
    - [X] 사용자(User)로부터 숫자를 입력받는다.
    - [X] 컴퓨터(Computer)는 무작위 3자리 숫자를 생성한다.
    - [X] 사용자의 입력과 컴퓨터가 무작위로 생성한 숫자를 보며 스트라이크(Strike)/볼(Ball)/낫싱(Nothing)을 판단한다.
    - [X] 3 스트라이크일 경우 재시작(1)/종료(2) 커맨드를 입력받는다.
    - [X] 볼만 발생한 경우 볼에 대한 출력만 한다.(Ex. 3볼)
    - [X] 스트라이크만 발생한 경우 스트라이크에 대한 출력만 한다.(Ex. 2스트라이크)
    - [X] 볼과 스트라이크가 동시에 발생한 경우 볼, 스트라이크 순으로 출력한다.(Ex. 2볼 1스트라이크)
    - [X] 사용자가 잘못된 입력을 할 시 `IlleganargumentExeption`을 발생시킨다.
      - 1. 입력에 문자가 포함되어 있을 경우
      - 2. (글자수) > 3 또는 (글자수) < 3일 경우
      - 3. 중복된 숫자를 입력할 경우 (Ex. 443)

2. 어떤 객체들로 이루어져있는가?
    - `[BaseballGame]: 게임 객체`
      - [X] 게임을 실행한다.
      - [X] 사용자의 입력을 받아 유효성 검사를 요청한다.
      - [X] 사용자의 입력에 대해 점수판별 요청을 한다.
    - `[Computer]: 컴퓨터 객체`
      - [X] 무작위 3자리 숫자를 생성한다.
    - `[User]: 사용자 객체`
      - [X] 자신이 선택한 3자리 숫자를 설정한다.
    - `[Score]: 점수판 객체`
      - [X] 스트라이크의 개수를 세어본다.
      - [X] 볼의 개수를 세어본다.
      - [X] 최종 점수를 계산한다.
    - `[ValidationCheck]: 유효성 검사 객체`
      - [X] 입력에 문자가 포함되어 있는지 유효성 검사를 한다.
      - [X] 글자수가 3자리 초과 또는 3자리 미만인지 확인한다.
      - [X] 서로 다른 3자리가 아닌지 확인한다.

3. 어떻게 상호작용하는가?
   - `[BaseballGame]: 게임 객체`
     - [X] Computer에게 무작위 3자리 숫자 생성을 요청한다.
     - [X] 입력받은 숫자의 유효성 검사를 위해 ValidationCheck 객체에 요청한다.
     - [X] 유효성 검사 통과 후 사용자가 입력한 숫자를 User 객체에 저장한다.
     - [X] Score에게 점수 계산을 요청한다.

---
## 기능 목록 테이블
<table>
  <tr style="background-color: green; color:white">
    <th>No
    <th>클래스 이름</th>
    <th>함수 이름</th>
    <th>기능 이름</th>
    <th>기능 설명</th>
  </tr>
  <tr>
    <td>01</td>
    <td>BaseballGame</td>
    <td>run()</td>
    <td>게임 실행 함수</td>
    <td>전반적인 게임 실행을 위한 함수. 게임 시작 문구 출력후 사용자 입력받기</td>
  </tr>
   <tr>
    <td></td>
    <td></td>
    <td>replay()</td>
    <td>게임 재실행 함수</td>
    <td>run() 함수에서 재실행 요청시 호출되는 함수</td>
  </tr>
  <tr>
    <td>02</td>
    <td>Computer</td>
    <td>Computer()</td>
    <td>생성자</td>
    <td>Computer 객체 생성을 위한 생성자</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>getNumbers()</td>
    <td>접근자</td>
    <td>컴퓨터가 선택한 숫자 확인</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>clearNumbers()</td>
    <td>컴퓨터 숫자 초기화</td>
    <td>컴퓨터가 선택한 숫자 초기화</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>generateNumbers()</td>
    <td>무작위 숫자 선택 함수</td>
    <td>제공되는 Randoms를 이용하여 무작위 3가지 숫자 선택하기</td>
  </tr>
  <tr>
    <td>03</td>
    <td>User</td>
    <td>User()</td>
    <td>생성자</td>
    <td>User 객체 생성을 위한 생성자</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>getNumbers()</td>
    <td>접근자</td>
    <td>사용자가 선택한 숫자 확인</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>generateNumbers()</td>
    <td>사용자 입력 설정 함수</td>
    <td>사용자가 입력한 숫자 설정하는 함수</td>
  </tr>
  <tr>
    <td>04</td>
    <td>Score</td>
    <td>Score</td>
    <td>생성자</td>
    <td>Score 객체 생성을 위한 생성자</td>
  <tr>
    <td></td>
    <td></td>
    <td>clearScoreBoard()</td>
    <td>스코어 보드 초기화</td>
    <td>현재 스코어를 기록할 점수판 초기화</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>countStrikes()</td>
    <td>스트라이크 개수 확인 함수</td>
    <td>몇개의 숫자가 스트라이크인지 점수판에 기록하는 함수</td>
  <tr>
    <td></td>
    <td></td>
    <td>countBalls()</td>
    <td>볼 개수 확인 함수</td>
    <td>몇개의 숫자가 볼인지 점수판에 기록하는 함수</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>checkScore()</td>
    <td>최종점수 확인 함수</td>
    <td>countStrikesAndBalls()를 호출하여 카운팅한 후 최종점수 확인 후 적절한 출력하기</td>
  </tr>
   <tr>
    <td></td>
    <td></td>
    <td>countStrikesAndBalls()</td>
    <td>스트라이크와 볼의 개수를 모두 세어주는 함수</td>
    <td>countStrikes(), countBalls()을 이용하여 스트라이크, 볼의 개수 모두 확인하는 함수</td>
  </tr>
  <tr>
    <td>05</td>
    <td>ValidationCheck</td>
    <td>validateNumber()</td>
    <td>특정 문자열이 숫자인지 유효성 검사하는 함수</td>
    <td>매개변수로 넘겨받은 문자열이 숫자인지 확인하는 함수. 숫자가 아니라면 IllegalArgumentExeption 발생</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>validateUserCommand()</td>
    <td>재시작/종료 커맨드 유효성 검사하는 함수</td>
    <td>validateNumber() 호출 후, 사용자의 입력이 1 또는 2인지 확인 나머지는 에러 처리</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>validateUserNumber()</td>
    <td>=사용자 입력이 숫자인지 확인하는 함수</td>
    <td>validateNumber() 호출 후, 컴퓨터가 선택한 숫자가 3자리인지 확인 나머지는 에러 처리</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>validateDuplicate()</td>
    <td>사용자 입력 숫자에 중복된 숫자가 있는지 유효성 검사하는 함수</td>
    <td>사용자 입력 중 중복된 숫자가 있는지 확인한 후 중복된 것이 있으면 에러 처리</td>
  </tr>
  <tr>
    <td>06</td>
    <td>GameState</td>
    <td>ENUM 타입 클래스</td>
    <td>게임 상태에 대한 상수 정의</td>
    <td>RUNNING(실행 상태)와 EXIT(종료 상태) 정의</td>
  </tr>
</table>