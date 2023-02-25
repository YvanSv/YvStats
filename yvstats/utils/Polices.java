package yvstats.utils;
import java.awt.Font;
import java.io.File;

public class Polices {
    public static Font arista_pro_light;
    public static Font arista_pro_fat;
    public static Font arista_pro_bold;
    public static Font arista_pro_light_30;
    public static Font arista_pro_light_20;
    public static Font arista_pro_light_titre;

    public static void creerPolices() {
        try {
            arista_pro_light = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/Arista-Pro-light.ttf"));
            arista_pro_light = arista_pro_light.deriveFont(45.0f);
            arista_pro_light_30 = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/Arista-Pro-light.ttf"));
            arista_pro_light_30 = arista_pro_light_30.deriveFont(30.0f);
            arista_pro_light_20 = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/Arista-Pro-light.ttf"));
            arista_pro_light_20 = arista_pro_light_20.deriveFont(20.0f);
            arista_pro_light_titre = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/Arista-Pro-light.ttf"));
            arista_pro_light_titre = arista_pro_light_titre.deriveFont(27.0f);
            arista_pro_fat = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/Arista-Pro-fat.ttf"));
            arista_pro_fat = arista_pro_fat.deriveFont(45.0f);
            arista_pro_bold = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/Arista-Pro-bold.ttf"));
            arista_pro_bold = arista_pro_bold.deriveFont(45.0f);
            
        } catch (Exception e) { e.printStackTrace(); }
    }
}
