## 1. Application

- main()
    - 숫자 야구 게임 시작
- boolean checkEnd()
    - 숫자 야구 한판이 끝난 후 재시작할지 종료할지 판단하는 메서드
    - **_InputValidation_** 를 이용해 사용자 입력 검사

## 2. BaseballGame

- BaseballGame 싱글톤 객체로 관리
- void play()
    - 싱글톤 객체의 playing() 메서드 호출
- void playing()
    - 실제 게임 진행 로직
    - 컴퓨터 숫자 세팅 -> 사용자 숫자 세팅 -> 숫자 비교 -> 결과 출력 -> 정답 확인
- List setComputerNumber()
    - 컴퓨터 숫자 중복 검사 및 세팅 후 List로 반환
    - Randoms.pickNumberInRange() 사용
- List setUserNumber()
    - 사용자 숫자 세팅 후 List로 반환
    - **_InputValidation_** 를 이용해 사용자 입력 검사
- Result compareNumber(List, List)
    - 컴퓨터의 숫자 List, 사용자 숫자 List를 파라미터로 전달
    - 컴퓨터의 숫자와 사용자 숫자를 비교하는 메서드
    - 같은 숫자가 있을 때 자리도 같으면 스트라이크 개수 증가, 자리가 다르면 볼 개수 증가
    - 스트라이크 개수와 볼 개수가 담긴 **_Result_** 객체 반환

## 3. Constant

- 상수 전용 클래스
- RESTART_NUMBER: "1"
- END_NUMBER: "2"
- NUMBER_LENGTH : 게임 진행 시 숫자 길이(3)

## 4. InputValidation</h2>

- 입력 예외 처리용 객체
- void checkUserNumber(String)
    - 게임 중 숫자 입력 예외 체크
    - 정규 표현식 활용(1부터 9까지의 서로 다른 3개의 숫자)
- void checkRestartNumber(String)
    - 게임 종료 후 재시작 여부 확인 숫자 입력 예외 체크
    - 정규 표현식 활용(1 또는 2)

## 5. Result

- ball, strike 변수를 위한 DTO
- boolean isNothing(): 스트라이크, 볼 둘 다 0이면 true 반환
- boolean isCorrect(): 3스트라이크(정답)이면 true 반환
- void print()
    - result에 들어있는 ball, strike 개수를 요구사항에 맞춰 출력
    - StringBuilder 사용
