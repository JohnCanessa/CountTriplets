import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 
 */
public class CountTriplets {


     /**
      * Calculate triplet value if present in tuples.
      * Execution: O(n) - Space: O(n)
      */
    static long countTriplets(List<Long> arr, long r) {

        // **** initialization ****
        long sum                    = 0L;
        HashMap<Long, Long> prevMap = new HashMap<Long, Long>();
        HashMap<Long, Long> nextMap = new HashMap<Long, Long>();

        // **** populate the nextMap - O(n) ****
        for (Long a : arr)
            nextMap.put(a, nextMap.getOrDefault(a, 0L) + 1L);

        // ???? ????
        System.out.println("<<< nextMap: " + nextMap.toString());

        // **** loop through the input list - O(n) ****
        for (int i = 0; i < arr.size(); i++) {

            // **** current value ****
            Long currentVal = arr.get(i);

            // ???? ????
            System.out.println("<<< currentVal: " + currentVal);

            // **** ****
            long prevCount  = 0L;
            long nextCount  = 0L;

            // *** decrement count for currentVal in nextMap ****
            nextMap.put(currentVal, nextMap.getOrDefault(currentVal, 0L) - 1L);

            // ???? ????
            System.out.println("<<< nextMap:" + nextMap.toString());

            // **** ****
            if (prevMap.containsKey(currentVal / r) && currentVal % r == 0)
                prevCount = prevMap.get(currentVal / r);

            if (nextMap.containsKey(currentVal * r))
                nextCount = nextMap.get(currentVal * r);

            // ???? ????
            System.out.println("<<< prevCount: " + prevCount + " nextCount: " + nextCount);

            // **** update sum ****
            sum += prevCount * nextCount;

            // ???? ????
            System.out.println("<<< sum: " + sum);

            // **** increment count for currentVan in prevMap ****
            prevMap.put(currentVal, prevMap.getOrDefault(currentVal, 0L) + 1L);

            // ???? ????
            System.out.println("<<< prevMap: " + prevMap.toString());
            System.out.println("<<< nextMap: " + nextMap.toString());
        }

        // **** return long (NOT int) answer ****
        return sum;
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read first input line ****
        String[] nr = br.readLine().trim().split(" ");
        long r = Long.parseLong(nr[1]);

        // **** read list of long values ****
        List<Long> arr = Arrays.stream(br.readLine().trim().split(" "))
                            .map(Long::parseLong)
                            .collect(Collectors.toList());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<<   r: " + r);
        System.out.println("main <<< arr: " + arr);

        // **** call the function of interest and display result ****
        System.out.println("main <<< ans: " + countTriplets(arr, r));
    }
}