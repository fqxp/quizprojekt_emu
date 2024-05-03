import java.io.*;

public class readCSV {
    public static void rCSV(String csvDatei) {
        //System.out.println("");
        String fs = System.getProperty("file.separator"); // das Slash-problem elemenieren...
        //System.out.println(fs);
        
        //BufferedReader reader = new BufferedReader(new FileReader(path));
        //reader.close();
        try (BufferedReader fr = new BufferedReader(new java.io.FileReader(new File("."+fs+"quizprojekt"+fs+"data"+fs+csvDatei+".csv")))){
            int zeilen=0;
            String zeile="";
            
            while(null!=(zeile=fr.readLine())){ //einlesen der Zeilen
                zeilen++;
                if (zeile.charAt(1)=="/".charAt(0)) {
                    System.out.println(zeile);
                }
                if (zeile.charAt(1)!="/".charAt(0)) {
                    String[] splitarr=zeile.split("; "); //hier wird die Zeile zerlegt mit Trennzeichen: "; "
                    System.out.print(splitarr[0]); //erstes Element über index 0
                    System.out.print(" | ");
                    System.out.print(splitarr[1]); //zweites Element über index 1 
                    if (splitarr.length>2) {
                        System.out.print(" | ");
                        System.out.print(splitarr[2]); //drittes Element über index 2 
                    }
                    if (splitarr.length>3) {
                        System.out.print(" | ");
                        System.out.print(splitarr[3]); //viertes Element über index 3 
                    }
                    System.out.println("");
                }
            }
            System.out.println("insgesammt "+(zeilen-2)+" zeilen");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    //    rCSV("kategorien");
    //    rCSV("fragen");
        rCSV("antworten");
    }
}
