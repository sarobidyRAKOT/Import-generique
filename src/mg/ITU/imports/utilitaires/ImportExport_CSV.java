package mg.ITU.imports.utilitaires;

import java.util.List;

public interface ImportExport_CSV <T> {
    
    public T Import (String[] ligne, int num_ligne) throws Exception;
    public List <String> Export (List <T> objets);
}
