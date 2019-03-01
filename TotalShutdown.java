import java.io.*; 

public class TotalShutdown {

	public static void schlafen(int schlafenszeit) {
		try {
    		Thread.sleep(schlafenszeit);                 
		} 
		catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}
	}

	public static void stringDelayer(String myString, int schlafenszeit, int breakBool) {
		
		String str = myString;
		char[] charArray = str.toCharArray();

		for(int i = 0;i < charArray.length ; i++) {
		     System.out.print(charArray[i]);
		     schlafen(schlafenszeit);
		}
		if(breakBool == 1) {			
			System.out.println("");		
		}
	}

    // shutdown the pc:
    public static void osAndShutdown(){

        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try {
            if (os.contains("win")){
                // operating system is based on Windows
                rt.exec("shutdown");
            } else if (os.contains("osx")){
                // operating system is Apple OSX based
                rt.exec("shutdown -h now"); // not shure
            } else if (os.contains("nux") || os.contains("nix") || os.contains("aix")){
                // operating system is based on Linux/Unix/*AIX
                //rt.exec("shutdown -h 30");
                // you may need to start the java application as root to make 
                // the shutdown work!
            }
        } catch (Exception ex) {
            // do nothing.
            System.out.println("Kein Shutdown - Fehler: "+ex);
        }
    }

    public static void loadBar() {
			stringDelayer("===                 ( 17%)", 10, 1);
			stringDelayer("=====               ( 34%)", 10, 1);
			stringDelayer("==========          ( 50%)", 8, 1);
			stringDelayer("==============      ( 67%)", 7, 1);
			stringDelayer("=================   ( 82%)", 5, 1);
            stringDelayer("====================(100%)", 8, 1);	
    }

	public static void readCSV() {
        String csvFile = "shutdown.csv";
        BufferedReader buffReader = null;
        String oneLine = "";
        String cvsSplitBy = ",";

		try {
	        buffReader = new BufferedReader(new FileReader(csvFile));

            while ((oneLine = buffReader.readLine()) != null) {

                // use comma as separator
                String[] sdText = oneLine.split(cvsSplitBy);
				sdText[0] = sdText[0].replace("\"", " ");
				stringDelayer(sdText[0], 2, 1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}



	public static void main(String[] args)
	{
		String text = "Total Shutdown";
		int tl = text.length();
		System.out.print("\n");
		
stringDelayer("......................................................................................................................",3,1);
stringDelayer("....................._________ .. ________..... _________ .. ________..... ___........................................",3,1);
stringDelayer("....................|\\___   ___\\.|\\   __  \\....|\\___   ___\\.|\\   __  \\....|\\  \\.......................................",3,1);
stringDelayer("....................\\|___ \\  \\_|.\\ \\  \\|\\  \\...\\|___ \\  \\_|.\\ \\  \\|\\  \\...\\ \\  \\......................................",3,1);
stringDelayer(".........................\\ \\  \\...\\ \\  \\\\\\  \\.......\\ \\  \\...\\ \\   __  \\...\\ \\  \\.....................................",3,1);
stringDelayer("..........................\\ \\  \\...\\ \\  \\\\\\  \\.......\\ \\  \\...\\ \\  \\ \\  \\...\\ \\  \\____................................",3,1);
stringDelayer("...........................\\ \\__\\...\\ \\_______\\.......\\ \\__\\...\\ \\__\\ \\__\\...\\ \\_______\\..............................",3,1);
stringDelayer("............................\\|__|....\\|_______|........\\|__|....\\|__|\\|__|....\\|_______|..............................",2,1);
stringDelayer("......................................................................................................................",2,1);
stringDelayer("......................................................................................................................",2,1);
stringDelayer("......................................................................................................................",2,1);
stringDelayer(" ________ ......___  ___..... ___  ___..... _________ .. ________......________......___.......__.......________  ....",2,1);
stringDelayer("|\\   ____\\.....|\\  \\|\\  \\....|\\  \\|\\  \\....|\\___   ___\\.|\\   ___ \\....|\\   __  \\....|\\  \\.....|\\  \\....|\\   ___  \\....",2,1);
stringDelayer("\\ \\  \\___|_... \\ \\  \\\\\\  \\...\\ \\  \\\\\\  \\...\\|___ \\  \\_|.\\ \\  \\_|\\ \\...\\ \\  \\|\\  \\...\\ \\  \\....\\ \\  \\...\\ \\  \\\\ \\  \\...",2,1);
stringDelayer(".\\ \\_____  \\ ...\\ \\   __  \\...\\ \\  \\\\\\  \\.......\\ \\  \\...\\ \\  \\ \\\\ \\...\\ \\  \\\\\\  \\...\\ \\  \\..__\\ \\  \\...\\ \\  \\\\ \\  \\..",2,1);
stringDelayer("..\\|____|\\  \\ ...\\ \\  \\ \\  \\...\\ \\  \\\\\\  \\.......\\ \\  \\...\\ \\  \\_\\\\ \\...\\ \\  \\\\\\  \\...\\ \\  \\|\\__\\_\\  \\...\\ \\  \\\\ \\  \\.",2,1);
stringDelayer("... ____\\_\\  \\....\\ \\__\\ \\__\\...\\ \\_______\\.......\\ \\__\\...\\ \\_______\\...\\ \\_______\\...\\ \\____________\\...\\ \\__\\\\ \\__\\",4,1);
stringDelayer("...|\\_________\\....\\|__|\\|__|....\\|_______|........\\|__|....\\|_______|....\\|_______|....\\|____________|....\\|__| \\|__|",1,1);
stringDelayer("....\\|_________| ......................................................................................................",1,1);
stringDelayer("......................................................................................................................",2,1);
stringDelayer("......................................................................................................................",2,1);
		
		System.out.println(" \n");

		loadBar();

		System.out.println(" \n");
		
		stringDelayer("Enabling shutdown hack", 4, 1);
		stringDelayer("default catalog not found, installing...", 4,1);
		stringDelayer("environment init", 3, 1);
		stringDelayer("Loading local Power Reactors... initialized", 3, 1);
		stringDelayer("catalog download failure:http://fgfs.goneabitbursar.com/pkg/3.4.0/default-catalog.xml", 3, 1);
		stringDelayer("Found at least one of the following objects for animation: 'terminal_2'", 2, 1);
		stringDelayer("Could not find at least one of the following objects for animation: 'terminal_2'", 2, 1);
		stringDelayer("Objects/e000n40/e007n46/3072521.stg: load ControlPanel_SHARED 'Models/LSGS_GrassHangar.ac'", 2, 1);
		stringDelayer("Objects/e000n40/e007n46/3072521.stg: load POWER_CONTROL 'LSGS_GrassHangar.ac'", 1, 1);
		stringDelayer("Initializing Error in ground network. Failed to find first waypoint: 0 at LSGG", 1, 1);
		
		System.out.println(" \n");

		stringDelayer("Initialized. Process is in progress. User input required", 8, 1);

		System.out.println(" \n");

		stringDelayer("4lf4N|cK3oooyes@MSKILLER: Total Shutdown.", 10, 0);

		String placeholder = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("Deconstruct Power Lines ... initialized", 4, 1);
		stringDelayer("canvas::Text: No such font: DSEG/DSEG7/Classic-MINI/DSEG7ClassicMini-Bold.ttf", 4, 1);
		stringDelayer("MEDS : CDR1 Load SVG 1", 4, 1);
		stringDelayer("Nasal runtime error: No such member: setColor", 1, 1);
		stringDelayer("  at /home/holger/FlightGear/Aircraft/SpaceShuttle/Nasal/PFD/p_pfd.nas, line 21", 1, 1);
		stringDelayer("  called from: /Nasal/PFD/PFD_main.nas, line 408", 3, 1);
		stringDelayer("  called from: //PFD/PFD_main.nas, line 402", 2, 1);
		stringDelayer("  called from: /Nasal/PFD/PFD_main.nas, line 924", 2, 1);
		stringDelayer("HUD [HUDImage1] Parse SVG 1", 1, 1);
		stringDelayer("HUD [HUDImage2] Parse SVG 1", 3, 1);

		System.out.println(" \n");

		stringDelayer("4lf4N|cK3oooyes@MSKILLER: Are you sure?", 10, 0);

		String placeholder2 = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("Enabling water pumps hack", 1, 1);
		stringDelayer("default catalog found, installing Shutdown...", 1, 1);
		stringDelayer("environment init loading local System Passwords routines...", 1, 1);
		stringDelayer("crash system –-dynamic shutdwon ... initialized", 2, 1);
		stringDelayer("EFB Computer ........ Initialized", 2, 1);
		stringDelayer("REACTOR control ... initialized", 4, 1);
		stringDelayer("find at least one of the following objects for animation: 'terminal_2'", 1, 1);
		stringDelayer("find at least one of the following objects for animation: 'terminal_2'", 1, 1);
		stringDelayer("EHSEZTIKDFFB Computer ........ Initialized", 4, 1);
		stringDelayer("MultiPower --dual control ... initialized", 2, 1);

		System.out.println(" \n");

		stringDelayer("4lf4N|cK3oooyes@MSKILLER: Are you scared?", 10, 0);

		String placeholder3 = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("Total Shutdown Confirmed. Energy providers shut down. Infrastructure is down. Self-regulation options are deactivated.", 6, 1);

		readCSV();




		stringDelayer("                                            `-:+oosssso+/:.                                         ",3,1);
		stringDelayer("                                        -+ymNMMMMMMMMMMMMMMNhs:`                                    ",3,1);
		stringDelayer("                                    `:smMMMMMMMMMMMMMMMMMMMMMMMNh+.                                 ",3,1);
		stringDelayer("                                  -omMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNh/`                              ",3,1);
		stringDelayer("                                :hNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmo.                            ",3,1);
		stringDelayer("                             -hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN+                            ",2,1);
		stringDelayer("                             :NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMy                          ",2,1);
		stringDelayer("                            .mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMo                         ",2,1);
		stringDelayer("                            sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN.                        ",2,1);
		stringDelayer("                           `NMMMNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+                        ",2,1);
		stringDelayer("                           -MMMMNmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMdMMMMh                        ",2,1);
		stringDelayer("                           /MMMMMyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMhNMMMMm                        ",2,1);
		stringDelayer("                           +MMMMMhdMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMoMMMMMm                        ",2,1);
		stringDelayer("                           :MMMMNyhMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNomMMMMd                        ",2,1);
		stringDelayer("                           `NMMMymMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMhdMMMo                        ",2,1);
		stringDelayer("                            +MMsmMMMMNNmdhdmNMMMMMMMMMMMMMMNdhdmNNNMMMMoNMd.                        ",1,1);
		stringDelayer("                            .NmoMMNs:-..`  .:odMMMMMMMMMNy/.`  `..-+dMMdsMo                         ",1,1);
		stringDelayer("                              hsdMN-           `/NMMMMMMh.           `yMM+m-                        ",1,1);
		stringDelayer("                             ::NMh              dMMMMMM:             -MMo/                          ",1,1);
		stringDelayer("                            `:yMMh             -MMMMMMMy`            -MMm/-                         ",1,1);
		stringDelayer("                            oMMMMN`          `+NMMdNdmMMy-`          oMMMMm`                        ",1,1);
		stringDelayer("                            .dMMMMy.`   ``./smMMm/ y..yMMNh+-.`    `:NMMMM+                         ",1,1);
		stringDelayer("                              -MMMMMmyysyhmMMMMMm.  y.  sMMMMMNdyysydMMMMMy                         ",1,1);
		stringDelayer("                              +NMMMMMMMMMMMMMMM/   d/   dMMMMMMMMMMMMMMMh.                          ",1,1);
		stringDelayer("                               .+dNMMMMMMMMMMMM:  .Ns   dMMMMMMMMMMMNms:                            ",1,1);
		stringDelayer("                                  :yyy+:+mMMMMMd-`oMm.`oMMMMMMs::yyyo`                              ",1,1);
		stringDelayer("                                  +MMM/  sMMMMMMMmMMMNNMMMMMMM` `mMMm`                              ",1,1);
		stringDelayer("                ```               hMMMo  oddMMMMMMMMMMMMMMMNym` .NMMM-                              ",1,1);
		stringDelayer("              `ohdho:`            dMMMMh+oydhhhNmNmMNmNNmdhydy-ymMMMM:            -+syhy-           ",1,1);
		stringDelayer("              smmmmmmms`          :NMMMMMmsyhNmdNyMyNmyNhMdsdyNMMMMMy`          -hmmmmmmm-          ",1,1);
		stringDelayer("           `+mmmmmmmmms`          .dMMMMMdyyh+mmdMhMMyNyssmsNMMMMN+           :dmmmmmmmmy`          ",1,1);
		stringDelayer("          `/ymmmmmmmmmmmd+`         `dMMMMMNhyhhhsmoNsdyNohmMMMMMM/          .smmmmmmmmmmmds:       ",1,1);
		stringDelayer("         `dmmmmmmmmmmmmmmmh+`        .NMMMMMMMdhhhmoNymydNMMMMMMMs         .odmmmmmmmmmmmmmmmo      ",1,1);
		stringDelayer("         `dmmmmmmmmmmmmmmmmmdo.       :NMMMMMMMMMMNNNMMMMMMMMMMMy`       -sdmmmmmmmmmmmmmmmmm/      ",1,1);
		stringDelayer("          -dmmmmmmmmmmmmmmmmmmmy/.     .yMMMMMMMMMMMMMMMMMMMMMm+      -+hmmmmmmmmmmmmmmmmmmm/       ",1,1);
		stringDelayer("           -hmmmmmmmmmmmmmmmmmmmmds/.   `-smMMMMMMMMMMMMMMMNh/`   `-+hmmmmmmmmmmmmmmmmmmmmm+        ",1,1);
		stringDelayer("            `:////////+oyhmmmmmmmmmmdy+-`  `:sdmmmmmmmmmdy+.`  `:ohmmmmmmmmmmdyso+/:::::/:.         ",1,1);
		stringDelayer("                        ``./shmmmmmmmmmmho:`  ```````````   ./sdmmmmmmmmmdy+-``                     ",1,1);
		stringDelayer("                             `-/shmmmmmmmmmds/.         `-+ydmmmmmmmmmho:.`                         ",1,1);
		stringDelayer("                                ``-+ydmmmmmmmmdy/-   `:ohdmmmmmmmmds/.`                             ",1,1);
		stringDelayer("                                     `./shmmmmmmmmdy+:sdmmmmmmmdyo:`                                ",1,1);
		stringDelayer("                                        `-+ydmmmmmmmdhsooshhs/.`                                    ",1,1);
		stringDelayer("                                            `:+ydmmmmmmmmhs/-                                       ",1,1);
		stringDelayer("                                         .:ohdhhssyhdmmmmmmmdy/-`                                   ",1,1);
		stringDelayer("                                    `-/ydmmmmmmmmy/-/sdmmmmmmmdho:`                                 ",1,1);
		stringDelayer("                                 .:ohdmmmmmmmmhs:.    ./ydmmmmmmmmds/-`                             ",1,1);
		stringDelayer("                             `.-+ydmmmmmmmmmds:.          ./ydmmmmmmmmdhs/.`                        ",1,1);
		stringDelayer("                    ````.-:+yhmmmmmmmmmmds:.               `-+hmmmmmmmmmmdhs+:..```                 ",1,1);
		stringDelayer("            .:+ssoosyyhhdmmmmmmmmmmmmdy/.                     `-ohmmmmmmmmmmmmddhhyyso+ooo:`        ",1,1);
		stringDelayer("``        `/hmmmmmmmmmmmmmmmmmmmmmdy+-`                          `-ohmmmmmmmmmmmmmmmmmmmmmmh.       ",1,1);
		stringDelayer("```       .dmmmmmmmmmmmmmmmmmmmmh+-`                                `:shmmmmmmmmmmmmmmmmmmmm/       ",1,1);
		stringDelayer("````      `ymmmmmmmmmmmmmmmmmdo:`                                      `:sdmmmmmmmmmmmmmmmmd`       ",1,1);
		stringDelayer("`````      `/ommmmmmmmmmmmmy/`                                            .+hmmmmmmmmmmmmh/.        ",1,1);
		stringDelayer("``````        ymmmmmmmmmms-`                                                `/hmmmmmmmmmm-          ",1,1);
		stringDelayer("````````      /mmmmmmmmh-`                                                    `+mmmmmmmmy`          ",1,1);
		stringDelayer("`````````     `:osyyys/`                                                        -shhdhy+`           ",1,1);
		stringDelayer("```````````                                                                                         ",1,1);
		stringDelayer("````````````                                                                                        ",1,1);
		stringDelayer("``````````````                                                                                      ",1,1);
		stringDelayer("```````````````                                                                                     ",1,1);
		stringDelayer("`````````````````                                                                                   ",1,1);



        stringDelayer("Shutdown Initialized.", 5, 1);
        loadBar();
        stringDelayer("O-: BYE BYE :-O", 5,1);		
        osAndShutdown();         

}
}
