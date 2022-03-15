package sk.uniza.fri.inf.pc.hardware;

import sk.uniza.fri.inf.pc.hardware.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardware.UsbPort;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class USBHub implements IUsbZariadenie {

    private final String nazov;
    private final String vyrobca;
    private UsbPort[] porty;
    private UsbPort usbPort;

    public USBHub(String nazov, String vyrobca, int pocetPortov) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.porty = new UsbPort[pocetPortov];
        for (int i = 0; i < this.porty.length; i++) {
            this.porty[i] = new UsbPort();
        }
    }

    USBHub(int pocetPortov) {
        this("neznamy", "neznamy", pocetPortov);
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
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
        for (UsbPort port : this.porty) {
            if (!port.jeObsadeny()) {
                return port;
            }
        }
        return null;
    }

    public void pripojDoUsbPortu(UsbPort usbPort) {
        if (usbPort.jeObsadeny()) {
            System.err.println("Usb port je uz obsadeny");
            return;
        } else if (this.usbPort != null) {
            this.usbPort.setUsbZariadenie(null);
        }
        usbPort.setUsbZariadenie(this);
        this.usbPort = usbPort;
    }

    public void odpojZUsbPortu() {
        if (this.usbPort == null) {
            System.err.println("Nieje pripojena");
            return;
        }
        this.usbPort.setUsbZariadenie(null);
        this.usbPort = null;
    }

    public void vypisVsetkyZariadenia() {
        this.vypisVsetkyZariadenia(0);
    }

    private void vypisVsetkyZariadenia(int odsadenie) {
        for (int i = 0; i < this.porty.length; i++) {
            UsbPort port = this.porty[i];
            String medzera = "\t";
            System.out.printf("%s[%d]\t%s\n", medzera.repeat(odsadenie), i, port);
            if (port.jeObsadeny()) {
                IUsbZariadenie usbZariadenie = port.getUsbZariadenie();
                if (usbZariadenie instanceof USBHub) {
                    ((USBHub)usbZariadenie).vypisVsetkyZariadenia(odsadenie + 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "USBHub{" +
                "nazov='" + nazov + '\'' +
                ", vyrobca='" + vyrobca + '\'' +
                ", pocet portov='" + this.getPocetPortov() + '\'' +
                '}';
    }
}
