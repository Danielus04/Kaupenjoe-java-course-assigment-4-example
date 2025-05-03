public class Main {
    public static void main(String[] args) {

        Bank.openCheckingAccount("Katarzyna", "", "Spermanyn", 32, 103);
        Bank.openCheckingAccount("Tomasz", "Skurwiel", "Piwosz", 18, 33);
        Bank.openCheckingAccount("Maciej", "", "Kutas", 24, 218);
        Bank.setMaxOverdrawAmount("Katarzyna Spermanyn", 35f);

        CheckingAccount.withdrawMoneyFromAccount("Katarzyna Spermanyn", 30);
        CheckingAccount.checkAccountFunds("Katarzyna Spermanyn");

        Bank.checkForClientInDatabase("Katarzyna Spermanyn");
        Bank.checkForClientInDatabase("Tomasz Piwosz");
        Bank.checkForClientInDatabase("Maciej Kutas");

        CheckingAccount.depositMoneyToAccount("Maciej Kutas", 1564);
        CheckingAccount.checkAccountFunds("Maciej Kutas");
        }

    }