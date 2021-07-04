#Lab7: Account Class

###Part 1:
<span style="color:green;">**Account**</span> Class should have:

* `name` an automatically created account number starting with 10000000
* `balance`
* `String[] transactions` that logs all deposits/withdrawls. Ex, {"deposit 100", "withdraw 20", "deposit 10"}. This array needs to be resized each transaction, and if there are no transactions, it should be null.
* `toString()` that returns for example "Name: John Doe, Acct: 10001000, Balance: $1.23"
* `void deposit(double amt)`
* `double withdraw(double amt)`

```java
public class Account {
   //account name
   protected String name;
   //account number
   protected int number;
   //account balance
   protected double balance;
   //private static variable to keep track of account number
   private static int counter = 0;
   //String array to keep track of transactions
   protected String[] transactions;

   //default constructor
   public Account(){
       //call another constructor with default name
       this("unknown");
   }
   //constructor
   public Account(String name){
       this.name = name;
       this.number = 10000000 + counter;
       counter++;
       this.balance = 0;
   }

   //Getters
   public String getName() {
       return name;
   }

   public int getNumber() {
       return number;
   }

   public double getBalance() {
       return balance;
   }

   public String[] getTransactions() {
       return transactions;
   }

   //Setter
   public void setName(String name) {
       this.name = name;
   }

   public String toString(){
       return String.format("Name: %s, %s: %d, Balance: $%.2f", this.name,
               this.getAccountDescription(), this.number, this.balance);
   }
   public void deposit(double amt){
       if(amt > 0) {
           this.balance += amt;
           addTransaction("deposit ", amt);
       }
   }
   public double withdraw(double amt){
       this.balance -= amt;
       addTransaction("withdraw ", amt);
       return this.balance;
   }

   //helper function to manage transactions
   protected void addTransaction(String label, double amount){
       //resize the array by making a new one that is 1 element bigger and copy the elements.
       if(this.transactions == null){
           this.transactions = new String[1];
       } else {
           String[] temp = new String[this.transactions.length + 1];
           for (int i = 0; i < this.transactions.length; i++) {
               temp[i] = this.transactions[i];
           }
           this.transactions = temp;
       }
       this.transactions[this.transactions.length - 1] = label + amount;
   }

   //helper function to get the name of the class to be used in toString
   protected String getAccountDescription(){
       return "Acct";
   }
   //helper function for calculating monthly interest
   protected double getMonthlyInterest(double interestRate){
       return this.balance * interestRate / 1200;
   }
}

```
---
###Part 2
SavingsAccount should in addition have:
* an `interestRate` to earn interest
* `applyInterest()` that applies 1 month of interest to the account (+ interestRate / 12)
* `toString()` that returns for example "Name: John Doe, Savings Acct: 10001000, Balance: $1.23, Interest: 2.01%"

