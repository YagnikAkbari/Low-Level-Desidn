package com.library.entity;

public class SMSNotifier implements Notifier {
  private String fromMobileNo;
  private String toMobileNo;
  private String clienId;
  private String clienSecret;

  public SMSNotifier() {
    this.fromMobileNo = "6256325652";
    this.clienId = "SKJAECJDKFCNS4543j5bmjK";
    this.clienSecret = "SKJAECJDKFCNSasdfsdjgvn";
  }

  public void setToMobileNo(String toMobileNo) {
    this.toMobileNo = toMobileNo;
  }

  @Override
  public void notifyUser(String recipient, String message) {
    this.toMobileNo = recipient;
    System.out.println("[SMS] from=" + this.fromMobileNo + " to=" + this.toMobileNo + " message=" + message);
  }
}
