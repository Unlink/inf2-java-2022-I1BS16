package sk.uniza.fri.inf.pc;

import sk.uniza.fri.inf.pc.hardware.Pocitac;
import sk.uniza.fri.inf.pc.hardware.UsbPort;
import sk.uniza.fri.inf.pc.hardware.zariadenia.Klavesnica;
import sk.uniza.fri.inf.pc.hardware.zariadenia.Mys;

/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 14. 3. 2022
 * Time: 13:39
 */
public class Main {

    public static void main(String[] args) {
        Pocitac mojNotebook = new Pocitac(4);
        UsbPort usbPort0 = mojNotebook.getVolnyUsbPort();
        Klavesnica klavesnica = new Klavesnica("G910 OrionSpectrum", "Logitech", true);
        klavesnica.pripojDoUsbPortu(usbPort0);
        UsbPort usbPort2 = mojNotebook.getUsbPort(2);
        Mys mys = new Mys("M705 MarathonMouse", "Logitech", 5, true);
        mys.pripojDoUsbPortu(usbPort2);
        mojNotebook.vypisVsetkyZariadenia();
    }
}
