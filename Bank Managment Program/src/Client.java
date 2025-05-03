import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {

    private String clientName;
    private String clientMiddleName;
    private String clientLastName;
    private int clientAge;

    public final Map<String, String> ClientDetailsMap = new HashMap<>();

    public String getClientName() {
        return clientName;
    }

    public String getClientMiddleName() {
        return clientMiddleName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public Client(String clientName, String clientMiddleName, String clientLastName, int clientAge) {
        this.clientName = clientName;
        this.clientMiddleName = clientMiddleName;
        this.clientLastName = clientLastName;
        this.clientAge = clientAge;

        ClientDetailsMap.put("Name", clientName);
        ClientDetailsMap.put("Middle Name", clientMiddleName);
        ClientDetailsMap.put("Client Last Name", clientLastName);
        ClientDetailsMap.put("Age", Integer.toString(clientAge));
        ClientDetailsMap.put("SSN", Integer.toString(generateClientSSN()));
        ClientDetailsMap.put("Overdraw", "0");
        ClientDetailsMap.put("Money", "0");
    }

    private int generateClientSSN(){

        int generatedNumber;
        Random random = new Random();

        generatedNumber = 100_000_000 + random.nextInt(100_000_000, 999_999_999) + 1;
        return generatedNumber;
    }

}
