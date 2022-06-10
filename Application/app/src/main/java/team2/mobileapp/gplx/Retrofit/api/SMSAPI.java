package team2.mobileapp.gplx.Retrofit.api;

import android.telephony.SmsManager;

public class SMSAPI {
    SmsManager smsManager;
    public void sentMessage(String phone, String message){
        smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, message ,null, null);
    }

}
