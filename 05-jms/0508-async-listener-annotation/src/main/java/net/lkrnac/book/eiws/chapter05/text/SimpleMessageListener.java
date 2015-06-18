package net.lkrnac.book.eiws.chapter05.text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageListener {
  private SimpleService simpleService;

  @Autowired
  public SimpleMessageListener(SimpleService simpleService) {
    super();
    this.simpleService = simpleService;
  }

  @JmsListener(destination = "queue/ExpiryQueue")
  public void readMessage(String message) {
    simpleService.processText(message);
  }
}
