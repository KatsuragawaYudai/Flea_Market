package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	private static final String senderEmail = "system.project.team24@kanda-it-school-system.com";
	private static final String senderPassword = "jCX8g1l3HjoK2Vb";
	
	public void sendMail(String reciever, String body) {
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication(
							senderEmail, senderPassword
						);
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage
				.setFrom(new InternetAddress("test.sender@kanda-it-school-system.com", "神田IT School", "iso-2022-jp"));

			// 送信先メールアドレスを指定（ご自分のメールアドレスに変更）
			// 既定のメールアドレスにしたい場合
			//mimeMessage.setRecipients(Message.RecipientType.TO, reciever);
			mimeMessage.setRecipients(Message.RecipientType.TO, "system.project.team24@kanda-it-school-system.com");
			// メールのタイトルを指定
			mimeMessage.setSubject("ご購入が確定しました。", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(body, "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
}