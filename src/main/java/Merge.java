import java.util.ArrayList;

public class Merge
{
    protected static int[] sort(int[] arr)
    {
        ArrayList<int[]> arrays = divide(arr);
        return conquer(arrays);
    }

    private static ArrayList<int[]> divide(int[] arr)
    {
        ArrayList<int[]> arrays = new ArrayList<>();
        arrays.add(arr);

        while (arrays.size() != arr.length)
        {
            int times = arrays.size();

            for (int j = 0; j < times; j++)
            {
                if (arrays.get(0).length > 1)
                {
                    int mid = arrays.get(0).length / 2;

                    int[] leftTemp = new int[mid];
                    for (int k = 0; k < mid; k++) leftTemp[k] = arrays.get(0)[k];

                    int[] rightTemp = new int[arrays.get(0).length - mid];
                    for (int k = 0; k < arrays.get(0).length - mid; k++) rightTemp[k] = arrays.get(0)[mid + k];
                    arrays.add(rightTemp);

                    arrays.remove(0);
                    arrays.add(leftTemp);
                }
                else
                {
                    arrays.add(arrays.get(0));
                    arrays.remove(0);
                }
            }
        }

        return arrays;
    }

    private static int[] conquer(ArrayList<int[]> arrays)
    {
        while (arrays.size() > 1)
        {
            int[] leftArray = arrays.get(0);
            int[] rightArray = arrays.get(1);

            int[] merged = createArr(leftArray.length + rightArray.length);

            int leftIndex = 0;
            int rightIndex = 0;
            boolean init = true;

            while (leftIndex < leftArray.length && rightIndex < rightArray.length)
            {
                if (init)
                {
                    if (leftArray[leftIndex] <= rightArray[rightIndex])
                    {
                        merged[0] = leftArray[leftIndex];
                        leftIndex++;
                        init = false;
                    }
                    else
                    {
                        merged[0] = rightArray[rightIndex];
                        rightIndex++;
                        init = false;
                    }
                }
                else
                {
                    if (leftArray[leftIndex] <= rightArray[rightIndex] && leftArray[leftIndex] <= merged[0])
                    {
                        merged = swipe(leftArray[leftIndex], 0, merged);
                        leftIndex++;
                    }
                    else if (rightArray[rightIndex] <= leftArray[leftIndex] && rightArray[rightIndex] <= merged[0])
                    {
                        merged = swipe(rightArray[rightIndex], 0, merged);
                        rightIndex++;
                    }
                    else if (leftArray[leftIndex] <= rightArray[rightIndex])
                    {
                        merged = relocate(leftArray[leftIndex], merged);
                        leftIndex++;
                    }
                    else
                    {
                        merged = relocate(rightArray[rightIndex], merged);
                        rightIndex++;
                    }
                }
            }

            while (leftIndex < leftArray.length)
            {
                merged = relocate(leftArray[leftIndex], merged);
                leftIndex++;
            }

            while (rightIndex < rightArray.length)
            {
                merged = relocate(rightArray[rightIndex], merged);
                rightIndex++;
            }

            arrays.remove(0);
            arrays.remove(0);
            arrays.add(merged);
        }

        return arrays.get(0);
    }

    private static int[] swipe(int num, int index, int[] arr)
    {
        int[] temp = new int[arr.length];

        int loc = 0;

        while (loc < index)
        {
            temp[loc] = arr[loc];
            loc++;
        }

        temp[loc] = num;
        loc++;

        while (loc < temp.length)
        {
            temp[loc] = arr[loc-1];
            loc++;
        }

        return temp;
    }

    private static int[] relocate(int num, int[] arr)
    {
        int index = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++)
        {
            if (num <= arr[i])
            {
                index = i;
                break;
            }
        }

        if (index == Integer.MIN_VALUE)
        {
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == Integer.MIN_VALUE)
                {
                    index = i;
                    break;
                }
        }

        return swipe(num, index, arr);
    }

    private static int[] createArr(int size)
    {
        int[] temp = new int[size];
        for (int i = 0; i < temp.length; i++) temp[i] = Integer.MIN_VALUE;
        return temp;
    }

}
