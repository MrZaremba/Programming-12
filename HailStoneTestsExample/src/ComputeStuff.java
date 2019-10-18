import java.util.ArrayList;
import java.util.List;

public class ComputeStuff {


    /**
     *Compute Hailstone Sequence.
     * See http://en.wikipedia.org/wiki/Collatz_conjecture#Statement_of_the_problem
     * @param n starting number of sequence; requires n > 0.
     * @return the hailestone sequence starting at n and ending with 1.
     *      For example, hailstone(3) = [3,10,5,16,8,4,2,1].
     *      If selection invalid returns null.
     */
    public static List<Integer> hailstoneSequence(int n) {
        if(n < 1){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (n != 1) {
            if(n%2 == 0){
                n = n /2;
                list.add(n);
            }else{
                n = n * 3 + 1;
                list.add(n);
            }
        }
        return list;
    }
}