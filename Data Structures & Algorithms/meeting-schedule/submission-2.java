/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i->i.start));
        if(intervals.size() <=1)
        return true;
                int prevEnd = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++) {
            if(intervals.get(i).start < prevEnd){
                return false;
            } else {
                prevEnd = intervals.get(i).end;
            }
        }
        return true;
    }
}
