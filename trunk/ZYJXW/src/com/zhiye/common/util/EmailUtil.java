package com.zhiye.common.util;

import java.util.Map;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * This is a class that helps to perform SMTP functions with Apache commons
 * email Library
 * 
 * @author pellias
 */
public class EmailUtil
{
    public enum SMTPSecureMode
    {
        NONE, SSL, TLS
    }

    private String host;
    private int port;
    private String userid;
    private String password;
    private SMTPSecureMode secureMode;
    private String authFlag;
    /**
     * Constructor for SMTP
     * 
     * @param host of SMTP server
     * @param port of SMTP server
     * @param userid
     * @param password
     * @param secureMode - ssl, tls or none
     * @throws SFTPUtilException
     */
    public EmailUtil( String host, int port, String userid, String password,
        SMTPSecureMode secureMode, String authFlag )
    {
        this.host = host;
        this.port = port;
        this.userid = userid;
        this.password = password;
        this.secureMode = secureMode;
        this.authFlag = authFlag;
    }

    /**
     * Sets up the email with the configuration
     * 
     * @return Email email object
     */
    private Email setupEmail()
    {
        Email email = new SimpleEmail();

        email.setHostName( host );
        email.setSmtpPort( port );
//        email.setAuthentication( userid, password );
//        
//        Properties props = System.getProperties();
//        props.setProperty("mail.smtp.auth", authFlag);
//        props.setProperty("mail.smtp.host", host);
//        props.setProperty("mail.smtp.port", String.valueOf(port));
//        
//        Session session = Session.getInstance(props);
//        email.setMailSession(session);
        
         email.setAuthenticator( new DefaultAuthenticator( userid, password )
         );
         email.setSSL(true);
//		switch (secureMode) {
//		case TLS:
//			email.setTLS(true);
//		case SSL:
//			email.setSSL(true);
//		default:
//			email.setTLS(false);
//			email.setSSL(false);
//		}
        return email;
    }

    /**
     * Sends an email
     * 
     * @param senderInfo array with email and name (optional)
     * @param subject
     * @param message
     * @param to is a Map containing recipients. Keys are email, Values are
     *            names (optional)
     * @param cc is a Map containing cc. Keys are email, Values are names
     *            (optional)
     * @param bcc is a Map containing cc. Keys are email, Values are names
     *            (optional)
     * @return boolean true if sent
     */
    public boolean send( String[] senderInfo, String subject, String message,
        Map<String, String> to, Map<String, String> cc, Map<String, String> bcc )
        throws EmailUtilException
    {
        Email email = setupEmail();
        try
        {
            if( senderInfo != null && senderInfo.length == 2 )
            {
                email.setFrom( senderInfo[0], senderInfo[1] );
            }
            else if( senderInfo != null )
            {
                email.setFrom( senderInfo[0] );
            }
            else
            {
                return false;
            }
        }
        catch ( EmailException e )
        {
            throw new EmailUtilException( EmailUtilException.ERR_SENDER,
                "Error setting sender info: " + senderInfo, e );
        }

        if( subject != null )
        {
            email.setSubject( subject );
        }

        if( message != null )
        {
            try
            {
                email.setMsg( message );
            }
            catch ( EmailException e )
            {
                throw new EmailUtilException( EmailUtilException.ERR_MESSAGE,
                    "Error setting message: " + message, e );
            }
        }

        try
        {
            if( bcc != null )
            {
                for ( Map.Entry<String, String> entry : bcc.entrySet() )
                {
                    if( entry.getValue() != null )
                    {
                        email.addBcc( entry.getKey(), entry.getValue() );
                    }
                    else
                    {
                        email.addBcc( entry.getKey() );
                    }
                }
            }

        }
        catch ( EmailException e )
        {
            throw new EmailUtilException( EmailUtilException.ERR_BCC,
                "Error setting bcc: " + bcc, e );
        }

        try
        {
            if( cc != null )
            {
                for ( Map.Entry<String, String> entry : cc.entrySet() )
                {
                    if( entry.getValue() != null )
                    {
                        email.addCc( entry.getKey(), entry.getValue() );
                    }
                    else
                    {
                        email.addCc( entry.getKey() );
                    }
                }
            }
        }
        catch ( EmailException e )
        {
            throw new EmailUtilException( EmailUtilException.ERR_CC,
                "Error setting cc: " + cc, e );
        }

        // sends only if there are recipients
        try
        {
            if( to != null && to.size() > 0 )
            {

                for ( Map.Entry<String, String> entry : to.entrySet() )
                {
                    if( entry.getValue() != null )
                    {
                        email.addTo( entry.getKey(), entry.getValue() );
                    }
                    else
                    {
                        email.addTo( entry.getKey() );
                    }
                }
                email.send();
            } else {
                return false;
            }
        }
        catch ( EmailException e )
        {
            throw new EmailUtilException( EmailUtilException.ERR_RECIPIENT,
                "Error adding recipients and sending the message", e );
        }
        return true;
    }
}
