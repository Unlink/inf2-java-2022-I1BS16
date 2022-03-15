package sk.uniza.fri.inf.pc.hardware;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public interface IUsbZariadenie {
    String getNazov();
    String getVyrobca();
    void pripojDoUsbPortu(UsbPort usbPort);
    void odpojZUsbPortu();
}
