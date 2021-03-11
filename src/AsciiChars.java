public class AsciiChars
{
    //I use a different form of character literal for
    //setting my characters, because it is more correct
    //and easier to read.
    
    //To run this 
    public static void printNumbers()
    {
        // for (char i=48; i<=57; ++i) <-- Would do the same thing.
        for(char i = '0'; i <= '9'; ++i)
        {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void printLowerCase()
    {
        // for (char i=97; i<=122; ++i) <-- Would do the same thing.
        for(char i = 'a'; i <= 'z'; ++i)
        {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void printUpperCase()
    {
        // for (char i=65; i<=90; ++i) <-- Would do the same thing.
        for(char i = 'A'; i <= 'Z'; ++i)
        {
            System.out.print(i);
        }
        System.out.println();
    }
    
    public static void main(String args[])
    {
        printNumbers();
        printLowerCase();
        printUpperCase();
    }
}