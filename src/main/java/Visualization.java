public class Visualization
{
    public static void visualArray(Type type, Object... items)
    {

        switch (type)
        {
            case ONE_ITEM_ONE_LINE ->
            {
                if (items.length == 1 && items[0] instanceof int[])
                {
                    int[] temp = (int[]) items[0];
                    for (int i: temp) System.out.println(i);
                }
            }

            case ONE_LINE ->
            {
                if (items.length == 1 && items[0] instanceof int[])
                {
                    int[] temp = (int[]) items[0];

                    String output = null;

                    for (int i: temp)
                    {
                        if (output == null) output = Integer.toString(i);
                        else output += " - " + i;
                    }

                    System.out.println(output);
                }
            }

            case ONE_LINE_WITH_CUSTOM_SEPARATOR ->
            {
                if (items.length == 2 && items[0] instanceof int[] && items[1] instanceof String)
                {
                    int[] temp = (int[]) items[0];
                    String separator = (String) items[1];

                    String output = null;

                    for (int i: temp)
                    {
                        if (output == null) output = Integer.toString(i);
                        else output += " " + separator + " " + i;
                    }

                    System.out.println(output);
                }
            }

            case WITH_PROMPT ->
            {
                if (items.length == 2 && items[0] instanceof int[] && items[1] instanceof String)
                {
                    System.out.println((String) items[1]);

                    int[] temp = (int[]) items[0];
                    String output = null;

                    for (int i: temp)
                    {
                        if (output == null) output = Integer.toString(i);
                        else output += " - " + i;
                    }

                    System.out.println(output);
                }
            }
        }

    }


    public enum Type
    {
        ONE_LINE, ONE_ITEM_ONE_LINE, WITH_PROMPT, ONE_LINE_WITH_CUSTOM_SEPARATOR
    }
}
