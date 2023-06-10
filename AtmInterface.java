import java.util.Scanner;

class Atm {

	int userid = 1234;
	int userpin = 5678;

	public boolean login() {
		boolean islogin = false;
		Scanner sc = new Scanner(System.in);
		while (!islogin) {
			System.out.print("\nEnter Userid:");
			int Userid = sc.nextInt();
			if (Userid == userid) {
				while (!islogin) {
					System.out.print("\nEnter Userpin:");
					int Userpin = sc.nextInt();
					if (Userpin == userpin) {
						System.out.println("\n+++++login Successful+++++");
						islogin = true;
					} else {
						System.out.println("\nWrong Password");
					}
				}
			} else {
				System.out.println("\nusername not valid");
			}
		}
		return islogin;
	}

}

class TransactionsHistory {

	public static void transHistory(int transactions, String transactions_history) {
		if (transactions == 0) {
			System.out.println("\nempty");
		} else {
			System.out.println("\n" + transactions_history);
		}
	}
}

class Withdrawal {

	public float withdrawal(int transactions, float balance, String transactions_history, float currentbalance) {
		System.out.print("\nEnter amount to Withdrawal:");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();

		try {
			if (balance >= amount) {

				System.out.println("\nWithdrawal Successful");

				String str = amount + "Rs withdrawal\n";
				transactions_history = transactions_history.concat(str);
				return amount;
			} else {
				System.out.println("\nInsufficient balance:");
			}

		} catch (Exception e) {
			System.out.println("Invalid input!" + e.getMessage());
		}
		return 0;
	}
}

class Deposit {

	public float deposit(int transactions, float balance, String transactions_history, float currentbalance) {
		System.out.print("\nEnter amount to deposit:");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if (amount <= 100000f) {

				System.out.println("\nSuccessful deposited");
				String str = amount + "Rs deposit\n";
				transactions_history = transactions_history.concat(str);
				return amount;
			} else {
				System.out.println("\nsorry ! limit is 100000.00");
			}

		} catch (Exception e) {
			System.out.println("Invalid input!" + e.getMessage());
		}
		return 0;
	}
}

class Transfer {
	public float transfer(int transactions, float balance, String transactions_history, float currentbalance) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's name:");
		String Receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer:");
		float amount = sc.nextFloat();

		try {
			if (balance >= amount) {
				if (amount <= 25000f) {
					transactions++;
					balance -= amount;
					System.out.println(amount + " Rs " + "Successfully transfer to " + Receipent);
					String str = amount + "Rs transfer to " + Receipent + "\n";
					transactions_history = transactions_history.concat(str);
				} else {
					System.out.println("\nsorry ! limit is 5000.00:");
				}
				return amount;
			} else {
				System.out.println("\nYour account balance is not sufficient.");
			}
		} catch (Exception e) {
			System.out.println("Invalid input!" + e.getMessage());
		}
		return 0;
	}
}

class AtmInterface {

	public static void main(String[] args) {
		float balance = 100000f;
		int transactions = 0;
		String transactions_history = "";
		float currentbalance = balance;
		Atm b = new Atm();
		b.login();

		Scanner sc = new Scanner(System.in);

		System.out.println("\nATM Menu:");
		System.out.println("1. Transactions History");
		System.out.println("2. Withdrawal");
		System.out.println("3. Deposit");
		System.out.println("4. Transfer");
		System.out.println("5. CheckBalance");
		System.out.println("6. Quit");

		boolean quit = false;
		while (!quit) {
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					TransactionsHistory th = new TransactionsHistory();
					th.transHistory(transactions, transactions_history);
					break;
				case 2:
					Withdrawal w = new Withdrawal();
					float withdrawal = w.withdrawal(transactions, balance, transactions_history, currentbalance);
					if (withdrawal != 0) {
						transactions++;
						currentbalance -= withdrawal;
						String str = withdrawal + "Rs withdrawal\n";
						transactions_history = transactions_history.concat(str);
					}
					break;

				case 3:
					Deposit dp = new Deposit();
					float deposit = dp.deposit(transactions, balance, transactions_history, currentbalance);

					if (deposit != 0) {
						transactions++;
						currentbalance += deposit;
						String str = deposit + "Rs deposited\n";
						transactions_history = transactions_history.concat(str);
					}
					break;

				case 4:
					Transfer t = new Transfer();
					float transfer = t.transfer(transactions, balance, transactions_history, currentbalance);
					if (transfer != 0) {
						transactions++;
						currentbalance -= transfer;
						String str = transfer + "Rs transfer\n";
						transactions_history = transactions_history.concat(str);
					}
					break;

				case 5:

					System.out.println("\ncurrent balance = " + currentbalance + " Rs");

					break;
				case 6:
					System.out.println("Thank you for visit");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Try again");
			}
		}
		System.out.println("Thankyou!");
	}

}
