package com.library.service;

import java.util.List;

import com.library.entity.EmailNotifier;
import com.library.entity.Notifier;
import com.library.entity.SMSNotifier;

public class NotificationService {
  private final List<Notifier> notifiers;

  public NotificationService() {
    this.notifiers = List.of(new EmailNotifier(), new SMSNotifier());
  }

  public void notifyUser(String recipient, String message) {
    for (Notifier notifier : this.notifiers) {
      notifier.notifyUser(recipient, message);
    }
  }
}
