*0. 설계
[Domain]
- Game :id, userId, computerNumber, questionCount
- User: id, name

[Repository] 데이터 관리
- GameRepository: save, findById, findAll, findByUserId
- UserRepository: save, findById, findAll, findByName

[Service] 버튼 기능
- GameService: 랜덤 숫자 생성, 사용자 값 입력, 야구게임 값 일치여부

[Controller] 매니저 역할
- GameController: 게임 오프닝, 게임 시작, 메뉴 표출

*1. 기능 요구 사항
1.1. 야구게임 규칙
- 스트라이크(S): 같은 수 and 같은 자리
- 볼(B): 다른 자리
- 낫싱(N): 같은 수가 전혀 없음

1.2. 기능 로직
    a. 게임 오프닝 시작
    b. 컴퓨터는 1~9까지 서로 다른 임의의 수 3개를 선택
    c. 숫자 맞추기
        c-1. 플레이어는 서로 다른 3개의 수를 입력
             단, 잘못된 값 입력 시 `IllegalArgumentException` 발생
        c-2. 플레이어가 입력한 숫자와 컴퓨터의 숫자를 비교하여 결과를 출력
        c-3. 숫자를 모두 맞출 경우 해당 라운드가 종료되며, 맞출 때 까지 c 과정 반복
    d. 게임 재시작 여부를 선택
        d-1. 게임 재시작일 경우, b 이동
        d-2. 종료일 경우, e 이동 
        단, 잘못된 값 입력 시 `IllegalArgumentException` 발생
    e. 애플리케이션 종료


*2. 입출력 요구 사항
2.1. 입력
- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

2.2. 출력
- 게임 시작 문구 출력
ex) 숫자 야구 게임을 시작합니다.
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
ex) 1볼 1스트라이크
- 하나도 없는 경우
ex) 낫싱
- 3개의 숫자를 모두 맞힐 경우
ex) 3스트라이크
    3개의 숫자를 모두 맞히셨습니다! 게임 종료

*3. 프로그래밍 요구 사항
- 버전정보: JDK 17
- 프로그램 실행 시작점: Application의 main()
- build.gradle 파일 변경 불가 (외부 라이브러리 사용 금지) 
- Java 코드 컨벤션 가이드 준수 
- System.exit()호출 금지
- ApplicationTest의 모든 테스트 성공 필수
