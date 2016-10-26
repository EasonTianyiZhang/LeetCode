/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        if (intervals.size() < 2) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new LinkedList<Interval>();
        
        for (int i = 0; i < intervals.size(); i++){
            Interval itvl = intervals.get(i);
            if (itvl.start <= end) end = Math.max(end, itvl.end);
            else{
                res.add(new Interval(start, end));
                start = itvl.start;
                end = itvl.end;
            }
        }
        
        res.add(new Interval(start, end));// add the last one
        return res;
    }
}