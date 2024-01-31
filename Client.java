package javafile;

public class Client {
    public static void main(String[] args) {
        Account firstaccount=new Account(1,"Ford",5000.0);
        Account secondaccount=new Account(2,"Ford Business Solutions",7000.0);
        //BankServiceImpl bankService=new BankServiceImpl();//tightly coupled
        BankService bankService=new BankServiceImpl();
        System.out.println(firstaccount);

        try {
            //Double newBalance = bankService.addFundsToAccount(firstaccount,750.0);
            Double newBalance = bankService.addFundsToAccount(null,750.0);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(firstaccount);
        //bankService.addFundsToAccount(null,-750.0);

        Double withdrawBalance= null;
        try {
            withdrawBalance = bankService.withdrawFundsFromAccount(firstaccount,300.0);
        } catch (WithdrawException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Current balance"+withdrawBalance);
        System.out.println(firstaccount);

        Boolean fundTransfer= null;
        try {
            fundTransfer = bankService.fundTransfer(firstaccount,secondaccount,200.0);
        } catch (FundTransferException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Whether fund transfered or not?"+fundTransfer);
        System.out.println("First Account Details:"+firstaccount);
        System.out.println("Second Account Details:"+secondaccount);


    }
}
