/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package khanzaantrianloket;

import java.awt.Toolkit;

/**
 *
 * @author igos
 */
public class KhanzaAntrianLoket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmUtama antrian = new frmUtama(null, false);
        antrian.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        antrian.cekHariLibur();
        antrian.setVisible(true);
    }
}
