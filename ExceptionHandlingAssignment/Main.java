package ExceptionHandlingAssignment;

public class Main {
	
	public static void main(String[] args) {
		
	Account account = new Account(25600,"Sanket",4000);
	int deposit = 500;
	int withdraw = 6000;

	try {
		System.out.println("Current Balance:"+account.getBalance());
		System.out.println("Depositing "+ deposit+" :New Balance"+account.doDeposit(deposit));
		System.out.println("Withdrawing "+ withdraw+" :New Balance"+account.doWithdrawal(withdraw));
	}
	catch(InsufficientFundException e) {
		System.out.println("Error !! :\n"+e.getMessage());
	}
}
}
