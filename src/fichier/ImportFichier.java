/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichier;

import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class ImportFichier {
    
    public static final String FICHIER_PAYS = "c:/ressources/pays.csv";
    
    public static void main(String[] args) {
        // Declaration et Initialisation d'un tableu statique
        String [] tPays = null;
        
        // Declaration et Instanciation d'un tableau dynamique
        List<String> liste = new ArrayList();
        
        try {
            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader(FICHIER_PAYS);
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            StringBuilder lsbContenu = new StringBuilder();
            String lsLigne;
            //Instanciation d'un tableau dynamiue pour ranger chaque ligne de mon fichier
            ArrayList nbLigne = new ArrayList();
            
            String[] tChamps ;
            String nomPays;
            // Je boucle sur le fichier
            while ((lsLigne = lbrBuffer.readLine()) != null) {
                lsLigne = lsLigne.trim();// Je retire tous les caracteres "parasites"
                
                // Gestion des erreurs
                // Si la ligne n'est pas vide
                if(lsLigne.length() > 0){
                    tChamps = lsLigne.split("\",\"");// J ' explose ma chaine de caracteres
                    
                    // Si le tableau a bien 6 champs je recupere le 5e champ
                    if(tChamps.length == 6){
                        liste.add(tChamps[4]);
                    }
                }        
            }
            // Je converti mon tableau dynamique en statique
            tPays = liste.toArray(new String[liste.size()]);
            
            // Fermeture des fichiers
            lbrBuffer.close();
            lfrFichier.close();

            System.out.println(nbLigne);
            
            // Gestion des erreurs
        } catch (FileNotFoundException e) {
            System.err.println("Erreur de fichier : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur de lecture : " + e.getMessage());
        }
    }/// Main
        
}/// ImportFichier
