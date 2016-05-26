    /**
    * Dit is een programma
    * @author A M
    */
    public class oef2 {
	   /**
        * Dit is de main methode
        * @param arg[] dit zijn parameters die met de commandline meekomen
        */
    
    public static void main (String arg[])
	{
        int x; int y;
        for (x=1;x<=9;x++)
        {
            for (y=1;y<=9;y++)
            {
                System.out.println(x + " X " +y+" = " +x*y);
            }
        }
        int weekdag = 0;
        for (x=1;x<=28;x++)
        {
            if (weekdag==0) System.out.print("zon"); // green println
            if (weekdag==1) System.out.print("maan"); // green println
            if (weekdag==2) System.out.print("dins"); // green println
            if (weekdag==3) System.out.print("woens"); // green println
            if (weekdag==4) System.out.print("donder"); // green println
            if (weekdag==5) System.out.print("vrij"); // green println
            if (weekdag==6) System.out.print("zater"); // green println
            weekdag++;
                if (weekdag>6) weekdag=0;
                System.out.println("dag " +x+" februari 2009");
        }

    }
}

