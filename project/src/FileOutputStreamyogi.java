import java.util.*;
class abc
{

        int  add() {
            Scanner scanner=new Scanner(System.in);
            int a;
            int b;
            int z;
            try {
               a=scanner.nextInt();
               b=scanner.nextInt();

              return a + b;

            } catch (ArithmeticException e) {
                System.out.println(e);
            }
            return 0;
        }

    }
    public static void main(String... s)
    {
      abc a=new abc();
        System.out.println(  a.add());




    }

}
