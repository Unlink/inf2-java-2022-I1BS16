package sk.uniza.fri.inf.pc.hardware;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class UsbPort {
    private IUsbZariadenie usbZariadenie;

    public UsbPort() {
        this.usbZariadenie = null;
    }

    public IUsbZariadenie getUsbZariadenie() {
        return this.usbZariadenie;
    }

    public void setUsbZariadenie(IUsbZariadenie usbZariadenie) {
        this.usbZariadenie = usbZariadenie;
    }

    public boolean jeObsadeny() {
        return this.usbZariadenie != null;
    }

    @Override
    public String toString() {
        if (this.usbZariadenie == null) {
            return "(volny)";
        } else {
            return this.usbZariadenie.toString();
        }
    }
}
