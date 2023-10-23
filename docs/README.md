# ✅ 구현 기능 목록
- 게임의 시작과 끝을 제어하는 기능
- 게임의 시작과 끝에 안내 출력 기능
- 컴퓨터 임의의 값 생성 기능
- 사용자에게 값을 입력받는 기능
- 점수 측정 후 점수 출력 기능
- 사용자에게 게임 종료 여부를 입력받는 기능
# ✅ 전반적인 구조
## controller - Application.java 
- 사용자로부터 받아온 입력값 및 사용자에게 보여줄 출력값과 비즈니스 로직을 이어주는 역할을 한다. 
- 프로그램을 실행시키고, 사용자의 게임 종료 여부에 따라 게임을 계속 진행하거나 중단시킨다. 
## service - Game.java
- 게임을 하는 비즈니스 로직을 담당한다.

## domain - Score.java
- 점수를 의미하는 domain 클래스이다.
- 스트라이크와 볼을 변수로 가진다.
- getScore()
  - 정적 메소드로, 점수를 측정하여 점수를 반환
## view - InputView, OutputView
- 사용자에게 게임 시작과 끝을 알림
- 사용자의 입력값을 입력받기
## dto - ScoreDto.java
- Score 도메인 객체의 값을 사용자에게 보여주기 위해 필요한 DTO이다.
## util - Util.java
- 기능적인 메소드를 제공한다.
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

