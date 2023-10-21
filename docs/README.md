# 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
예) 상대방(컴퓨터)의 수가 425일 때
123을 제시한 경우 : 1스트라이크
456을 제시한 경우 : 1볼 1스트라이크
789를 제시한 경우 : 낫싱
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
입출력 요구 사항
입력
서로 다른 3자리의 수
게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
출력
입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

# 프로그래밍 요구 사항
JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
프로그램 실행의 시작점은 Application의 main()이다.
build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
프로그램 종료 시 System.exit()를 호출하지 않는다.
프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
라이브러리
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
사용 예시
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
int randomNumber = Randoms.pickNumberInRange(1, 9);
if (!computer.contains(randomNumber)) {
computer.add(randomNumber);
}
}

# 과제 진행 요구 사항
미션은 java-baseball-6 저장소를 Fork & Clone해 시작한다.
기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.
과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.