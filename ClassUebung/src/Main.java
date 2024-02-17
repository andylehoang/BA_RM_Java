
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        warenEinfuegen();
   //System.out.println(readCSV().get(0)[1]);

    }

    public static ArrayList<String[]> readCSV() {
        ArrayList<String[]> daten = new ArrayList<String[]>();


        String file = "src\\Supermarkt.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {

                String[] row = line.split(";");
                daten.add(row);


            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } return daten;
    }

    public static ArrayList<Waren> warenEinfuegen() {
        ArrayList<Waren> meineWaren = new ArrayList<Waren>();
        ArrayList<String[]> daten = readCSV();
        String Lebensmittel = "Lebensmittel";
        String Haushaltsartikel = "Haushaltsartikel";
        String Sonstige = "Sonstige";
        double pivotEK = 0;
        double pivotVK = 0;
        int pivotAnteile = 0;
        int pivotFSK = 0;

        for (int i = 0; i < daten.size(); i++) { //läuft nur definierte Anzahl =11 durch, später variabel
            if (daten.get(i)[1].equals(Lebensmittel)) {
                pivotEK = Double.parseDouble(daten.get(i)[3]);
                pivotVK = Double.parseDouble(daten.get(i)[4]);

                meineWaren.add(new Lebensmittel(daten.get(i)[2],pivotEK,pivotVK,daten.get(i)[5]));
            }
            else if (daten.get(i)[1].equals(Haushaltsartikel)) {
                pivotEK = Double.parseDouble(daten.get(i)[3]);
                pivotVK = Double.parseDouble(daten.get(i)[4]);
                pivotAnteile = Integer.parseInt(daten.get(i)[5]);

                meineWaren.add(new Haushaltsartikel(daten.get(i)[2],pivotEK,pivotVK,pivotAnteile));

            }
            else if (daten.get(i)[1].equals(Sonstige)) {
                pivotEK = Double.parseDouble(daten.get(i)[3]);
                pivotVK = Double.parseDouble(daten.get(i)[4]);
                pivotFSK = Integer.parseInt(daten.get(i)[5]);

                meineWaren.add(new Sonstige(daten.get(i)[2],pivotEK,pivotVK,pivotFSK));

            }

        }
        return meineWaren;
    }
}
