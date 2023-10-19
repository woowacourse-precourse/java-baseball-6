구현시 주의할 점

1. Java 17에서 동작
2. 외부 라이브러리는 missionutils.Randoms and Console만 사용
3. 들여쓰기 4칸 (탭1번)
4. 열 제한은 120
5. 들여쓰기 지속은 8칸 (탭2번)


숫자 야구 구현 목표

1. 게임 설정, 진행과 관련된 Enum 생성
   1. Size : 볼의 범위, 자리수 등 설정
   2. Command : 게임 재시작 시 입력받는 커맨드 설정
   3. CustomException : 입력에 문제가 있을때 발생할 예외 설정
   4. ErrorCode : 예외의 종류 구분용 코드
2. InputValidator : 입력 값을 검증
   1. checkOutOfRange(int input) : 볼 범위를 벗어나는지 검증 후 반환
   2. isInteger(String input) : 숫자인지 검증 후 반환
   3. checkCommand(String input) : 게임 재시작 커맨드 검증 후 반환
   4. checkOutOfNumber(int input) : 볼의 개수가 맞는지 검증 후 반환
3. InputController : 사용자의 입력을 받음
   1. getBall() : 볼을 입력받고 입력값 반환
   2. getCommand() : 커맨드를 입력받고 반환
4. BallGenerator : 정답인 3자리 수를 생성
   1. createBall() : 정답 볼을 생성
5. Ball : 게임 진행동안 볼 내용을 저장하고 비교하는 엔티티
   1. compareBall(int input) : 정답과 입력 볼을 비교 후 결과 반환
6. BallService : 게임 진행을 담당
   1. init() : 게임 시작 설정 로직
   2. start() : 게임 시작 로직
   3. mainSequence() : 메인 진행인 숫자 맞추기 로직
   4. restartSequence() : 게임이 끝났을 때 재시작 로직
   5. occurException() : 예외가 발생하면 메세지 출력
7. OutputView : 결과 화면을 출력
   1. printResult(int[] result) : 결과값을 받아 화면을 그림
   2. printMessage(String message) : 메세지 출력 (오류)
   3. printStart() : 시작 메세지 출력
   4. printGetBall() : 사용자의 입력 유도 메세지 출력
   5. printRestart() : 재시작 메세지 출력