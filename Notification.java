package com.pari.poc;

public class Notification {
    private boolean isRead = false;
    private String receiver;

    public Notification(String recevier) {
        this.receiver = recevier;
    }

    public boolean validReceiver() {

        if (!receiver.isEmpty()||!receiver.equalsIgnoreCase("null"))
        {
            return true;
        }else {
            return false;
        }
    }

    public void markAsRead() {
        if (isRead){
           isRead=true;
        }else {
            isRead=true;
        }

    }

    public String  status() {
        if (isRead){
            return "read";
        }else {
            return "unread";
        }
    }

}


class EmailNotification extends Notification{

    public EmailNotification(String recevier) {
        super(recevier);
    }

    public String status(){

        String ps=super.status();
        return ps+"-email";
    }


    public static void main(String[] args) {
        Notification notification = new Notification("pari");
        String result1=notification.status();
        System.out.println(result1);

        Notification Enotification = new EmailNotification("pari");
        String result2=Enotification.status();
        System.out.println(result2);
    }
}