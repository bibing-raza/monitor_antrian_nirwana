/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fungsi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JOptionPane;
import AESsecurity.EnkripsiAES;

/**
 *
 * @author khanzasoft
 */
public final class koneksiDB {
    public koneksiDB() {
    }
    private static Connection connection = null;
    private static final Properties prop = new Properties();
    private static final MysqlDataSource dataSource = new MysqlDataSource();
    private static String caricepat = "", host = "", database = "", port = "", user = "", pas = "";
    private static sekuel Sequel = new sekuel();
    private static String var="";
    
    public static Connection condb() {
        if (connection == null) {
            try {
                prop.loadFromXML(new FileInputStream("setting/database.xml"));
                dataSource.setURL("jdbc:mysql://"+EnkripsiAES.decrypt(prop.getProperty("HOST"))+":"+EnkripsiAES.decrypt(prop.getProperty("PORT"))+"/"+EnkripsiAES.decrypt(prop.getProperty("DATABASE"))+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useCompression=true");                
                dataSource.setUser(EnkripsiAES.decrypt(prop.getProperty("USER")));
                dataSource.setPassword(EnkripsiAES.decrypt(prop.getProperty("PAS")));
                connection=dataSource.getConnection();
                System.out.println("Koneksi Berhasil. Sedang verifikasi data, silakan tunggu sebentar.... \n\n"
                        + "    _____  _    _     _____           _          _                   \n"
                        + "   |_   _|| |  | |   /  _  \\ _ ___  _| |_  _ __ |_|  __ _  _ ___    \n"
                        + "     | |  | |  | |   | (_) || `_  ||_   _|| `__|| | / _` || `_  |          \n"
                        + "     | |   \\ \\/ /    |  _  || | | |  | |_ | |   | || (_| || | | |       \n"
                        + "     |_|    \\__/     |_| |_||_| |_|  |___||_|   |_| \\__,_||_| |_|     \n"                        
                        + "                                                                            \n\n"
                        + "    POWERED BY. RSU Nirwana                                   \n"
                        + "                                                                           ");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi Putus : " + e);
                try {
                    if(connection.isClosed()){
                        prop.loadFromXML(new FileInputStream("setting/database.xml"));
                        dataSource.setURL("jdbc:mysql://"+EnkripsiAES.decrypt(prop.getProperty("HOST"))+":"+EnkripsiAES.decrypt(prop.getProperty("PORT"))+"/"+EnkripsiAES.decrypt(prop.getProperty("DATABASE"))+"?zeroDateTimeBehavior=convertToNull&amp;autoReconnect=true&amp;cachePrepStmts=true");
                        dataSource.setUser(EnkripsiAES.decrypt(prop.getProperty("USER")));
                        dataSource.setPassword(EnkripsiAES.decrypt(prop.getProperty("PAS")));
                        connection=dataSource.getConnection();  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Koneksi Putus : "+e);
                }
            }
        }
        return connection;
    }
    
    public static String cariCepat() {
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=prop.getProperty("CARICEPAT");
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
    
    public static String AKTIFKANTRACKSQL() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = prop.getProperty("AKTIFKANTRACKSQL");
        } catch (Exception e) {
            var = "";
        }
        return var;
    }
}
