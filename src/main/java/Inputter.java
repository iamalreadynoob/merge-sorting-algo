import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Inputter
{

    protected static int[] inputArr()
    {
        ArrayList<Integer> nums = new ArrayList<>();

        String num;
        do
        {
            num = new Scanner(System.in).nextLine();

            try
            {
                int temp = Integer.parseInt(num);
                nums.add(temp);
            }
            catch (Exception e){}
        }
        while (!num.equals("ok"));

        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) arr[i] = nums.get(i);

        return arr;
    }

    protected static int[] declareArr(int... nums)
    {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) arr[i] = nums[i];
        return arr;
    }

    protected static int[] createArr(int size)
    {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = new Random().nextInt();
        return arr;
    }

    protected static int[] getPowersOfTwo(int size)
    {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int) Math.pow(2, i);
        return arr;
    }
}
