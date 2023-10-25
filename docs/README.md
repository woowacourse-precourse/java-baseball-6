구현할 기능 목록
(1) 컴퓨터 값
    컴퓨터는 1에서 9까지 서로 다른 3자리 수 선택
    숫자 중복 없어야 함
    camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

(2) 사용자 값
    정답을 맞힐 때까지 입력받음
    camp.nextstep.edu.missionutils.Console의 readLine()을 활용
    잘못된 값 입력하면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

(3) 결과 출력
    맞힌 개수에 따라 낫싱, 볼, 스트라이크 출력
    정답일 경우 다시 시작(1) or 종료(2) 선택


************
camp.nextstep.edu.missionutils.Console과 import camp.nextstep.edu.missionutils.Randoms는
외부라이브러리 -> mission-utils-1.1.0.jar 안에 존재
CMD로 실행할 경우 javac 명령어로 .class 파일 만들 때 
javac -cp "/Users/yujeong/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.1.0/a4b1a3600a51a05d44913c93181de7d143fadce2/mission-utils-1.1.0.jar" Application.java CreateRandomNum.java Restart.java Compare.java Input.java Score.java 이런 식으로 하면 된다
************
