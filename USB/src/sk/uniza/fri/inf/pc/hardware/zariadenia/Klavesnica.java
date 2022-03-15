package sk.uniza.fri.inf.pc.hardware.zariadenia;

import sk.uniza.fri.inf.pc.hardware.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardware.UsbPort;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class Klavesnica implements IUsbZariadenie {

    private final String nazov;
    private final String vyrobca;
    private final boolean maNumerickuCast;
    private UsbPort usbPort;

    public Klavesnica(String nazov, String vyrobca, boolean maNumerickuCast) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.maNumerickuCast = maNumerickuCast;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public String getVyrobca() {
        return this.vyrobca;
    }

    public boolean isMaNumerickuCast() {
        return this.maNumerickuCast;
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
        return "Klavesnica{" +
                "nazov='" + nazov + '\'' +
                ", vyrobca='" + vyrobca + '\'' +
                ", maNumerickuCast=" + maNumerickuCast +
                '}';
    }
}
