# ✅ 구현 기능 목록
## Application 클래스
- 게임의 시작과 끝을 제어하는 클래스
- main()
  - 게임의 시작과 끝을 제어
  - 게임 시작, 종료 문구 출력
- askExit()
  - 사용자에게 게임 종료 여부를 입력 받음
## Game 클래스
- 게임과 관련된 기능을 하는 클래스 
- play()
  - 전반적인 게임의 흐름을 제어
  - 3스트라이크이면 메소드 종료
- askUserNumbers()
  - 사용자에게 숫자를 입력받음
- printScore()
  - 점수를 출력
## Util 클래스
- 기능적인 메소드를 제공하는 클래스
- getRandomNumber()
  - 각 자리의 수가 중복되지 않는 임의의 수 생성
- validateUserString()
  - 사용자가 입력한 문자열을 검증
- validateStringOnlyNumbers()
  - 1~9 사이의 숫자가 아닌 값이 포함된 경우 예외 발생
- validateStringLength()
  - 문자열이 해당 길이가 아니면 예외 발생
- validateStringDuplicate()
  - 문자열에 중복된 값이 있으면 예외 발생
- stringToIntegerList()
  - 문자열을 List<Integer> 형태로 반환

## Score 클래스
- 점수를 의미하는 domain 클래스
- 스트라이크와 볼을 변수로 가짐
- getScore()
  - 정적 메소드로, 점수를 측정하여 점수를 반환
