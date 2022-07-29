from ast import List
class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        target.sort()
        arr.sort()

        for x in range(len(target)):
            if target[x] != arr[x]:
                return False
        return True