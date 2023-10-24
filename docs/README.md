구현시 주의할 점

1. Java 17에서 동작
2. 외부 라이브러리는 missionutils.Randoms and Console만 사용
3. 들여쓰기 4칸 (탭1번)
4. 열 제한은 120
5. 들여쓰기 지속은 8칸 (탭2번)
6. 기능 구현 목표 꼼꼼하게 읽기 (시간 낭비 방지)


숫자 야구 구현 목표

1. 게임 설정, 진행과 관련된 Enum 생성
   1. Size : 볼의 범위, 자리수 등 설정
   2. Command : 게임 재시작 시 입력받는 커맨드 설정
   3. Message : 화면 출력용 메세지
2. InputValidator : 입력 값을 검증
   1. checkOutOfRange(String input) : 볼 범위를 벗어나는지 검증 후 반환
   2. checkCommand(String input) : 게임 재시작 커맨드 검증 후 반환
   3. checkBall(String input) : 볼의 개수가 맞는지 검증 후 반환
3. InputController : 사용자의 입력을 받음
   1. getBall() : 볼을 입력받고 입력값 반환
   2. getCommand() : 커맨드를 입력받고 반환
4. BallGenerator : 정답인 3자리 수를 생성
   1. createBall() : 정답 볼을 생성
5. Ball : 게임 진행동안 볼 내용을 저장하고 비교하는 엔티티
   1. compareBall(List<Integer> hit) : 정답과 입력 볼을 비교 후 결과 반환
6. BallService : 게임 진행을 담당
   1. init() : 게임 시작 설정 로직
   2. start() : 게임 시작 로직
7. OutputView : 결과 화면을 출력
   1. printResult(int[] result) : 결과값을 받아 화면을 그림
   2. printStart() : 시작 메세지 출력
   3. printGetBall() : 사용자의 입력 유도 메세지 출력
   4. printRestart() : 재시작 메세지 출력