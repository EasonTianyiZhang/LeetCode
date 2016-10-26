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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        int b = 0;
        int e = intervals.size()-1;
        while(b < e){
            int m = b + (e - b)/2;
            if (intervals.get(m).end >= newInterval.start) e = m;
            else b = m+1;
        }
        
        if (intervals.size() == 0 || intervals.get(e).end < newInterval.start){
            intervals.add(newInterval);
            return intervals;
        }
        else{
            List<Interval> res = new LinkedList<Interval>();
            int idx = e;
            for (int i = 0; i < idx; i++){
                res.add(intervals.get(i));
            }
            
            //These two lines are tricky and interesting
            int start = Math.min(intervals.get(idx).start, newInterval.start);
            int end = newInterval.end;
            
            for (int i = idx; i < intervals.size(); i++){
                Interval itvl = intervals.get(i);
                if (itvl.start <= end){
                    end = Math.max(end, itvl.end);
                }
                else{
                    res.add(new Interval(start, end));
                    start = itvl.start;
                    end = itvl.end;
                }
            }
            res.add(new Interval(start, end));
            return res;
        }
    }
}