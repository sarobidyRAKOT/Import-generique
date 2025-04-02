package mg.ITU.imports.utilitaires;

import java.util.List;

public interface Mapper_ligne <T> {
    
    public T mapLigne (String[] ligne, int num_ligne) throws Exception;
    public List <String> export (List <T> objets);
}
