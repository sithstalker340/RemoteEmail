import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

/**
 * Sends Email to the recipient.
 * 
 * @author Adam Audycki
 *
 */
public class SendEmail {

	/**
	 * Sends an email to the given email address.
	 * 
	 * @param rec
	 *            - String of the recipient
	 * @param sub
	 *            - String of the subject line.
	 * @param mes
	 *            - String of the body of the email.
	 * @param send
	 *            - String of Sender.
	 * @param pass
	 *            - String of Password for Sender.
	 */
	public static void sendMail(String rec, String sub, String mes,
			String send, String pass) {
		final String sender = send;
		String recipient = rec;
		String host = "smtp.mail.yahoo.com";
		final int port = 587;
		final String password = pass;

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", sender);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject(sub);
			message.setText(mes);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, sender, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
