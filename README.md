# Import-generique

## Pré-requis
1. Avoir java 17
2. Installer apache-ant
3. opencsv.jar 

## Compilation (build jar) `ImportExport-generic.jar`
Taper `ant`
le fichier `ImportExport-generic.jar` sera disponible dans le dossier `dist`
## Utilisation du jar
1. Creer une classe qui implementer l'interface `ImportExport_CSV <T>`
2. Dans cette classe la methode `Import (String[] ligne, int num_ligne)` traitre chaque ligne du fichier CSV.
3. La methode `Export (List <T> objects)` traite une liste d'object (entite) pour realiser l'exportation CSV