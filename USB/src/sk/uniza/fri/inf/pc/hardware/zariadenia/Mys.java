package sk.uniza.fri.inf.pc.hardware.zariadenia;

import sk.uniza.fri.inf.pc.hardware.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardware.UsbPort;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class Mys implements IUsbZariadenie {
    private final String nazov;
    private final String vyrobca;
    private final int pocetTlacidiel;
    private final boolean jeBezdrotova;
    private UsbPort usbPort;

    public Mys(String nazov, String vyrobca, int pocetTlacidiel, boolean jeBezdrotova) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.pocetTlacidiel = pocetTlacidiel;
        this.jeBezdrotova = jeBezdrotova;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public String getVyrobca() {
        return this.vyrobca;
    }

    public int getPocetTlacidiel() {
        return this.pocetTlacidiel;
    }

    public boolean isJeBezdrotova() {
        return this.jeBezdrotova;
    }

    @Override
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

    @Override
    public void odpojZUsbPortu() {
        if (this.usbPort == null) {
            System.err.println("Nieje pripojena");
            return;
        }
        this.usbPort.setUsbZariadenie(null);
        this.usbPort = null;
    }

    @Override
    public String toString() {
        return "Mys{" +
                "nazov='" + nazov + '\'' +
                ", vyrobca='" + vyrobca + '\'' +
                ", pocetTlacidiel=" + pocetTlacidiel +
                ", jeBezdrotova=" + jeBezdrotova +
                '}';
    }
}
