package entities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    private String usuario;
    private String password;
    
    private String destino;
    private String asunto;
    private String mensaje;
    
    //archivos adjuntos
    private String rutaarchivo;
    private String nombrearchivo;

    public Mail() {
    }

    public Mail(String usuario, String password, String destino, String asunto, String mensaje) {
        this.usuario = usuario;
        this.password = password;
        this.destino = destino;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRutaarchivo() {
        return rutaarchivo;
    }

    public void setRutaarchivo(String rutaarchivo) {
        this.rutaarchivo = rutaarchivo;
    }

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }
    
    
    
    public boolean enviarCorreo(){
        Mail m=new Mail();
        try {
            Properties p=new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", m.getUsuario());
            p.setProperty("mail.smtp.auth", "true");
            
            Session s=Session.getDefaultInstance(p,null);
            BodyPart texto=new MimeBodyPart();
            texto.setText(m.getMensaje());
            BodyPart adjunto=new MimeBodyPart();
            
            if (!m.getRutaarchivo().equals("")) {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(m.getRutaarchivo())));
                adjunto.setFileName(m.getNombrearchivo());
            }
            MimeMultipart mp=new MimeMultipart();
            mp.addBodyPart(texto);
            
            if (!m.getRutaarchivo().equals("")) {
                mp.addBodyPart(adjunto);
            }
            MimeMessage message=new MimeMessage(s);
            message.setFrom(new InternetAddress(m.getUsuario()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(m.getDestino()));
            message.setSubject(m.getAsunto());
            message.setContent(mp);
            
            Transport t=s.getTransport("smtp");
            t.connect(m.getUsuario(), m.getPassword());
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
        
    }
    
    
    public void enviar(){
        Mail m=new Mail();
        //el que envia
        m.setPassword("rsfevbcjjunjtejt");
        m.setUsuario("dekhan06@gmail.com");
        //el que recibe
        m.setDestino("deyvi_delacruz@hotmail.com");
        //el mensaje
        m.setAsunto("Prueba de Proyecto Academico");
        m.setMensaje("Este es un mensaje de prueba");
        m.setNombrearchivo("img.png");
        m.setRutaarchivo("img.png");
        
        m.enviarCorreo();
    }
    
    
}
