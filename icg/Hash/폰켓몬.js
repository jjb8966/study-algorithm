function solution(nums) {
  // Set: 고유한 값들의 집합을 다루는 자료구조 set을 통해서 noJoogbok에 중복을 제거한 nums를 담는다
  const noJoongbok = [...new Set(nums)];
  // 가져갈 수 있는 폰켓몬의 수
  const halfNums = nums.length / 2;
  // 중복을 제거한 폰켓몬의 수와 가져갈 수 있는 폰켓몬의 수를 비교하여 중복을 제거한 폰켓몬의 수가 크다면 가져갈 수 있는 만큼의 폰켓몬 수를 return하고 아니라면 중복을 제거한 폰켓몬의 수를 return 한다.
  return noJoongbok.length > halfNums ? halfNums : noJoongbok.length;
}

// 사실 위의 방법은 해시를 이용한 구현인가...? 라는 생각이 들기는합니다...
// 만약 원래 해시로 구현해야했다면 Map 객체를 이용해 key와 value 형태의 해시를 만들어 구현가능할것 같다.

function solution(nums) {
  const ponketmons = new Map();

  nums.forEach((ponketmon) => {
    if (ponketmons.get(ponketmon))
      return ponketmons.set(ponketmon, ponketmons.get(ponketmon) + 1);
    ponketmons.set(ponketmon, 1);
  });

  return ponketmons.size < nums.length / 2 ? ponketmons.size : nums.length / 2;
}

solution([3, 1, 2, 3]);
