import java.util.Arrays;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
    
        Arrays.sort(coins);
        
        long low = 1;
        long high = (long) coins[0] * k;
        long ans = high;
        
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countUniqueMultiples(mid, coins) >= k) {
                ans = mid;         
                high = mid - 1;
            } else {
                low = mid + 1;     
            }
        }
        return ans;
    }
    
    private long countUniqueMultiples(long maxVal, int[] coins) {
        long totalCount = 0;
        int n = coins.length;
        int totalSubsets = 1 << n; 
        
        
        for (int mask = 1; mask < totalSubsets; mask++) {
            long currentLcm = 1;
            int elementsInSubset = 0;
            boolean overflow = false;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { 
                    elementsInSubset++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    
                    
                    if (currentLcm > maxVal) {
                        overflow = true;
                        break;
                    }
                }
            }
            
            if (overflow) continue;
            
            
            if (elementsInSubset % 2 == 1) {
                totalCount += (maxVal / currentLcm); 
            } else {
                totalCount -= (maxVal / currentLcm); 
            }
        }
        return totalCount;
    }
    

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
