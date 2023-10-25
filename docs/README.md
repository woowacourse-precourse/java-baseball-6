### 프로그래밍 요구 사항

    [x] JDK 17버전에서 실행 가능해야 한다.
    [x] 프로그래밍 시작은 `Application`의 main()이다.
    [x] [Java 코드 컨벤션] 가이드를 준수하여 프로그래밍한다.
        [x] 블럭 들여쓰기 : +4 스페이스
        [x] 열 제한 : 120
        [x] 들여쓰기 지속은 최소 +8 스페이스
    [x] 라이브러리 사용
        [x] `camp.nextstep.edu.misstionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
        [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()`를 활용한다.
        [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console의 readLine()`을 활용한다.


### 프로그래밍 기능 요구 사항

    [x] 숫자 야구 게임 시작 문구 출력
    [x] Random 값 추출
        [x] `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()`를 사용
    [x] 숫자 입력 문구 출력
    [x] 숫자 입력
        [x] `camp.nextstep.edu.misstionutils.Console`의 readLine() 사용
    [x] 결과 출력
        [x] 입력한 수에 대한 결과를 볼, 스트라이크로 개수 표시
            [x] 같은 숫자와 위치가 같은 경우 `스트라이크`
            [x] 같은 숫자와 다른 위치인 경우 `볼`
        [x] 하나도 없는 경우
        [x] 3개 다 맞춘 경우
    [x] 새로운 게임 시작 문구 
        [x] 1인 경우 새 게임 시작
        [x] 2인 경우 게임 종료
    

### 예외처리

    [x] 사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException` 출력 후 애플리케이션 종료
        [x] 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
            [x] 1부터 9까지의 수가 아닌 경우 => 0
            [x] 하나라도 같은 수가 있는 경우
        [x] 새로운 게임 시작   
            [x] 1 또는 2가 아닌 경우
