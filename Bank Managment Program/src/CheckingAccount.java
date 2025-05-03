public class CheckingAccount {

    public static void checkAccountFunds(String clientAccount){

        System.out.println("Your current funds are: " + Bank.getClientInfoasString(clientAccount, "Money") + "$");

    }

    public static void depositMoneyToAccount(String clientAccount, float amount){

        float newAmmount = Float.parseFloat(Bank.getClientInfoasString(clientAccount, "Money"));
        newAmmount = newAmmount + amount;
        Bank.modifyClientInfo(clientAccount, "Money", Float.toString(newAmmount));
    }

    public static void withdrawMoneyFromAccount(String clientAccount, float amount){

        float newAmmount = Float.parseFloat(Bank.getClientInfoasString(clientAccount, "Money"));
        newAmmount = newAmmount - amount;
        Bank.modifyClientInfo(clientAccount, "Money", Float.toString(newAmmount));
    }

}
