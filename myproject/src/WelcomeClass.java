import java.io.FileOutputStream;

public class WelcomeClass {

    public static void main(String args[])
    {
        try
        {
            FileOutputStream fout = new FileOutputStream("/ideaprojects/myproject/src");
            fout.write(98);
            fout.close();
            System.out.println("my name is yogesh sharma");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
