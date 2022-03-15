package sk.uniza.fri.inf.pc.hardware.zariadenia;

import sk.uniza.fri.inf.pc.hardware.UsbPort;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class USBHub {

    private final String nazov;
    private final String vyrobca;
    private UsbPort[] porty;

    public USBHub(String nazov, String vyrobca, int pocetPortov) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.porty = new UsbPort[pocetPortov];
        for (int i = 0; i < this.porty.length; i++) {
            this.porty[i] = new UsbPort();
        }
    }

    public USBHub(int pocetPortov) {
        this("neznamy", "neznamy", pocetPortov);
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getVyrobca() {
        return this.vyrobca;
    }

    public int getPocetPortov() {
        return this.porty.length;
    }

    public UsbPort getUsbPort(int index) {
        return this.porty[index];
    }

    public UsbPort getVolnyUsbPort() {
        for (UsbPort usbPort : this.porty) {
            if (!usbPort.jeObsadeny()) {
                return usbPort;
            }
        }
        return null;
    }

    public void vypisVsetkyZariadenia() {
        for (int i = 0; i < this.porty.length; i++) {
            UsbPort usbPort = this.porty[i];
            System.out.printf("[%d]\t%s\n", i, usbPort);
        }
    }
}
