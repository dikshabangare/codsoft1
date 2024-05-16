import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Random random = new Random();
		
		
		
		
		int min=1;
		int max=100;
		int attemptsLimit=10;  //limits of attempt per round
		int roundsWon=0;    //counter for rounds won
		boolean playAgain=true;  //flag to control if user wants to play again
		
		System.out.println("Welcome to the Number Game!!");
		
		while(playAgain)
		{
			int targetNumber = random.nextInt(max-min+1)+min;
			int attempts=0;
			boolean guessedCorrectly=false;
			
			System.out.println("I have selected a number between "+min+" and "+max+"");
			
			while(attempts<attemptsLimit && !guessedCorrectly)
			{
				System.out.println("Enter your guess("+(attemptsLimit-attempts)+" attempts left):");
				int guess=scan.nextInt();
				attempts++;
				
				if(guess<targetNumber)
				{
					System.out.println("Too low!!");
					
				}
				else if(guess>targetNumber)
				{
					System.out.println("Too high!!");
				}
				else
				{
					System.out.println("Congratulations!! You have guesssed the number in "+attempts+" attempts");
					roundsWon++;
					guessedCorrectly=true;
				}
			}
			
			if(!guessedCorrectly)
			{
				System.out.println("Sorry!! You have used all your attempts. The correct number was:" +targetNumber);
				
			}
			
			System.out.println("Do you want to play again?(yes/no):");
			String playAgainResponse=scan.next();
			
			playAgain=playAgainResponse.equalsIgnoreCase("yes");
			
		}
		
		System.out.println("Thanks for playing!! your total rounds won:" +roundsWon);
		//scan.close();
		
		
		
		
	}

}
