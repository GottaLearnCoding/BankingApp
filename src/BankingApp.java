import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * My first Java Project! This was used as reference: <a
 * href=https://youtu.be/wQbEH4tVMJA>Banking Application</a>
 * 
 * @author Lukas Löwen
 * @version 1.0
 */
public class BankingApp {
	
	/**
	* prints the menu into the console
	* @since     1.0
	*/
	public static void printMenu() {
		System.out.println("==============================================");
		System.out.println("Welcome! Please choose what you want to do:");
		System.out.println("==============================================");
		System.out.println("Press 'A' to deposit money.");
		System.out.println("Press 'B' to withdraw money.");
		System.out.println("Press 'C' to check your balance");
		System.out.println("Press 'D' to see your ID");
		System.out.println("Press 'E' to Exit");
		System.out.println("==============================================");
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//Decimal Format not valid because of the usage of 'long'
		DecimalFormat df = new DecimalFormat("€###,###.##");
		printMenu();
		// System.out.println("\n");

		// Create a TestAccount
		Account myAcc = new Account(20000, 1234, "Lukas Loewen");
		char a = scanner.next().charAt(0);
		long amount;
		// Loop the Menu to execute tasks
		do {
			switch (a) {
			case 'A':
				System.out.println("Please enter the amount you want to store into your account.");
				amount = scanner.nextLong();
				myAcc.deposit(amount);
				printMenu();
				break;
			case 'B':
				System.out.println("Please enter the amount you want to withdraw from your account.");
				amount = scanner.nextLong();
				myAcc.withdraw(amount);
				printMenu();
				break;
			case 'C':
				System.out.println("Your Balance:" +df.format(myAcc.checkBalance()));
				printMenu();
				break;
			case 'D':
				System.out.println("Your ID:" + myAcc.getUserId());
				printMenu();
				break;
			default:
				System.out.println("Error! Please enter a valid character.");
				break;
			}
			a = scanner.next().charAt(0);
		} while (a != 'E');

	}
//Note: had to make inner class public in order for Javadoc to read it!
	public static class Account {
		private long balance;
		private int userId;
		String customerName;
		
		/**
		* Constructor to initiate an example Account 		*
		* @since     1.0
		*/
		public Account(long balance, int userId, String customerName) {
			this.balance = balance;
			this.userId = userId;
			this.customerName = customerName;
		}
		/**
		* @param  a the amount to be deposited
		* @since     1.0
		*/
		public void deposit(long a) {
			balance += a;
		}
		/**
		* @param  a the amount to be withdrawn from account
		* @since     1.0
		*/
		public void withdraw(long a) {
			balance -= a;
		}
		/**
		* @return  Balance of the account
		* @since     1.0
		*/
		public long checkBalance() {

			return balance;
		}
		/**
		* @return  current userId
		* @since     1.0
		*/
		public int getUserId() {

			return userId;
		}

	}
}