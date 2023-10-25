구현할 기능 목록
1. 게임이 시작될 때, Random 함수를 통해 정답을 생성 (while1)
2. 게임 진행 중 (while2) 
    a. strike 와 ball 0으로 초기화
    b. 정답 입력 및 예외 처리(IllegalArgumentException)
    c. 정답 계산 부분과 그 결과를 출력하는 부분
    d. 정답 일 시, while2 탈출 구문
3. 게임 계속 진행 여부에 따른 while1 탈출 여부


ThreadLocalRandom
* java.util.random의 멀티 쓰레드 환경에서의 문제를 개선한 라이브러리 (동시성에 안전)
* 각 쓰레드마다 생성된 인스턴스에서 각각 난수를 반환 => 경합 문제가 발생하지 않아 성능상 이점
* JAVA는 기본적으로 현재시간(nanoTime)을 기준으로 난수 생성


camp.nextstep.edu.missionutils.Randoms
* ThreadLocalRandom을 기반으로 구성된 customClass

1. validateRange(final int startInclusive, final int endInclusive)
    * 두 인자의 유효성 검증 메서드
    ? 인자를 final로 받는 것은 내부에서 값의 변경이 없음을 의미하는 것일까?
       어자피 call by value 라서 해당 메서드에서의 변경은 외부에 영향을 끼치지 않을텐데 이유가 궁금하다.

2. validateNumber(final List<Integer> numbers)
    * 인자로들어온 List<Integer> numbers가 비어있는지 확인하는 메서드

3. validateCount(final int startInclusive, final int endInclusive, final int count)
    * count가 유효한 숫자인지 검증하는 메서드

4. shuffle(final List<T> list)
    * Collections.shuffle을 사용하여 list를 shuffle 하여 반환

5. pickNumberInRange(final int startInclusive, final int endInclusive)
    * validateRange() 이후, ThreadLocalRandom을 사용하여 범위 내의 난수 생성

6. pickNumberInList(final List<Integer> numbers)
    * validateNumbers() 이후, pickNumberInRange()를 사용하여 난수 생성 후 리스트의 해당 인덱스 값을 반환

7. pickUniqueNumbersInRange(final int startInclusive, endInclusive, count)
    * validateRange(), validateCount()를 통한 유효성 검증 이후, 
       startInclusive ~ endInclusive의 값을 갖는 List를 생성
       이후 해당 리스트를 shuffle() 후, count 만큼 리스트 앞에서부터 추출 반환