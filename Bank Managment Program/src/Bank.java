import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private static Map<String, Map<String, String>> clientList = new HashMap<>();

    private static float maxOverdrawAmount = 0;


    private static String clientAccount(Client client){

        return  client.getClientName() + " " + client.getClientLastName();
    }

    private static void addClient(Client client, Map<String, String> clientDetail){

        clientList.put(clientAccount(client), clientDetail);

        Random random = new Random();
        String CANumber = "";

        for(int i = 0; i < 12; i++){

           int generatedNum = random.nextInt(9) + 1;
           CANumber = CANumber + Integer.toString(generatedNum);
        }
        clientList.get(clientAccount(client)).put("CANumber", String.valueOf(CANumber));
    }

    public static void checkForClientInDatabase(String clientAccount){

        if(!clientList.containsKey(clientAccount)){

            System.out.println("No such bank account in record");

        }
        else System.out.println("Your account is in our database");
    }


    public static void getClientInfo(String clientAccount, String info){

        if (clientList.get(clientAccount).get(info) == null){

            System.out.println("No field with such name found.");
        }
        else
        {
            System.out.println(clientList.get(clientAccount).get(info));
        }

    }
    public static String getClientInfoasString(String clientAccount, String info){

        return clientList.get(clientAccount).get(info);

    }
    public static void modifyClientInfo(String clientAccount, String key, String newValue){

        if (clientList.get(clientAccount).get(key) == null){

            System.out.println("No field with such name found.");
        }
        else
        {
            clientList.get(clientAccount).replace(key, newValue);
        }

    }

    public static void setMaxOverdrawAmount(String client, float ammount){

        clientList.get(client).replace("Overdraw", Float.toString(ammount));
    }

    public static void openCheckingAccount(String clientName, String clientMiddleName, String clientLastName, int clientAge, float firstDepositAmmount){
        Client newClient = new Client(clientName, clientMiddleName, clientLastName, clientAge);

        if(firstDepositAmmount >= 100f){

            Bank.addClient(newClient, newClient.ClientDetailsMap);
            Bank.modifyClientInfo(clientAccount(newClient), "Money", Float.toString(firstDepositAmmount));
            System.out.println("Successfully opened new bank account for " + clientAccount(newClient));

        } else {
            System.out.println("Unable to open bank account for " + clientAccount(newClient));
            System.out.println("The first deposit amount is too small to open your bank account.\nYou need at least 100$ as your first deposit.");

        }

    }


}
