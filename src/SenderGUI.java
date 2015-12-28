import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI for the RemoteEmail
 * 
 * @author Adam Audycki
 *
 */
public class SenderGUI extends JFrame {
	
	private static final long serialVersionUID = -4100295535493995917L;

	public SenderGUI() {

		this.setTitle("Remote Email");
		JPanel panel = new JPanel();
		JPanel sendingPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendingPanel.setLayout(new BorderLayout());
		labelPanel.setLayout(new GridLayout());
		fieldPanel.setLayout(new GridLayout());

		JButton sendEmail = new JButton();
		JTextField rec = new JTextField(30);
		JTextField send = new JTextField(30);
		JTextField pass = new JTextField(30);
		JTextField sub = new JTextField(50);
		JTextField mes = new JTextField(150);
		sendEmail.setText("Send Email");

		sendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendEmail.sendMail(rec.getText(), sub.getText(), mes.getText(),
						send.getText(), pass.getText());
			}
		});

		JLabel recL = new JLabel("Recipient");
		JLabel sendL = new JLabel("Sender");
		JLabel passL = new JLabel("Password");
		JLabel subL = new JLabel("Subject");

		panel.add(sendEmail, BorderLayout.SOUTH);
		labelPanel.add(recL);
		labelPanel.add(sendL);
		labelPanel.add(passL);
		labelPanel.add(subL);

		fieldPanel.add(rec);
		fieldPanel.add(send);
		fieldPanel.add(pass);
		fieldPanel.add(sub);

		sendingPanel.add(labelPanel, BorderLayout.NORTH);
		sendingPanel.add(fieldPanel, BorderLayout.SOUTH);

		panel.add(mes, BorderLayout.CENTER);
		panel.add(sendingPanel, BorderLayout.NORTH);
		this.add(panel);
		this.setMinimumSize(new Dimension(650, 450));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}
