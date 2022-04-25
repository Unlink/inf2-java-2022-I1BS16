package sk.uniza.fri.wof.mapa;

import sk.uniza.fri.wof.predmety.Hodinky;
import sk.uniza.fri.wof.predmety.IPredmet;
import sk.uniza.fri.wof.predmety.ITovarenNaPredmety;
import sk.uniza.fri.wof.predmety.JedloTovaren;
import sk.uniza.fri.wof.predmety.ZakladnyPredmet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class NacitavacMapy implements IMapa {

    private HashMap<String, ITovarenNaPredmety> tovarneNaPredmety;
    private HashMap<String, Miestnost> miestnosti;

    public NacitavacMapy() throws IOException {
        this.miestnosti = new HashMap<>();
        this.tovarneNaPredmety = new HashMap<>();
        this.tovarneNaPredmety.put("Hodinky", (nazov, parametre) -> new Hodinky());
        this.tovarneNaPredmety.put(null, (nazov, parametre) -> new ZakladnyPredmet(nazov));
        this.tovarneNaPredmety.put("Jedlo", new JedloTovaren());
        this.nacitajMapu();
    }

    @Override
    public Miestnost getStartovaciaMiestnost() {
        return null;
    }

    private void nacitajMapu() throws IOException {
        ArrayList<YMLRiadok> riadky = nacitajSubor("mapa.yml");
        nacitajMiestnosti(riadky);
        nacitajObsahMiestnosti(riadky, "vychody");
        nacitajObsahMiestnosti(riadky, "predmety");




    }

    private void nacitajObsahMiestnosti(ArrayList<YMLRiadok> riadky, String kluc) {
        String nazovMiestnosti = null;
        boolean nacitavamObsah = false;
        for (YMLRiadok ymlRiadok : riadky) {
            if (ymlRiadok.getOdsadenie() == 2) {
                nazovMiestnosti = ymlRiadok.getKluc();
            }
            if (ymlRiadok.getOdsadenie() <= 4) {
                nacitavamObsah = false;
            }

            if (nacitavamObsah) {
                switch (kluc) {
                    case "vychody":
                        miestnosti.get(nazovMiestnosti)
                                .pridajVychod(ymlRiadok.getKluc(), miestnosti.get(ymlRiadok.getHodnota()));
                        break;
                    case "predmety":
                        IPredmet predmet = null;
                        String trieda = null;
                        String parametre = null;
                        if (ymlRiadok.getHodnota() != null) {
                            Scanner scanner = new Scanner(ymlRiadok.getHodnota());
                            trieda = scanner.next();
                            parametre = scanner.hasNextLine() ? scanner.nextLine().strip() : null;
                        }
                        predmet = tovarneNaPredmety.get(trieda).vytvor(ymlRiadok.getKluc(), parametre);
                        miestnosti.get(nazovMiestnosti).pridajPredmet(predmet);
                        break;
                }
            }
            if (ymlRiadok.getOdsadenie() == 4 && ymlRiadok.getKluc().equals(kluc)) {
                nacitavamObsah = true;
            }
        }
    }

    private void nacitajMiestnosti(ArrayList<YMLRiadok> riadky) {
        String nazovMiestnosti = null;
        String popisMiestnosti = null;
        for (YMLRiadok ymlRiadok : riadky) {
            if (ymlRiadok.getOdsadenie() <= 2 && nazovMiestnosti != null) {
                Miestnost m = new Miestnost(popisMiestnosti == null ? nazovMiestnosti : popisMiestnosti);
                this.miestnosti.put(nazovMiestnosti, m);
                popisMiestnosti = null;
            }
            if (ymlRiadok.getOdsadenie() == 2) {
                nazovMiestnosti = ymlRiadok.getKluc();
            }
            if (ymlRiadok.getOdsadenie() == 4 && ymlRiadok.getKluc().equals("popis")) {
                if (ymlRiadok.getHodnota() == null) {
                    throw new NespravnyFormatSuboruException();
                }
                popisMiestnosti = ymlRiadok.getHodnota();
            }
        }
    }


    public static ArrayList<YMLRiadok> nacitajSubor(String fileName) throws IOException {
        if (fileName == null) {
            throw new IllegalArgumentException("fileName je null");
        }
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException(fileName + " neexistuje");
        }

        ArrayList<YMLRiadok> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                int kommentStart = line.indexOf("#");
                if (kommentStart > -1) {
                    line = line.substring(0, kommentStart);
                }
                line = line.stripTrailing();
                if (line.isEmpty()) {
                    continue;
                }

                String key = null;
                String value = null;
                boolean pomlcka = false;
                int odsadenie = 0;

                int sep = line.indexOf(":");
                //Kluc: hodnota
                if (sep > -1) {
                    key = line.substring(0, sep).strip();
                    value = line.substring(sep + 1).strip();
                } else {
                    key = line.strip();
                }

                if (key.startsWith("-")) {
                    pomlcka = true;
                    key = key.substring(1).strip();
                }

                for (int i = 0; i < line.length(); i++) {
                    if (Character.isWhitespace(line.charAt(i))) {
                        odsadenie++;
                    } else {
                        break;
                    }
                }


                result.add(new YMLRiadok(key, value, odsadenie, pomlcka));
            }
        }

        return result;
    }
}
