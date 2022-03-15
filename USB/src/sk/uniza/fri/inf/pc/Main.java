package sk.uniza.fri.inf.pc;

import sk.uniza.fri.inf.pc.hardware.Pocitac;
import sk.uniza.fri.inf.pc.hardware.UsbPort;
import sk.uniza.fri.inf.pc.hardware.zariadenia.Klavesnica;
import sk.uniza.fri.inf.pc.hardware.zariadenia.KlavesnicaSMysou;
import sk.uniza.fri.inf.pc.hardware.zariadenia.Mys;
import sk.uniza.fri.inf.pc.hardware.USBHub;

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

        System.out.println("-----------------------");

        UsbPort usbPort3 = mojNotebook.getUsbPort(3);
        USBHub usbHub = new USBHub("HUE-SA7BP", "AXAGON", 7);
        usbHub.pripojDoUsbPortu(usbPort3);
        klavesnica.odpojZUsbPortu();
        klavesnica.pripojDoUsbPortu(usbHub.getUsbPort(5));
        mojNotebook.vypisVsetkyZariadenia();

        System.out.println("-----------------------");

        USBHub usbHubMaly = new USBHub("HUE-S2B USB 3.0", "AXAGON", 4);
        usbHubMaly.pripojDoUsbPortu(usbHub.getUsbPort(2));
        mojNotebook.vypisVsetkyZariadenia();

        System.out.println("-----------------------");

        KlavesnicaSMysou klavesnicaSMysou = new KlavesnicaSMysou("aaa", "bbb", true, 5, false);
        klavesnicaSMysou.pripojDoUsbPortu(usbHub.getUsbPort(3));

        mojNotebook.vypisVsetkyZariadenia();
        mojNotebook.vypisVsetkyMysi();

    }
}