```java
public class SavingsAccount extends Account{
   private double interestRate;

   /**
    * apply 1 month of interest
    */
   public void applyInterest(){
       double interest = getMonthlyInterest(this.interestRate);
       this.balance += interest;
       addTransaction("interest deposit ",  interest);
   }

   //default constructor
   public SavingsAccount(){
       this("unknown", 2.01);
   }
   //constructor
   public SavingsAccount(String name, double interestRate){
       super(name);
       this.interestRate = interestRate;
   }

   @Override
   protected String getAccountDescription() {
       return "Savings Acct";
   }

   //Getter
   public double getInterestRate() {
       return interestRate;
   }

   @Override
   public String toString(){
       return super.toString() + ", Interest: " + this.interestRate + "%";
   }
}

```
---
### Part 3
<span style="color:green;">**CreditCardAccount**</span> should in addition have
* an `interestRate` to pay interest
* a `description` of Visa, Mastercard, Amex
* `chargeInterest()` that charges 1 month of interest to the account (- interestRate / 12)
* `charge()` and `pay()` methods. balance should usually be negative, and charge makes it more negative, pay makes it more positive. The balance can go above 0.
* `toString()` that returns for example "Name: John Doe, Visa Acct: 10001000, Balance: $1.23, Interest: 20.01%"
```java
public class CreditCardAccount extends Account{
   public static final String TYPE_VISA = "Visa";
   public static final String TYPE_MASTERCARD = "Mastercard";
   public static final String TYPE_AMEX = "Amex";

   private double interestRate;

   private String creditCardType;

   /**
    * charge 1 month of interest
    */
   public void chargeInterest(){
       double interest = getMonthlyInterest(this.interestRate);
       this.balance -= interest;
       addTransaction("interest deposit ",  -interest);
   }

   /**
    * default constructor
    */
   public CreditCardAccount(){
       this("unknown", TYPE_VISA, 20.01);
   }
   /**
    * constructor
    * @param name
    * @param creditCardType
    * @param interestRate
    */
   public CreditCardAccount(String name, String creditCardType, double interestRate){
       super(name);
       this.creditCardType = creditCardType;
       this.interestRate = interestRate;
   }

   /**
    * charge the credit card account a certain amount
    * @param amt
    * @return
    */
   public double charge(double amt){
       this.balance -= amt;
       addTransaction("charge ", -amt);
       return this.balance;
   }

   /**
    * make a payment to the credit card account
    * @param amt
    */
   public double pay(double amt){
       this.balance += amt;
       addTransaction("payment ", amt);
       return this.balance;
   }
   @Override
   protected String getAccountDescription() {
       return this.creditCardType + " Acct";
   }

   @Override
   public String toString(){
       return super.toString() + ", Interest: " + this.interestRate + "%";
   }
}

```
---
###Part 4. 
<span style="color:green;">**CheckingAccount**</span> should in addition have
* `toString()` that returns for example "Name: John Doe, Checking Acct: 10001000, Balance: $1.23"
```java
public class CheckingAccount extends Account{
   /**
    * default constructor
    */
   public CheckingAccount(){
       this("unknown");
   }

   /**
    * constructor
    * @param name
    */
   public CheckingAccount(String name){
       super(name);
   }

   @Override
   protected String getAccountDescription() {
       return "Checking Acct";
   }
}

```
---
###Part 5. 
Create a menu for an online banking system:
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
9. Exit

Deposit/Pay and Withdraw/Charge can ask for the account number first.
Print report of all accounts should just print out their toString()'s.
Print all transactions should look something like this:
<pre>
   	Account 10000000:
			Deposit 10
			Withdraw 5
		Account 10000001
			Deposit 100
		Account 10000002
		Account 10000003
			Charge 50
			Pay 20
