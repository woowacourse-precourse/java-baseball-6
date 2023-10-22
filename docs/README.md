1. 프로그램 실행시 정답이 될 숫자를 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 생성
2. 게임 시작 문구 출력
3. camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 사용자 입력값을 받음
4. 입력값과 생성되어있던 정답을 비교하여 게임 규칙에 따라 힌트문구 출력
5. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
6. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
7. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.