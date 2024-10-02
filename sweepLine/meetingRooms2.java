package sweepLine;
import java.util.*;
/*
 253. Meeting Rooms II
Description
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:

1 <= intervals.length <= 10^4
0 <= starti < endi <= 10^6
 */
public class meetingRooms2 {
    public static int maxHallNeeded(List<List<Integer>> intervals) {
        // Step 1: Create a line to store start (+1) and end (-1) events
        List<int[]> events = new ArrayList<>();
        for (List<Integer> interval : intervals) {
            events.add(new int[] { interval.get(0), 1 });  // Meeting start (+1)
            events.add(new int[] { interval.get(1), -1 }); // Meeting end (-1)
        }   
        int maxHalls = 0;

        // Step 2: Sort events by time; tie-breaking ensures end comes before start if they are equal
        events.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // End before start at same time
            return a[0] - b[0]; // Otherwise sort by time
        });
        int ongoingMeetings = 0;
        for (int[] event : events) {
            System.out.println(event[0] + " " + event[1]);
            ongoingMeetings += event[1];  
            maxHalls = Math.max(maxHalls, ongoingMeetings);
        }
        return maxHalls; 
    }
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    List<List<Integer>> intervals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        List<Integer> interval = new ArrayList<>();
        int start = sc.nextInt();  
        int end = sc.nextInt();    
        interval.add(start);
        interval.add(end);
        intervals.add(interval);
    }
    System.out.println("Max halls needed for this interval: "+maxHallNeeded(intervals));
 }   
}