</pre>
```java
public class BankingSystem {
   private Account[] accountsDB;
   public BankingSystem(){
       this.accountsDB = null;
   }
   public void run(){
       while(true){
           int choice = mainMenu();
           if(choice == 1){    //create a new account
               createNewAccount();
           }else if(choice == 2){  //deposit/pay
               depositOrPay();
           } else if(choice == 3){ //withdraw/charge
               withdrawOrCharge();
           } else if(choice == 4){ //print report
               printAllAccounts(accountsDB);
           } else if(choice == 5){ //print transactions
               printAllTransactions();
           } else if(choice == 6){ //apply interest
               applyInterest();
           } else if(choice == 7){
               depositMoney();
           } else if(choice == 8){
               break;
           } else {
               System.out.println("Please choose a valid option");
           }
       }
   }

   public int mainMenu(){
       System.out.println("1. Create new account\n" +
               "2. Deposit/Pay\n" +
               "3. Withdraw/Charge\n" +
               "4. Print report of all accounts\n" +
               "5. Print all transactions\n" +
               "6. Apply Interest\n" +
               "7. Deposit money into all accounts\n" +
               "8. Exit");
       Scanner s = new Scanner(System.in);
       return s.nextInt();
   }

   public void createNewAccount(){
       //ask for name
       System.out.println("What is your name?: ");
       Scanner n = new Scanner(System.in);
       String name = n.nextLine();

       //choose the type of account
       System.out.println("Welcome, " + name + ". What type of account do you want to create?\n");
       System.out.println("1. Savings Account");
       System.out.println("2. CreditCardAccount");
       System.out.println("3. Checking Account");
       System.out.println("\nSelect by entering the number next to your choice.");

       Scanner a = new Scanner(System.in);
       int accountType = a.nextInt();

       //create the account
       if(accountType == 1){   //savings account
           System.out.println("What is the interest rate?");
           Scanner r = new Scanner(System.in);
           double rate = r.nextDouble();

           addAccount(new SavingsAccount(name, rate));
       } else if(accountType == 2){    //credit card account
           System.out.println("What type of credit card do you want?");
           System.out.println("Type in either 'Visa', 'Mastercard', or 'Amex'. CASE SENSITIVE");

           Scanner t = new Scanner(System.in);
           String type = t.next();

           System.out.println("What is the interest rate?");
           Scanner r = new Scanner(System.in);
           double rate = r.nextDouble();

           addAccount(new CreditCardAccount(name, type, rate));
       } else if(accountType == 3){    //checking account
           addAccount(new CheckingAccount(name));
       }

       System.out.println("Your account has been successfully created.");
   }

   public void depositOrPay(){
       System.out.println("Which account do you want to deposit the money in?\n");

       //print all accounts so that user can decide
       printAllAccounts(accountsDB);
       System.out.println("\nChoose the desired account by entering the account number: ");

       Scanner n = new Scanner(System.in);
       Account account = getAccount(n.nextInt());
       if(account == null){
           System.out.println("Invalid account");
           return;
       }
       //if it is a credit card, ask user if they want to deposit or charge
       if(account instanceof CreditCardAccount){
           System.out.println("Would you like to deposit or charge?");
           System.out.println("Enter 1 if you want to deposit, or 2 if you want to charge.");

           Scanner c = new Scanner(System.in);
           int choose = c.nextInt();

           if(choose == 1){    //deposit
               System.out.println("How much do you want to deposit?");
               Scanner m = new Scanner(System.in);
               double money = m.nextDouble();

               account.deposit(money);
               System.out.println("Successfully deposited $" + money + " into Account " + (account.getNumber()));
               System.out.println("Your balance is now $" + account.balance);
           } else if(choose == 2){ //pay
               System.out.println("How much do you want to pay?");
               Scanner m = new Scanner(System.in);
               double money = m.nextDouble();

               ((CreditCardAccount) account).pay(money);
               System.out.println("Successfully paid Account " + (account.getNumber()) + " $" + money);
               System.out.println("Your balance is now $" + account.balance);
           }
       } else {
           System.out.println("How much do you want to deposit?");
           Scanner m = new Scanner(System.in);
           double money = m.nextDouble();

           account.deposit(money);
           System.out.println("Successfully deposited $" + money + " into Account " + (account.getNumber()));
           System.out.println("Your balance is now $" + account.balance);
       }
   }

   public void withdrawOrCharge(){
       System.out.println("Which account do you want to withdraw the money from?\n");
       //print all accounts so that user can decide
       printAllAccounts(accountsDB);
       System.out.println("\nChoose the desired account by entering the account number: ");
       Scanner n = new Scanner(System.in);
       Account account = getAccount(n.nextInt());

       if(account == null){
           System.out.println("Invalid account");
           return;
       }
       //if it is a credit card, ask user if they want to withdraw or charge
       if(account instanceof CreditCardAccount){
           System.out.println("Would you like to withdraw or charge?");
           System.out.println("Enter 1 if you want to withdraw, or 2 if you want to charge.");
           Scanner c = new Scanner(System.in);
           int choose = c.nextInt();

           if(choose == 1){
               System.out.println("How much do you want to withdraw?");
               Scanner m = new Scanner(System.in);
               double money = m.nextDouble();

               account.withdraw(money);
               System.out.println("Successfully withdrew $" + money + " from Account " + (account.getNumber()));
               System.out.println("Your balance is now $" + account.balance);
           } else if(choose == 2){
               System.out.println("How much do you want to charge?");
               Scanner m = new Scanner(System.in);
               double money = m.nextDouble();

               ((CreditCardAccount) account).charge(money);
               System.out.println("Successfully charged Account " + (account.getNumber()) + " $" + money);
               System.out.println("Your balance is now $" + account.balance);
           }
       } else {
           System.out.println("How much do you want to withdraw?");
           Scanner m = new Scanner(System.in);
           double money = m.nextDouble();

           account.withdraw(money);
           System.out.println("Successfully withdrew $" + money + " from Account " + (account.getNumber()));
           System.out.println("Your balance is now $" + account.balance);
       }
   }

   public void printAllTransactions(){
       if(!isValidAccountsDB()){
           return;
       }
       for(int i = 0; i < accountsDB.length; i++) {
           System.out.println("Account " + accountsDB[i].number + ":");

           for(int j = 0; j < accountsDB[i].transactions.length; j++){
               System.out.println("\t" + accountsDB[i].transactions[j]);
           }
       }
   }

   public void applyInterest(){
       if(!isValidAccountsDB()){
           return;
       }
       System.out.println("Which account would you like to apply interest to? " +
               "It can only be a Savings or Credit Card account");

       //print all accounts so that user can decide
       printAllAccounts(accountsDB);

       System.out.println("\nChoose the desired account by entering the account number: ");
       Scanner n = new Scanner(System.in);
       Account account = getAccount(n.nextInt());
       if(account == null){
           System.out.println("Invalid account");
           return;
       }

       System.out.println("How many months would you like to apply interest?");
       Scanner m = new Scanner(System.in);
       int months = m.nextInt();

       //apply interest
       if(account instanceof SavingsAccount) {   //apply interest for savings account
           for (int i = 0; i < months; i++) {
               ((SavingsAccount) account).applyInterest();
           }
       } else if(account instanceof CreditCardAccount){  //apply interest for credit card account
           for(int i = 0; i < months; i++){
               ((CreditCardAccount) account).chargeInterest();
           }
       }
   }

   public void depositMoney(){
       if(!isValidAccountsDB()){
           return;
       }
       for(int i = 0; i < accountsDB.length; i++){
           for(int j = 1; j <= 20; j++){
               accountsDB[i].deposit(j);
           }
       }
   }

   //checks if accountsDB is null
   private boolean isValidAccountsDB(){
       if(accountsDB == null){
           System.out.println("No accounts created");
           return false;
       } else {
           return true;
       }
   }

   //helper function to save account to banking system
   private void addAccount(Account account){
       if(this.accountsDB == null){
           this.accountsDB = new Account[1];
       }else{
           //resize array
           Account[] temp = new Account[this.accountsDB.length + 1];
           for(int i = 0; i < this.accountsDB.length; i++){
               temp[i] = this.accountsDB[i];
           }
           this.accountsDB = temp;
       }
       //save account in last position of account array
       this.accountsDB[this.accountsDB.length - 1] = account;
   }
   //helper function to get account using account number
   private Account getAccount(int accountNumber){
       if(isValidAccountsDB()) {
           for (int i = 0; i < this.accountsDB.length; i++) {
               if (this.accountsDB[i].getNumber() == accountNumber) {
                   return this.accountsDB[i];
               }
           }
       }
       return null;
   }
   //printing all accounts
   public void printAllAccounts(Account[] a){
       if(isValidAccountsDB()) {
           for (int i = 0; i < this.accountsDB.length; i++) {
               System.out.println(this.accountsDB[i].toString());
           }
       }
   }
}
```
---
###Part 6. 
Create a 6th menu option to advance time an inputted number of months and applies the appropriate interest. Applying 6 months of interest should apply 1 month of interest 6 times.
```java
public void applyInterest(){
   if(!isValidAccountsDB()){
       return;
   }
   System.out.println("Which account would you like to apply interest to? " +
           "It can only be a Savings or Credit Card account");

   //print all accounts so that user can decide
   printAllAccounts(accountsDB);

   System.out.println("\nChoose the desired account by entering the account number: ");
   Scanner n = new Scanner(System.in);
   Account account = getAccount(n.nextInt());
   if(account == null){
       System.out.println("Invalid account");
       return;
   }

   System.out.println("How many months would you like to apply interest?");
   Scanner m = new Scanner(System.in);
   int months = m.nextInt();

   //apply interest
   if(account instanceof SavingsAccount) {   //apply interest for savings account
       for (int i = 0; i < months; i++) {
           ((SavingsAccount) account).applyInterest();
       }
   } else if(account instanceof CreditCardAccount){  //apply interest for credit card account
       for(int i = 0; i < months; i++){
           ((CreditCardAccount) account).chargeInterest();
       }
   }
}
```
---
###Part 7. 
Create a 7th menu option that deposits $1, $2, ... , $20 into each account. Put 20 deposits in each account.
```java
public void depositMoney(){
   if(!isValidAccountsDB()){
       return;
   }
   for(int i = 0; i < accountsDB.length; i++){
       for(int j = 1; j <= 20; j++){
           accountsDB[i].deposit(j);
       }
   }
}
```
####Task1. 
Create a SavingsAccount, CreditCardAccount, and CheckingAccount with whatever realistic information you want. Print report of all accounts. Make sure all menu options work properly.
<pre>
OUTPUT:
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
1
What is your name?: 
Ayush
Welcome, Ayush. What type of account do you want to create?

