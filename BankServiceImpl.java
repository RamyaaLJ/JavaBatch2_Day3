package javafile;

public class BankServiceImpl implements BankService{
    @Override
    public Double addFundsToAccount(Account accountObjRef, Double amount) throws AccountException {
        if(accountObjRef==null){
            //System.out.println("Account can't be null");-->these two lines are before learning about the exception.
            //return null;//exit with a null value
            throw new AccountException("Account can't be null");
        }
        if(amount<0){
            throw new AccountException("Amount should be greater than or equal to Rs.1");
        }
        accountObjRef.setBalance(accountObjRef.getBalance()+amount);
        return accountObjRef.getBalance();
    }

    @Override
    public Double withdrawFundsFromAccount(Account account, Double amount) throws WithdrawException{
        if(account.getBalance()<=0){
            //System.out.println("Insufficient balance!Can't withraw");
            throw new WithdrawException("Insufficient balance!Can't withraw");
            //return null;
        }
        if(account==null){
            //System.out.println("Account can't be null");
            //return null;//exit with a null value
            throw new WithdrawException("Account can't be null");
        }
        account.setBalance(account.getBalance()-amount);
        return account.getBalance();
    }

    @Override
    public Boolean fundTransfer(Account fromAccount, Account toAccount, Double amount) throws FundTransferException {
        if(fromAccount.getBalance()<amount){
            //System.out.println("Not sufficient amount to send");
            //return null;
            throw new FundTransferException("Insufficient Amount to send");
        }
        if(toAccount.getBalance()<0 || amount<0){
            /*System.out.println("Amount should be greater than or equal to 1");
            return null;*/
            throw new FundTransferException("Amount should be greater than or equal to 1");
        }
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);
        return true;
    }

    @Override
    public void displayAccountInfo() {

    }
}
