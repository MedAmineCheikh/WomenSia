package tn.esprit.spring.config;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
