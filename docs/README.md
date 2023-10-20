<h2>1. Application</h2>
- main()
   - 숫자 야구 게임 시작
   - 게임이 끝난 경우 재시작/종료를 구분하는 숫자 입력 시 예외 발생

<h2>2. BaseballGame</h2>
- BaseballGame 싱글톤 객체로 관리
- play()
  - 실제 숫자 야구 로직 들어 있음
- endCheck()
  - 숫자 야구 한판이 끝난 후 재시작할지 종료할 지 판단하는 메서드
- setComputerNumber()
  - 컴퓨터 숫자 세팅
  - checkDuplicationAndSetNumber(List<Integer> computer, int randomNumber)
    - 컴퓨터 숫자 중복 검사 후 세팅 
- setMyNumber()
  - 내 숫자 세팅
- compareNumber(List, List)
  - 컴퓨터의 숫자와 내 숫자 비교
- printResult(Result)
  - result에 들어있는 ball, strike 개수를 요구사항에 맞춰 출력
- isMyNumberCorrect(Result result)
  - result가 3스트라이트면 게임을 종료할 수 있도록 true 반환

<h2>3. Constant </h2>
- 상수 전용 클래스
- RESTART_NUMBER: 1
- END_NUMBER: 2
- RESTART_OR_END_INPUT_LENGTH: 게임 완료 후 재시작 or 게임 종료 여부 결정 시 입력 숫자 길이(1)
- MY_NUMBER_INPUT_LENGTH : 게임 진행 시 숫자 길이(3)

<h2>4. InputChecker</h2>
- 입력 예외 처리용 객체
- InputChecker 싱글톤 객체로 관리
- checkMyNumber(String input)
  - 게임 중 숫자 입력 예외 체크
- checkAndMakeList(String input)
  - 예외 체크 후 사용자 입력 리스트 생성 및 반환
- checkRestartNumber(String input)
  - 게임 종료 후 재시작 여부 확인 숫자 입력 예외 체크
- checkAndMakeNumber(String input)
  - 예외 체크 후 재시작 여부 확인 숫자 생성 및 반환

<h2>5. Result</h2>
- ball, strike 변수를 위한 DTO