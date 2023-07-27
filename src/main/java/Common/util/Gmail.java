package Common.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication("qmflcl072165@gmail.com", "wmbvaoqnyrwldhvg");
   }
}
