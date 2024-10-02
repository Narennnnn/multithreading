package sweepLine;
import java.util.*;
/*
 252. Meeting Rooms
Description
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 */
public class meetingRooms {
    public static boolean canAttendAll(List<List<Integer>> intervals) {
        // Step 1: Create a line to store start (+1) and end (-1) events
        List<int[]> events = new ArrayList<>();
        for (List<Integer> interval : intervals) {
            events.add(new int[] { interval.get(0), 1 });  // Meeting start (+1)
            events.add(new int[] { interval.get(1), -1 }); // Meeting end (-1)
        }

        // Step 2: Sort events by time; tie-breaking ensures end comes before start if they are equal
        events.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // End before start at same time
            return a[0] - b[0]; // Otherwise sort by time
        });
        int ongoingMeetings = 0;
        for (int[] event : events) {
            System.out.println(event[0] + " " + event[1]);
            ongoingMeetings += event[1];  
            if (ongoingMeetings>1) {
                return false;  // Gap detected: no ongoing meetings
            }
        }
        return true; 
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
    if(canAttendAll(intervals) == true){
        System.out.println("True");
    }else{
        System.out.println("False");
    }
 }   
}
