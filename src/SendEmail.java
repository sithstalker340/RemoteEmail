import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
/**
 * Sends Email to the recipient.
 * @author Adam Audycki
 *
 */
public class SendEmail {
	
	/**
	 * Sends an email to the given email address.
	 * @param rec - String of the recipient
	 * @param sub - String of the subject line.
	 * @param mes - String of the body of the email.
	 */
	public void sendMail(String rec,String sub, String mes) {
		final String sender = "Test@gmail.com";
		String recipient = rec;
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(sub);
			message.setText(mes);
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
