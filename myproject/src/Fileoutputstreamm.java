import java.io.FileOutputStream;
class FileOutputStreamExamplee
{
    public static void main(String... s)
    {
        try{
            FileOutputStream fout=new FileOutputStream("D:\\testout.txt");
            String s="Welcome to javaTpoint.";
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }
        catch(Exception e)
        {System.out.println(e);}
    }
}