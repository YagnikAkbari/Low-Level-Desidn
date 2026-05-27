package com.library.entity;

public class EmailNotifier implements Notifier {
  private String toEmail;
  private String fromEmail;
  private String clienId;
  private String clienSecret;

  public EmailNotifier() {
    this.fromEmail = "support@library.com";
    this.clienId = "SKJAECJDKFCNS4543j5bmjK";
    this.clienSecret = "SKJAECJDKFCNSasdfsdjgvn";
  }

  public void setFromEmail(String fromEmail) {
    this.fromEmail = fromEmail;
  }

}
