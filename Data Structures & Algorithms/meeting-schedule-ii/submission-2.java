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
    public int minMeetingRooms(List<Interval> intervals) {
    //     if(intervals.size() == 1) {
    //         return 1;
    //     }
    // Collections.sort(intervals, Comparator.comparingInt(i->i.start));  
    // int count = 1;
    // for(int i=1;i<intervals.size();i++) {
    //     if(intervals.get(i).end <= intervals.get(i-1).end){
    //         count++;
    //     } 
    //     // else if(intervals.get(i).start >= intervals.get(i-1).end) {
    //     //     count++;
    //     // }
    // } 
    // return count;

// intuition is that irrespective, we only need when the train departs, or meeting ends, only then the room gets freed.
    int n = intervals.size();
    int[] start = new int[n];
    int[] end = new int[n];

    for(int i=0;i<n;i++) {
        start[i] = intervals.get(i).start;
        end[i] = intervals.get(i).end;
    }

    Arrays.sort(start);
    Arrays.sort(end);

    int res=0, count = 0, s=0, e=0;
    while(s<n) {
        if(start[s] < end[e]) {
            s++;
            count++;
        } else {
            e++;
            count--;
        }
        res = Math.max(res, count);
    }
    return res;
    
     }
}