1. Savings Account
2. CreditCardAccount
3. Checking Account

Select by entering the number next to your choice.
1
What is the interest rate?
2.01
Your account has been successfully created.
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
1
What is your name?: 
Ayush
Welcome, Ayush. What type of account do you want to create?

1. Savings Account
2. CreditCardAccount
3. Checking Account

Select by entering the number next to your choice.
2
What type of credit card do you want?
Type in either 'Visa', 'Mastercard', or 'Amex'. CASE SENSITIVE
Visa
What is the interest rate?
20.01
Your account has been successfully created.
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
1
What is your name?: 
Ayush
Welcome, Ayush. What type of account do you want to create?

1. Savings Account
2. CreditCardAccount
3. Checking Account

Select by entering the number next to your choice.
3
Your account has been successfully created.
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
2
Which account do you want to deposit the money in?

Name: Ayush, Savings Acct: 10000000, Balance: $0.00, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $0.00, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $0.00

Choose the desired account by entering the account number: 
10000000
How much do you want to deposit?
1.23
Successfully deposited $1.23 into Account 10000000
Your balance is now $1.23
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
2
Which account do you want to deposit the money in?

Name: Ayush, Savings Acct: 10000000, Balance: $1.23, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $0.00, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $0.00

Choose the desired account by entering the account number: 
10000001
Would you like to deposit or charge?
Enter 1 if you want to deposit, or 2 if you want to charge.
1
How much do you want to deposit?
1.23
Successfully deposited $1.23 into Account 10000001
Your balance is now $1.23
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
2
Which account do you want to deposit the money in?

