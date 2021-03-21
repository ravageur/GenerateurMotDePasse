package fr.ravageur.generateurmotdepasse;

import java.util.Random;

public class Generateur 
{
    /**
     * Cette méthode permet de générer un mot de passe aléatoire en fonction du 
     * nombre maximum de caractères donnée.
     * 
     * @param nbCaracteresMax
     * @return String
     */
    public static String genererMotDePasse(int nbCaracteresMax)
    {
        String motDePasse = "";
        int codePoint;
        for(int i = 0; i < nbCaracteresMax; i++)
        {
            while(true)
            {
                codePoint = est(new Random().nextInt(256));
                if(codePoint != 0)
                {
                    break;
                }
            }
            motDePasse += Character.toChars(codePoint)[0];
        }
        return motDePasse;
    }

    private static int est(int codePoint)
    {
        if(codePoint > 32 && codePoint < 126)
        {
            return codePoint;
        }
        else
        {
            return 0;
        }
    }
}
