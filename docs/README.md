구현할 기능 목록

1. !서로 다른! 1~9까지 임의의 3자리 숫자 생성
2. 숫자 입력(틀린 입력값 'IllegalArgumentException' 출력 후 종료, 각 상황에 맞는 예외출력 메시지)
   - 3자리수 입력 받기
   - 틀린 입력 값 
     ex1) 3자리수가 아님
     ex2) 숫자가 아님
     ex3) 같은 숫자가 중복
3. 입력 숫자 판별(스트라이크, 아웃, 낫싱)
   - 자리와 숫자가 같다 -> 스트라이크
   - 숫자는 맞지만 자리가 다름 -> 볼
   - 맞는 숫자가 없음 -> 낫싱
4. 결과
   - 3스트라이크일 경우 -> 종료
   - 3스트라이크가 아닐 경우 -> 다시 숫자 입력
5. 정답으로 종료
   - 다시 시작
   - 종료

시스템 흐름
1. main()에서 BaseballGame 인스턴스를 생성 후 run()이 실행된다.
2. run()은 while문으로 반복된다.
3. 한번 반복할 때마다 3자리 임의의 숫자를 생성한다.
4. 지속적 입력을 받는다.
5. 결과가 나오고 선택에 따라 break or restart한다.

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 종료시에 System.exit()를 쓰지 않는다.