    /**
    * Dit is een programma
    * @author A M
    */
    public class oef5 {
	   /**
        * Dit is de main methode
        * @param arg[] dit zijn parameters die met de commandline meekomen
        */
    
    public static void main (String arg[])
	{
        int i;
        int o;
        boolean boolvalue;
        
        for (i=3;i<100;i++)
        {
            boolvalue = true;
            for (o=2;o<i;o++)
            {
               if(i % o == 0)
               {
                  boolvalue = false;
               }
            }
            if (boolvalue) {
                System.out.println(i);
            }
        }
    }
}

