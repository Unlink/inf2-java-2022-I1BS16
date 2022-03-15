package sk.uniza.fri.inf.pc.hardware;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class Pocitac {

    private UsbPort[] porty;

    public Pocitac(int pocetPortov) {
        this.porty = new UsbPort[pocetPortov];
        for (int i = 0; i < this.porty.length; i++) {
            this.porty[i] = new UsbPort();
        }
    }

    public int getPocetPortov() {
        return this.porty.length;
    }

    public UsbPort getUsbPort(int index) {
        return this.porty[index];
    }

    public UsbPort getVolnyUsbPort() {
        for (UsbPort usbPort : porty) {
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