Name: Ayush, Savings Acct: 10000000, Balance: $1.23, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $1.23, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $0.00

Choose the desired account by entering the account number: 
10000002
How much do you want to deposit?
1.23
Successfully deposited $1.23 into Account 10000002
Your balance is now $1.23
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
3
Which account do you want to withdraw the money from?

Name: Ayush, Savings Acct: 10000000, Balance: $1.23, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $1.23, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $1.23

Choose the desired account by entering the account number: 
1000000
Invalid account
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
3
Which account do you want to withdraw the money from?

Name: Ayush, Savings Acct: 10000000, Balance: $1.23, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $1.23, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $1.23

Choose the desired account by entering the account number: 
10000000
How much do you want to withdraw?
0.23
Successfully withdrew $0.23 from Account 10000000
Your balance is now $1.0
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
6
Which account would you like to apply interest to? It can only be a Savings or Credit Card account
Name: Ayush, Savings Acct: 10000000, Balance: $1.00, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $1.23, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $1.23

Choose the desired account by entering the account number: 
10000000
How many months would you like to apply interest?
3
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
4
Name: Ayush, Savings Acct: 10000000, Balance: $1.01, Interest: 2.01%
Name: Ayush, Visa Acct: 10000001, Balance: $1.23, Interest: 20.01%
Name: Ayush, Checking Acct: 10000002, Balance: $1.23
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
5
Account 10000000:
	deposit 1.23
	withdraw 0.23
	interest deposit 0.0016749999999999998
	interest deposit 0.001677805625
	interest deposit 0.001680615949421875
Account 10000001:
	deposit 1.23
Account 10000002:
	deposit 1.23
1. Create new account
2. Deposit/Pay
3. Withdraw/Charge
4. Print report of all accounts
5. Print all transactions
6. Apply Interest
7. Deposit money into all accounts
8. Exit
8
</pre>

---

Checklist of things to make sure of:
1. You should not have a setBalance() method in Account class. We don't want to magically change balance to some value. Instead, use deposit() and withdraw() any time you want to change the balance.
2. Try not to write code twice. Some ways you can reuse your code:
   * super constructor
   * this constructor
   * super.toString()
   * create helper functions

