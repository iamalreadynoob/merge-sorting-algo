import java.util.ArrayList;

public class Action
{

    protected static void runCustomAct()
    {
        int[] arr = Inputter.inputArr();

        long start = System.currentTimeMillis();
        arr = Merge.sort(arr);
        long end = System.currentTimeMillis();

        Visualization.visualArray(Visualization.Type.ONE_LINE, arr);

        long duration = end - start;
        System.out.println("Process was last for " + duration + " milliseconds.");
    }


    protected static void runTestAct(int times)
    {
        int[] powers = Inputter.getPowersOfTwo(times);
        ArrayList<Long> durations = new ArrayList<>();

        for (int i = 0; i < times; i++)
        {
            int[] arr = Inputter.createArr(powers[i]);

            long start = System.currentTimeMillis();
            arr = Merge.sort(arr);
            long end = System.currentTimeMillis();

            long duration = end - start;
            durations.add(duration);

            System.out.println("The Process with " + arr.length + " items was last for " + duration + " milliseconds.");
        }

        System.out.println("DURATIONS: " + durations);
    }

}
