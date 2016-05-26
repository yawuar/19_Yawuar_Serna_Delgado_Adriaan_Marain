    /**
    * Dit is een programma
    * @author A M
    */
    public class oef6 {
	   /**
        * Dit is de main methode
        * @param arg[] dit zijn parameters die met de commandline meekomen
        */
    
    public static void main (String arg[])
	{
        int a[] = {12,34,56,78,123,234,99,88};
        
        int i;
        int tempnum;
        int biggestnum = a[0];
        
        for (i=1;i<a.length;i++)
        {
            tempnum = a[i];
            if (tempnum>biggestnum)
            {
                biggestnum = a[i];
            }
        }
        System.out.println(biggestnum);
    }
}

