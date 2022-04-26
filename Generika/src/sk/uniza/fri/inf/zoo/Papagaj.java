package sk.uniza.fri.inf.zoo;

/**
 * 26. 4. 2022 - 8:09
 *
 * @author Michal
 */
public class Papagaj implements IZviera {
    private String naucenaFraza = "Som papagaj";


    public void naucFrazu(String fraza) {
        this.naucenaFraza = fraza;
    }

    @Override
    public void hovor() {
        System.out.println(this.naucenaFraza);
    }
}
