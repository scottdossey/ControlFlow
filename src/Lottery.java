import java.util.Scanner;
import java.util.Random;

public class Lottery
{
    // I cheat and use a subroutine to get things in range
    // With what you guys might know already
    // you'll have to repeat yourself.

    // This is actually probably a bad example of what to do
    // given your current knowledge, as this will be hard
    // to understand. Suffice it to say, this returns
    // a number that is value but adjusted so it is in range.
    public static int inRange(int value, int low, int high)
    {
        int width = high - low + 1;

        // This block of code keeps adding by the size of the
        // range until value >= low.
        while(value < low)
        {
            value += width;
        }

        // And this is a trick to instantly fix the high range.
        return (value - low) % width + low;
    }

    /*
     * This is another cheat subroutine. It checks to see if value is "y" or "yes"
     * and returns true if so, otherwise false.
     */
    public static boolean yesCheck(String value)
    {
        return value.equals("y") || value.equals("yes");
    }

    // From here on out we don't "cheat". Well, except
    // we use an array.
    public static void main(String[] args)
    {
        Random random = new Random();

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = input.nextLine();

        System.out.println("Hello " + name);

        System.out.print("Do you wish to continue: ");

        String prompt = input.nextLine();
        if(yesCheck(prompt))
        {
            boolean playAgain = false;
            do
            {
                System.out.print("Do you have a red car? ");
                prompt = input.nextLine();
                boolean redCar = yesCheck(prompt);

                System.out.print("What is the name of your favorite pet? ");
                String petName = input.nextLine();

                System.out.print("What is the age of your favorite pet? ");
                int petAge = Integer.parseInt(input.nextLine());

                System.out.print("What is your lucky number? ");
                int luckyNumber = Integer.parseInt(input.nextLine());

                System.out.print("Do you have a favorite quarterback? ");
                prompt = input.nextLine();
                boolean favoriteQBExists = yesCheck(prompt);
                int qbJersey = -1;

                if(favoriteQBExists)
                {
                    System.out.print("What is their jersey number? ");
                    qbJersey = Integer.parseInt(input.nextLine());
                }

                System.out.print("What is the two digit model year of your car? ");
                int carYear = Integer.parseInt(input.nextLine());

                System.out.print("What is the first name of your favorite actor or actress? ");
                String actorName = input.nextLine();

                System.out.print("Enter a random number between 1 and 50: ");
                int userRandomNumber = Integer.parseInt(input.nextLine());

                int generatedRandomA = random.nextInt(100) + 1;
                int generatedRandomB = random.nextInt(100) + 1;

                // Now to generate correct numbers.
                int magicBall;
                if(favoriteQBExists)
                {
                    magicBall = generatedRandomA * qbJersey;
                }
                else
                {
                    magicBall = generatedRandomA * luckyNumber;
                }

                magicBall = inRange(magicBall, 1, 75);

                int[] balls = new int[5];

                if(petName.length() >= 3)
                {
                    balls[0] = (int) (petName.charAt(2));
                }
                else
                {
                    balls[0] = carYear + luckyNumber;
                }

                balls[1] = userRandomNumber - generatedRandomB;
                balls[2] = (int) actorName.charAt(0);
                balls[3] = (int) actorName.charAt(actorName.length() - 1);
                balls[4] = petAge + carYear;

                for(int i = 0; i < balls.length; ++i)
                {
                    balls[i] = inRange(balls[i], 1, 65);
                }

                java.util.Arrays.sort(balls);
                System.out.printf("Lottery numbers: %d, %d, %d, %d, %d Magic ball: %d\n", balls[0], balls[1], balls[2], balls[3], balls[4], magicBall);

                System.out.print("Do you want to play again: ");
                prompt = input.nextLine();
                playAgain = yesCheck(prompt);
            } while(playAgain);
            System.out.println("Thanks for playing!");
        }
        else
        {
            System.out.println("Please return later to complete the survey.");
        }
    }
}
