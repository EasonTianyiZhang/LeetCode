public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
     

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++){
            int lv1 = (i < v1.length)? Integer.parseInt(v1[i]): 0;
            int lv2 = (i < v2.length)? Integer.parseInt(v2[i]): 0;
            
            if (lv1 == lv2) continue;
            else return (lv1 > lv2)? 1:-1;
        }
        return 0;
    }
}