    /**
    * Dit is een programma
    * @author A M
    */
    public class oef3 {
	   /**
        * Dit is de main methode
        * @param arg[] dit zijn parameters die met de commandline meekomen
        */
    
    public static void main (String arg[])
	{
        double pi;
        double m = 0;
        int i;
        int o = 0;
        
        for (i=1;o<=10000;i+=4)
            {
            m += (((float)1/i) - ((float)1/(i+2))); 
            o++;
            }
        
            pi = 4*m;
        System.out.println("pi = " + pi);
    }
}

