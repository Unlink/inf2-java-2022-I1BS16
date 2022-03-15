package sk.uniza.fri.inf.pc.hardware.zariadenia;

import sk.uniza.fri.inf.pc.hardware.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardware.UsbPort;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class KlavesnicaSMysou implements IUsbZariadenie {

    private final String nazov;
    private final String vyrobca;
    private final boolean maNumerickuCast;
    private final int pocetTlacidiel;
    private final boolean jeBezdrotova;
    private UsbPort usbPort;

    public KlavesnicaSMysou(String nazov, String vyrobca, boolean maNumerickuCast, int pocetTlacidiel, boolean jeBezdrotova) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.maNumerickuCast = maNumerickuCast;
        this.pocetTlacidiel = pocetTlacidiel;
        this.jeBezdrotova = jeBezdrotova;
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getVyrobca() {
        return this.vyrobca;
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

    public boolean isMaNumerickuCast() {
        return this.maNumerickuCast;
    }

    public int getPocetTlacidiel() {
        return this.pocetTlacidiel;
    }

    public boolean isJeBezdrotova() {
        return this.jeBezdrotova;
    }

    @Override
    public String toString() {
        return "KlavesnicaSMysou{" +
                "nazov='" + nazov + '\'' +
                ", vyrobca='" + vyrobca + '\'' +
                ", maNumerickuCast=" + maNumerickuCast +
                ", pocetTlacidiel=" + pocetTlacidiel +
                ", jeBezdrotova=" + jeBezdrotova +
                '}';
    }
}
