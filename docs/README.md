# 구현할 기능 

1. 서로 다른 임의의 수(1에서 9까지) 3개를 선택하는 기능
2. 게임 시작 전 문구를 출력하는 기능
3. 사용자에게 수를 입력받는 기능
4. 사용자가 잘못된 값을 입력할 경우 예외를 발생시키는 기능
5. 컴퓨터 수와 사용자가 입력한 수를 비교하는 기능
6. 사용자에게 힌트를 출력하는 기능
7. 게임을 종료 문구를 출력하는 기능
8. 게임 재시작 여부를 입력받는 기능
9. 애플리케이션을 중지하는 기능

# 구현할 기능 ver2.0

### Application
- main()

### GameInput
- getRestartOption()
- getUserNumber()

### GameOutput
- displayStartPrompt()
- displayResumePrompt()
- displayQuitPrompt()
- displayHint()
- displayInputNumberPrompt()

### GameNumberGenerator
- generateNumber()

### GameNumberComparator
- compareNumbers()

# 구현할 기능 ver2.1

- 목표 : 오직 한 단계의 indent만 한다
- 방법 : 메서드를 한가지 일만 하도록 분리한다
- 수정해야할 메서드

    | 클래스       | 메서드           | 분리 / 변경 해야하는 기능                                                   |
    |-----------|---------------|-------------------------------------------------------------------|
    | GameInput | getUserNumber | 입력 받는 기능, <br/>문자-숫자 변환 기능, <br/>잘못된 입력 예외 발생 기능                  | 
    | GameInput      | getRestartOption | if 조건을 2개가 아닌 하나로 변경                                              |  
    | GameNumberComparator | compareNumbers | 컴퓨터-유저 숫자 카운트 기능,<br/>스트라이크 카운트 기능, <br/>볼 카운트 기능 , <br/>숫자 비교 기능 |
    | GameNumberGenerator      | generateNumber          | 랜덤 숫자 뽑는 기능, <br/>중복 체크 기능, <br/>최종 숫자 삽입 기능  |