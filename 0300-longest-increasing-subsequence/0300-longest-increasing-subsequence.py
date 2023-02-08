class Solution(object):
    def lengthOfLIS(self,a):
        n = len(a)
        arr = [0] * n
        arr[0] = a[0]
        curr = 0

        

        for i in range(1, n):
            ind = self.index(arr, curr, a[i])
            arr[ind] = a[i]
            curr = max(ind, curr)

        return curr + 1
    def index(self,arr, i, k):
            ans = -1
            low = 0
            high = i
            while low <= high:
                mid = (low + high) // 2
                if arr[mid] > k:
                    ans = mid
                    high = mid - 1
                elif arr[mid] < k:
                    low = mid + 1
                else:
                    ans = mid
                    break
            if ans == -1:
                return i + 1
            else:
                return ans
        