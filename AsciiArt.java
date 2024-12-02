public class AsciiArt {
    public static void main(String[] args) {
        String[] colors = {
            "\u001B[31m",
            "\u001B[35m",
            "\u001B[34m",
            "\u001B[33m",
            "\u001B[32m",
            "\u001B[35m",
            "\u001B[36m",
            "\u001B[37m" 
        };
        String resetColor = "\u001B[0m";
        String greenBold = "\033[1;32m";
        String purpleBold = "\033[1;35m";
        String whiteBold = "\033[1;37m";
        String redBold = "\033[1;31m";
        String cyanBold = "\033[1;36m";
        String red = "\033[31m";         // Kırmızı
        String green = "\033[32m";       // Yeşil
        String yellow = "\033[33m";      // Sarı
        String blue = "\033[34m";        // Mavi
        String purple = "\033[35m";      // Mor
        String cyan = "\033[36m";        // Camgöbeği
        String white = "\033[37m";       // Beyaz
        
        String[] asciiArts = {
                 " __      _____________.____   _________  ________      _____  ___________ \n" +
                "/  \\    /  \\_   _____/|    |  \\_   ___ \\ \\_____  \\    /     \\ \\_   _____/ \n" +
                "\\   \\/\\/   /|    __)_ |    |  /    \\  \\/  /   |   \\  /  \\ /  \\ |    __)_  \n" +
                " \\        / |        \\|    |__\\     \\____/    |    \\/    Y    \\|        \\ \n" +
                "  \\__/\\  / /_______  /|_______ \\______  /\\_______  /\\____|__  /_______  / \n" +
                "       \\/          \\/         \\/      \\/         \\/         \\/        \\/  ",


                "\t __      _____________      _____ _____________________\n" +
                "\t/  \\    /  \\_   _____/     /  _  \\\\______   \\_   _____/\n" +
                "\t\\   \\/\\/   /|    __)_     /  /_\\  \\|       _/|    __)_ \n" +
                "\t \\        / |        \\   /    |    \\    |   \\|        \\\n" +
                "\t  \\__/\\  / /_______  /   \\____|__  /____|_  /_______  /\n" +
                "\t       \\/          \\/            \\/       \\/        \\/ ",


                "________  .__.__       .__            _____            .___.__        \n" +
                "\\______ \\ |__|  |___  _|__| ____     /  _  \\ ___.__. __| _/|__| ____  \n" +
                " |    |  \\|  |  |\\  \\/ /  |/    \\   /  /_\\  <   |  |/ __ | |  |/    \\ \n" +
                " |    `   \\  |  |_\\   /|  |   |  \\ /    |    \\___  / /_/ | |  |   |  \\\n" +
                "/_______  /__|____/\\_/ |__|___|  / \\____|__  / ____\\____ | |__|___|  /\n" +
                "        \\/                     \\/          \\/\\/         \\/         \\/ ",


                "__________     .__         .__      _________                                    \n" +
                "\\____    /__ __|  | _____  |  |    /   _____/ ____   ____   _____   ____ ________\n" +
                "  /     /|  |  \\  | \\__  \\ |  |    \\_____  \\ /  _ \\ /    \\ /     \\_/ __ \\\\___   /\n" +
                " /     /_|  |  /  |__/ __ \\|  |__  /        (  <_> )   |  \\  Y Y  \\  ___/ /    / \n" +
                "/_______ \\____/|____(____  /____/ /_______  /\\____/|___|  /__|_|  /\\___  >_____ \\\n" +
                "        \\/               \\/               \\/            \\/      \\/     \\/      \\/",

                "  _________                     .__     _____                      .__               .__  .__ \n" +
                " /   _____/ ____ _____________  |__|   /  _  \\____________  ______ |  | _____ _______|  | |__|\n" +
                " \\_____  \\_/ __ \\\\___   /\\__  \\ |  |  /  /_\\  \\_  __ \\__  \\ \\____ \\|  | \\__  \\\\_  __ \\  | |  |\n" +
                " /        \\  ___/ /    /  / __ \\|  | /    |    \\  | \\// __ \\|  |_> >  |__/ __ \\|  | \\/  |_|  |\n" +
                "/_______  /\\___  >_____ \\(____  /__| \\____|__  /__|  (____  /   __/|____(____  /__|  |____/__|\n" +
                "        \\/     \\/      \\/     \\/             \\/           \\/|__|             \\/               ",

                "___________                  .__                    ___________                   \n"+
    		    "\\__    ___/_ __  ____ _____  |  |__ _____    ____   \\__    ___/_ __________ ____  \n"+
    		    "  |    | |  |  \\/    \\\\__  \\ |  |  \\\\__  \\  /    \\    |    | |  |  \\___   // __ \\ \n"+
    		    "  |    | |  |  /   |  \\/ __ \\|   Y  \\/ __ \\|   |  \\   |    | |  |  //    /\\  ___/ \n"+
    		    "  |____| |____/|___|  (____  /___|  (____  /___|  /   |____| |____//_____ \\\\___  >\n"+
                "                    \\/     \\/     \\/     \\/     \\/                       \\/    \\/ ",

                "___________       .__         ___________                   .___   _________      .__    .__        \n"+
    		    "\\_   _____/ _____ |__|______  \\_   _____/ ___________     __| _/  /   _____/____  |  |__ |__| ____  \n"+
    		    " |    __)_ /     \\|  \\_  __ \\  |    __)_ /  ___/\\__  \\   / __ |   \\_____  \\\\__  \\ |  |  \\|  |/    \\ \n"+
    		    " |        \\  Y Y  \\  ||  | \\/  |        \\\\___ \\  / __ \\_/ /_/ |   /        \\/ __ \\|   Y  \\  |   |  \\\n"+
    		    "/_______  /__|_|  /__||__|    /_______  /____  >(____  /\\____ |  /_______  (____  /___|  /__|___|  /\n"+
                "        \\/      \\/                    \\/     \\/      \\/      \\/          \\/     \\/     \\/    \n\n",
        };

        for (int i = 0; i < asciiArts.length; i++) {
            String color = colors[i % colors.length]; 
            System.out.println(color + asciiArts[i] + resetColor);
            System.out.println();
        }
    

        System.out.println(greenBold+"---------------------------------------------------------"+cyanBold+" Welcome to our second project"+greenBold+"------------------------------------------------------------------------------"+"\n"+"\n"+resetColor);
        System.out.println(purpleBold+"/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\ "+whiteBold+"A little reminder for those who forget what our first project was like"+purpleBold+ "/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/"+resetColor);
        System.out.println();
        System.out.println();
        System.out.println(cyan+" +--^----------,--------,-----,-------^-,"+whiteBold+"\t\t\t\t\t\t                                 ,-----' | "+red+"__,_~~___<'__`)-~__--__-~-> "+resetColor);
        System.out.println(cyan+" | |||||||||   `--------'     |          O"  +redBold+ "   ---   ||   ---   \\\\\\\\\\\\   \\\\\\     "+whiteBold+"\t                                         | //  : |"+red+" -__   ~__ o)____)),__ - '>  ) "+resetColor);            
        System.out.println(cyan+" `+---------------------------^--------|"+whiteBold+"\t\t\t\t\t\t                                 | //  : |"+red+"- \\\\_ \\\\ -\\\\_\\\\ -\\\\ \\\\ \\ ~\\\\_  \\ ->"+resetColor);
        System.out.println(cyan+"   `\\_,---------,---------,----------'"+whiteBold+"\t\t\t\t\t\t\t                                 | //  : |"+redBold+"_~_\\\\ -\\\\__\\\\ \\\\~'\\\\ \\\\ \\\\, \\\\__ .-"+resetColor);
        System.out.println(cyan+"     / XXXXXX /'|       /'"+"\t\t\t\t\t\t\t\t\t\t"+whiteBold+"                 `-----._|"+redBold+" `  -__`-- - ~~ -- ` --~> >"+resetColor);
        System.out.println(cyan+"    / XXXXXX /  `\\    /'"+"\t\t\t\t\t\t\t\t\t\t\t"+whiteBold+"           _/___\\_    //)_`//  | ||"+yellow+"]"+resetColor);
        System.out.println(cyan+"   / XXXXXX /`-------'"+"\t\t\t\t\t\t\t\t\t\t\t\t"+whiteBold+"     "+blue+"_____"+whiteBold+"[_______]"+blue+"_"+whiteBold+"[~~-_ (.L_/  |"+yellow+"|"+resetColor);
        System.out.println(cyan+"  / XXXXXX /"+"\t\t\t\t\t\t\t\t\t\t\t\t"+whiteBold+"            "+blue+"[____________________]"+whiteBold+"' `\\_,/'"+yellow+"/"+resetColor);
        System.out.println(cyan+" / XXXXXX /"+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+blue+"      ||| /          |||  "+whiteBold+",___,'."+yellow+"/"+resetColor);
        System.out.println(cyan+"(________("+"\t\t\t\t\t\t\t\t\t\t\t\t\t"+blue+"      ||| \\          |||"+whiteBold+",'"+yellow+"______|"+resetColor);
        System.out.println("                 "+"\t\t\t\t\t\t\t\t\t\t\t\t"+blue+"      ||| /"+white+"          /"+blue+"||"+yellow+" I==||"+resetColor);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+blue+"      ||| \\       "+whiteBold+"__/"+blue+"_||"+yellow+"  __||__"+resetColor);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+green+" -----"+blue+"||"+green+"-/------`-"+whiteBold+"._/"+blue+"||"+green+"-"+yellow+"o"+green+"--"+yellow+"o"+green+"---"+yellow+"o"+green+"---"+resetColor);
        System.out.println();
        System.out.println();
        System.out.println(red+"İlktan Hoca and his assistants"+resetColor);
        System.out.println(purple+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Us and our first projectz"+resetColor);



        
        
            
        
        
    }
}
