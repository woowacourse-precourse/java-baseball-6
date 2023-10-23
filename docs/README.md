## 기능 목록 정의
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
    <td>setNumbers()</td>
    <td>설정자</td>
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
    <td>clearBoard()</td>
    <td>스코어 보드 초기화</td>
    <td>현재 스코어를 기록할 점수판 초기화</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>isStrike()</td>
    <td>스트라이크 개수 확인 함수</td>
    <td>몇개의 숫자가 스트라이크인지 점수판에 기록하는 함수</td>
  <tr>
    <td></td>
    <td></td>
    <td>isBall()</td>
    <td>볼 개수 확인 함수</td>
    <td>몇개의 숫자가 볼인지 점수판에 기록하는 함수</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>getNumbers()</td>
    <td>Getter</td>
    <td>컴퓨터가 선택한 숫자 확인</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>checkScore()</td>
    <td>최종점수 확인 함수</td>
    <td>isStrike(), isBall()을 이용하여 최종점수 확인 후 출력하기</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>getNumbers()</td>
    <td>Getter</td>
    <td>컴퓨터가 선택한 숫자 확인</td>
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
    <td>validUserCommand()</td>
    <td>재시작/종료 커맨드 유효성 검사하는 함수</td>
    <td>validateNumber() 호출 후, 사용자의 입력이 1 또는 2인지 확인 나머지는 에러 처리</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>validUserNumber()</td>
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

## 제공 라이브러리 함수 분석
### Randoms
<table>
  <tr style="background-color: green; color:white">
    <th>No</th>
    <th>함수 이름</th>
    <th>함수 설명</th>
  </tr>
  <tr>
    <td>01</td>
    <td>validateRange</td>
    <td>시작 지점이 끝지점보다 큰지 확인, 끝 지점이 MAX_VALUE인지, 입력 범위가 너무 크지 않은지 확인 후 문제가 있을 경우 에러 발생, 그렇지 않을 경우 패스</td>
  </tr>
  <tr>
    <td>02</td>
    <td>pickNumberInRange</td>
    <td>validateRange() 함수 호출을 통한 유효성 검사, startInclusive ~ endInclusive 사이의 무작위 정수값 반환</td>
  </tr>
  <tr>
    <td>03</td>
    <td>validateRange</td>
    <td>매개변수로 받은 Integer 리스트가 비었는지 확인 후 비었다면 에러 발생 비어있지 않을 경우 패스</td>
  </tr>
  <tr>
    <td>04</td>
    <td>validateRange</td>
    <td>validateNumbers() 함수 호출을 통한 유효성 검사, 매개변수로 받은 Integer 리스트 내에서 랜덤하게 숫자를 선택하여 반환하는 함수</td>
  </tr>
  <tr>
    <td>05</td>
    <td>validateRange</td>
    <td>count가 음수이면 에러 발생, 랜덤값을 뽑고자 하는 범위의 원소 개수(end-start+1)가 요청하는 count보다 작을 경우 에러 발생</td>
  </tr>
  <tr>
    <td>06</td>
    <td>validateRange</td>
    <td>매개변수로 받은 리스트의 숫자들을 무작위로 섞은 후 섞은 리스트를 반환</td>
  </tr>
  <tr>
    <td>07</td>
    <td>validateRange</td>
    <td>validateRange, validateCount를 통해 유효성 검사, 시작 지점~끝지점 내에서 count 만큼의 숫자를 뽑아 리스트로 반환하는 함수</td>
  </tr>
</table>