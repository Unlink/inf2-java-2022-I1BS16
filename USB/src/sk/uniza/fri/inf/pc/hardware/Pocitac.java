package sk.uniza.fri.inf.pc.hardware;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class Pocitac {

    private USBHub hub;

    public Pocitac(int pocetPortov) {
        this.hub = new USBHub(pocetPortov);
    }

    public int getPocetPortov() {
        return this.hub.getPocetPortov();
    }

    public UsbPort getUsbPort(int index) {
        return this.hub.getUsbPort(index);
    }

    public UsbPort getVolnyUsbPort() {
        return this.hub.getVolnyUsbPort();
    }

    public void vypisVsetkyZariadenia() {
        this.hub.vypisVsetkyZariadenia();
    }

    public void vypisVsetkyMysi() {
        
    }
}
