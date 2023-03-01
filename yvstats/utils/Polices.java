package yvstats.utils;
import java.awt.Font;
import java.io.File;

public class Polices {
    public static final int T45 = 45;
    public static final int T30 = 30;
    public static final int T27 = 27;
    public static final int T20 = 20;
    public static Font arista_pro_light;
    public static Font arista_pro_fat;
    public static Font arista_pro_bold;
    public static Font arista_pro_light_30;
    public static Font arista_pro_light_20;
    public static Font arista_pro_light_titre;
    public static Font arista_pro_icons_light;
    public static Font arista_pro_icons_semibold;
    public static Font arista_pro_icons_bold;

    public static void creerPolices() {
        System.out.print("Loading polices datas... ");
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
            arista_pro_icons_light = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/arista-pro-icons-light.ttf"));
            arista_pro_icons_light = arista_pro_icons_light.deriveFont(45.0f);
            arista_pro_icons_semibold = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/arista-pro-icons-semibold.ttf"));
            arista_pro_icons_semibold = arista_pro_icons_semibold.deriveFont(45.0f);
            arista_pro_icons_bold = Font.createFont(Font.PLAIN, new File("../ressources/font/arista_pro/arista-pro-icons-bold.ttf"));
            arista_pro_icons_bold = arista_pro_icons_bold.deriveFont(45.0f);
            System.out.println("done\n");
        } catch (Exception e) { e.printStackTrace(); }
    }
}