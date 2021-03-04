

/*
 * CIS 2122
 * 01/26/2020
 * Jeremy L. Shepherd
 * Menu-driven Calculator
 * A menu driven console program that takes in user input to 
 * calculate basic math functions of 2 numbers and return a calculation.
 * Also generate a random number based on a range of numbers.
 */

import java.util.Scanner;

public class ShepherdJeremyMenuDrivenCalculator  {
	
	static Scanner input = new Scanner(System.in);
	
	public static int menu() {
		int choice;
		
		System.out.println("Calculator Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Generate Random Number");
		System.out.println("6. Quit");
		System.out.print("What would you like to do? ");
		choice = input.nextInt();
		
		return choice;
	}
	
	public static double getNum(String message) {		
		double num;
		
		System.out.print(message);
		num = input.nextDouble();
		return num;
	}
	
	public static double generateRandomNum(double num1, double num2) {
		
		//Warning to explain result
		if (num1 > num2)
			System.out.println("***Warning*** The lower limit is greater than the upper limit!*******");
		double randomVal = Math.random();
		return randomVal * num2 + num1;
	}	
		
	public static void main(String[] args) {
		
		double num1 = 0, num2 = 0, result;
		int menuChoice, errInput = 0;
		
		menuChoice = menu();
		
		while(menuChoice != 6) {
			
			//Eliminated repeated calls to getNum by employing ternary for different input message
			String message1 = menuChoice == 5 ? "What is the lower limit? " : "What is the first number? ";
			String message2 = menuChoice == 5 ? "What is the upper limit? " : "What is the second number? ";
			
			//Only get input if needed
			if(menuChoice >= 1 && menuChoice <= 5) {
				num1 = getNum(message1);
				num2 = getNum(message2);
				//Resets errInput counter upon a valid selection
				errInput = 0;
			}
			
			switch(menuChoice) {
				case 1:
					result = num1 + num2;
					System.out.println("Answer: " + result);
					break;
				case 2:
					result = num1 - num2;
					System.out.println("Answer: " + result);
					break;
				case 3:
					result = num1 * num2;
					System.out.println("Answer: " + result);
					break;
				case 4:
					if(num2 == 0) {
						System.out.println("I'm sorry, you can't divide by zero.");
					} else {
						result = num1 / num2;
						System.out.println("Answer: " + result);
					}
					break;
				case 5:
					result = generateRandomNum(num1, num2);
					System.out.println("Answer: " + result);
					break;			
				default:
					System.out.println("I'm sorry, " + menuChoice + " wasn't one of the options");			
					errInput++;
					
			}	
			System.out.println("");
			if(errInput == 3)
				System.out.println("Please try again later.");
			menuChoice = errInput == 3 ? 6: menu();
		}			
		
		input.close();
		System.out.println("Thank you for using Shepherd's Calculator!");
		System.out.println("Goodbye!");
	}
}

