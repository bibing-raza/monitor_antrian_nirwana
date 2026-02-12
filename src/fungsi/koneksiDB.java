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
                host = Sequel.decXML2(prop.getProperty("HOST"), prop.getProperty("KEY"));
                database = Sequel.decXML2(prop.getProperty("DATABASE"), prop.getProperty("KEY"));
                port = Sequel.decXML2(prop.getProperty("PORT"), prop.getProperty("KEY"));
                user = Sequel.decXML2(prop.getProperty("USER"), prop.getProperty("KEY"));
                pas = Sequel.decXML2(prop.getProperty("PAS"), prop.getProperty("KEY"));
                //dataSource.setURL("jdbc:mysql://"+prop.getProperty("HOST")+":"+prop.getProperty("PORT")+"/"+prop.getProperty("DATABASE")+"?zeroDateTimeBehavior=convertToNull");
                dataSource.setURL("jdbc:mysql://" + host + ":" + port + "/" + database + "?zeroDateTimeBehavior=convertToNull");
                dataSource.setUser(user);
                dataSource.setPassword(pas);
                connection = dataSource.getConnection();
                System.out.println("Koneksi Berhasil. Sedang verifikasi data, silakan tunggu sebentar.... \n\n"
                        + "    _____  _    _     _____           _          _                   ____   ____    \n"
                        + "   |_   _|| |  | |   /  _  \\ _ ___  _| |_  _ __ |_|  __ _  _ ___    |  _ \\ |_   |    \n"
                        + "     | |  | |  | |   | (_) || `_  ||_   _|| `__|| | / _` || `_  |   | |_) |  / /       \n"
                        + "     | |   \\ \\/ /    |  _  || | | |  | |_ | |   | || (_| || | | |   |  _ <  / /_     \n"
                        + "     |_|    \\__/     |_| |_||_| |_|  |___||_|   |_| \\__,_||_| |_|   |_| \\_\\|____|   \n"                        
                        + "                                                                            \n\n"
                        + "    POWERED BY. UNIT SIMRS RSUD Ratu Zalecha                                   \n"
                        + "                                                                           ");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi Putus : " + e);
            }
        }
        return connection;
    }
    
    public static String cariCepat() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            caricepat = prop.getProperty("CARICEPAT");
        } catch (Exception e) {
            caricepat = "tidak aktif";
        }
        return caricepat;
    }
    
    public static String HOST() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = Sequel.decXML2(prop.getProperty("HOST"), prop.getProperty("KEY"));
        } catch (Exception e) {
            var = "";
        }
        return var;
    }
    
    public static String DATABASE() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = Sequel.decXML2(prop.getProperty("DATABASE"), prop.getProperty("KEY"));
        } catch (Exception e) {
            var = "";
        }
        return var;
    }

    public static String PORT() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = Sequel.decXML2(prop.getProperty("PORT"), prop.getProperty("KEY"));
        } catch (Exception e) {
            var = "";
        }
        return var;
    }
    
    public static String USER() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = Sequel.decXML2(prop.getProperty("USER"), prop.getProperty("KEY"));
        } catch (Exception e) {
            var = "";
        }
        return var;
    }
    
    public static String PASSWORD() {
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = Sequel.decXML2(prop.getProperty("PAS"), prop.getProperty("KEY"));
        } catch (Exception e) {
            var = "";
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
