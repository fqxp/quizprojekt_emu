import java.io.*;
import java.util.*;

// csvArray gibt des Inhalt der csv-Datei als Array aus
public class Csv2Array {
    //private static String[][] antworten;

    public static String[][] csvArray(String csvDatei) {
        int zeilen = 0;
        int elemente = 0;
        String zeile;
        BufferedReader csvZeilen = null;
        String[][] csvArray = null;
        String fs = System.getProperty("file.separator"); // das Slash-problem elemenieren...

        try {
            csvZeilen = new BufferedReader(new java.io.FileReader(new File("."+fs+"quizprojekt"+fs+"data"+fs+csvDatei+".csv")));
            while ((zeile = csvZeilen.readLine()) != null) {
                if (zeilen == 2) {
                    elemente = (zeile.split("; ")).length; 
                    //System.out.println("Elemente: "+elemente);
                }
                //System.out.println("Zeilen: "+zeilen);
                zeilen++;
            }
            csvZeilen.close();

            csvArray = new String[zeilen - 2][elemente];
            //System.out.println("der csvArray wurde erstellt!");
            //System.out.println("Zeilen: "+(zeilen-2));
            //System.out.println("Elemte: "+elemente);
            
            int zeilennr = 0;
            //System.out.println("Zeilennr: "+(zeilennr));

            csvZeilen = new BufferedReader(new java.io.FileReader("."+fs+"quizprojekt"+fs+"data"+fs+csvDatei+".csv")); // Auslesen von csvDatei
            while ((zeile = csvZeilen.readLine()) != null) {
                if (zeilennr>1) {
                    String[] splitarr = zeile.split("; "); // Splitten der Zeilen
                    csvArray[zeilennr-2][0] = splitarr[0]; // erstes Elementobjekt über index 0
                    //System.out.print(splitarr[0]);
                    csvArray[zeilennr-2][1] = splitarr[1]; // zweites Element über index 1 
                    if (splitarr.length > 2) {
                        csvArray[zeilennr-2][2] = splitarr[2]; // drittes Element über index 2 
                    }
                    if (splitarr.length > 3) {
                        csvArray[zeilennr-2][3] = splitarr[3]; // viertes Element über index 3 
                    }
                }
                //System.out.println("Zeilennr: "+(zeilennr));
                zeilennr++;
            }
            //System.out.println("*"+csvArray.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (csvZeilen != null) {
                    csvZeilen.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return csvArray;  
    }
    
    // csvAusgabe gibt den Inhalt der verschieden csv-Dateien im Terminal aus (datei ohne ".csv")
    public static void csvAusgabe(String datei) {
        System.out.println(datei);
        String[][] csvArray_=csvArray(datei);
        for (int i=0; i<csvArray_.length; i++){
            String ausgabe="";
            //System.out.println(i);
            for (int j=0; j<(csvArray_[i].length); j++) {
                //System.out.println(j);
                ausgabe = ausgabe + csvArray_[i][j];
                if ((j<(csvArray_[i].length)-1)) ausgabe = ausgabe +" | ";

            }
            System.out.println(ausgabe);
        }
    }

    public static String[][] antwortenZurFrage(int idfrage) {
        final String[][] csvAntworten = csvArray("antworten");
        final String[][] antworten = new String[4][5];
        //System.out.print("***"+csvAntworten[idfrage].length);
        int h=0;
        Random rnd = new Random(); 
        for (int i=0; i < csvAntworten[i].length; i++){
            if (Integer.parseInt(csvAntworten[i][0])==idfrage) {
                for (int j=0; j<4; j++) {
                    //System.out.println(csvAntworten[i][j]);
                    antworten[h][j]=csvAntworten[i][j];
                    //System.out.println(antworten[i][j]);
                }
                antworten[h][4]=String.valueOf(rnd.nextInt(100));
                h++;
            }
        }

        Sort2DArrayBasedOnColumnNumber(antworten, 5);        return antworten;
    }

    public static void Sort2DArrayBasedOnColumnNumber(String[][] array, final int columnNumber) {
        Arrays.sort(array, new Comparator<String[]>() {
          @Override
          public int compare(String[] first, String[] second) {
            if (Integer.parseInt(first[columnNumber - 1]) > Integer.parseInt(second[columnNumber - 1]))
              return 1;
            else
              return -1;
          }
        });
    }


    
    /*public static void Sort2DArrayBasedOnColumnNumber(int[][] array, final int columnNumber) {
        Arrays.sort(array, new Comparator<int[]>() {
        @Override
        public int compare(int[] first, int[] second) {
            if (first[columnNumber - 1] > second[columnNumber - 1])
            return 1;
            else
            return -1;
    }*/

    public static void main(String[] args) {
    //    csvAusgabe("kategorien");
      //  csvAusgabe("fragen");
      //  csvAusgabe("antworten");
        
        // antwortenZurFrage gibt die Antworten zur Frage (mit der frageID)
        for (int i=0; i<4; i++) {
            //System.out.println("*");
            //System.out.println(antwortenZurFrage(1)[i]);
            for (int j=0; j<5; j++)  {
                System.out.print(antwortenZurFrage(1)[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
