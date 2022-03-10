package tn.esprit.spring;

 

import com.fasterxml.jackson.annotation.JsonProperty;

 

public class SmsRequest {

     
    private final String phoneNumber; // destination

 
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return "+21655751134";
    }

    public String getMessage() {
        return "Votre don a etait fait avec succès..l'equipe Womensia est tres reconnaissante pour votre engagement";
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
 
