# 기능 구현 원칙
첫 기능 구현 목록을 최대한 구체적으로 작성한다

구현 과정에서 발생하는 새로운 요구 사항은 구현 후 docs에 추가하여 새로 커밋한다.

분리된 책임을 편의를 이유로 합치지 않는다.

## 기능 구현 목록

- GameController
  1. 게임 시작 기능
  2. 게임 종료 기능
      <br></br>
- NumberBaseballGame
  1. 게임 초기 설정 기능
     <br></br>
- BaseballNumber
  1. 3개의 숫자를 리스트로 저장하는 기능
  2. 인덱스의 숫자를 반환하는기능
     <br></br>
- RandomBaseballNumberGenerator
  1. 게임 조건에 맞는 3자리 숫자 생성 기능
     <br></br>
- Referee
  1. 스트라이크를 세는 기능
  2. 볼을 세는 기능
     <br></br>
- Result
  1. 스트라이크, 볼 결과 저장 기능
  2. 스트라이크, 볼 결과 반환 기능
  3. 스트라이크, 볼 모두 없을 경우 낫싱 반환 기능
     <br></br>
- GameCode
  1. 종료, 재시작 등 게임 고유 코드 관리 기능
- RuleValue
  1. 규칙이 되는 상수 관리 기능
      <br></br>
- GameMessage
  1. 시스템 출력 메세지 관리 기능
      <br></br>
- ExceptionMessage
  1. 예외 메세지 관리 기능
     <br></br>
- InputValidator
  1. 유저의 입력이 규칙에 맞는지 검증하는 기능
     <br></br>
- InputView
  1. 게임 도중 플레이어에게 input을 요청하는 메세지 출력 기능
  2. 게임 종료 / 재시작 코드를 요청하는 메세지 출력 기능
       <br></br>
- OutputView
  1. 게임 시작 메세지 출력 기능
  2. 스트라이크, 볼 출력 기능
  3. 게임 승리 시 게임 종료 메세지 출력 기능
- ListUtil
  1. 하나의 정수를 자릿수대로 리스트에 저장하는 기능