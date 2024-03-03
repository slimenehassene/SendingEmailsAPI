package com.sendEmails.Emails.service.utils;

public class EmailUtils {

    public static String getEmailMessage(String name,String host,String token){
        return "Hallo" + name + "\n\nYour new account has bean created please click the link below to verify your account.\n\n"+
                getVerificationUrl(host,token)+"\n\nThe support team";
    }

    public static String getVerificationUrl(String host, String token) {
        return host+"/users?token="+token;
    }


}
