<h2>1. Application</h2>
- main()
   - 숫자 야구 게임 시작
   - 게임이 끝난 경우 재시작/종료를 구분하는 숫자 입력 시 예외 발생

<h2>2. BaseballGame</h2>
- BaseballGame 싱글톤 객체로 작성
- play()
  - 실제 숫자 야구 로직 들어 있음
- setComputerNumber()
  - 컴퓨터 숫자 세팅
- setMyNumber()
  - 내 숫자 세팅
- compareNumber(List, List)
  - 컴퓨터의 숫자와 내 숫자 비교
- Result
  - ball, strike 개수가 들어 있는 객체
- printResult(Result)
  - result에 들어있는 ball, strike 개수를 요구사항에 맞춰 출력
    
<h2>3. MistakeChecker</h2>
- 입력 예외 처리용 객체
- MistakeChecker 싱글톤 객체로 작성
- checkMyNumber(String input)
  - 게임 중 숫자 입력 예외 체크
- checkAndMakeList(String input)
  - 예외 체크 후 사용자 입력 리스트 생성 및 반환
- checkRestartNumber(String input)
  - 게임 종료 후 재시작 여부 확인 숫자 입력 예외 체크
- checkAndMakeNumber(String input)
  - 예외 체크 후 재시작 여부 확인 숫자 생성 및 반환

<h2>4. Result</h2>
- ball, strike 변수를 위한 DTO