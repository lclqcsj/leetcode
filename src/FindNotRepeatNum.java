import java.util.ArrayList;
import java.util.List;

/**
 * @author lcl
 */
public class FindNotRepeatNum {

    static int findNotRepeatNumber(int[] nums) {

        int result = 0;
        for (int n: nums) {
            result ^= n;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] num = {1,2,3,4,1,2,3};
        System.out.println(findNotRepeatNumber(num));
    }
}
