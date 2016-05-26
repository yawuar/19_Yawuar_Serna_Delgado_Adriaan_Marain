    /**
    * Dit is een programma
    * @author A M
    */
    public class oef7 {
	   /**
        * Dit is de main methode
        * @param arg[] dit zijn parameters die met de commandline meekomen
        */
    
        
        
    public static void main (String arg[])
	{
        sort();
    }
    public static void sort ()
    {
        int a[] = {12,34,56,78,123,234,99,88};
        int b[] = {0,0,0,0,0,0,0,0};
        
        int disp;
        int counter;
        int i;
        int tempnum;
        int biggestnumindex = 0;
        int biggestnum;
        
        for (counter = 0;counter<a.length;counter++)
        {
            biggestnum = a[0];
            for (i=1;i<a.length;i++)
            {
                tempnum = a[i];
                if (tempnum>biggestnum)
                {
                    biggestnum = a[i];
                    biggestnumindex = i;
                }
            }
            b[counter] = biggestnum;
            a[biggestnumindex] = 0;
            biggestnum = 0;
        }
        
        for (disp = 0;disp<b.length;disp++)
        {
            System.out.println(b[disp]);
        }
    }
}

