/*

Input: x = 3, y = 5, z = 4
Output: True

*/

public class Solution {
    
    /*
    1: x + y >= z
    2: Bézout's identity:
        mx + ny = z has solution (m, n)
        iff d = GCD(x, y) && z % d == 0
        
        GCD is Greatest Common Divisor.
    
    */
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }
    
    private int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}