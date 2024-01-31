package javafile;

public interface BankService {
    Double addFundsToAccount(Account accountObjRef,Double amount) throws AccountException;
    Double withdrawFundsFromAccount(Account account,Double amount) throws WithdrawException;
    Boolean fundTransfer(Account fromAccount,Account toAccount,Double amount) throws FundTransferException;
    void displayAccountInfo();
}
