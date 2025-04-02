package mg.ITU.imports.utilitaires;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSV {
    

    public static <T> HashMap <String, List <Object>> import_CSV (String pathFile, Mapper_ligne<T> mapper_ligne) {
        
        HashMap <String, List <Object>> valiny = new HashMap <String, List <Object>> ();
        List <T> items = new ArrayList <> ();
        List <String> errors = new ArrayList<>();
        CSVReader csvReader = null;

        try {

            csvReader = new CSVReader(new FileReader(pathFile));
            int num_ligne = 0;
            String[] ligne;

            while ((ligne = csvReader.readNext()) != null) {
                try {
                    T item = mapper_ligne.mapLigne(ligne, num_ligne);
                    items.add(item);
                } catch (Exception e) {
                    errors.add("Error a la ligne "+num_ligne+", exception :"+e.getMessage()+", cause: "+e.getCause());
                }

                ++ num_ligne;
            }

            csvReader.close();
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return valiny;
    }


    public static <T> File export_CSV (String pathFile, Mapper_ligne<T> mapper_ligne, List <T> objets) {

        File fichier = new File(pathFile);
        FileWriter writer = null;

        try {
            if (!fichier.exists()) {
                fichier.createNewFile();
            }

            writer = new FileWriter(fichier);
            List <String> lignes = mapper_ligne.export (objets);

            if (lignes == null || lignes.isEmpty()) {
                writer.close();
                return fichier;
            }

            int index = 0;
            while (index < lignes.size()) {
                writer.append(lignes.get(index)+"\n");
                ++ index;
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fichier;
    }
}
