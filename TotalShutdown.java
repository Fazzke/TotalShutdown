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
        try {
            System.out.print("===                 ( 17%)\r");
            Thread.sleep(10);
            System.out.print("==========          ( 50%)\r");
            Thread.sleep(10);
            System.out.print("====================(100%)\r");
            Thread.sleep(10);
        } catch (Exception ex) {
            // do nothing. 
            // catching the exception is required for the Thread.sleep() function.
            // is it possible to ignore exceptions for the whole program?
        }	
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
		
		//__________________________________________________________________________
// stringDelayer("                                                                                                                      ",4,1);
// stringDelayer("                     _________    ________      _________    ________      ___                                        ",4,1);
// stringDelayer("                    |\___   ___\ |\   __  \    |\___   ___\ |\   __  \    |\  \                                       ",4,1);
// stringDelayer("                    \|___ \  \_| \ \  \|\  \   \|___ \  \_| \ \  \|\  \   \ \  \                                      ",4,1);
// stringDelayer("                         \ \  \   \ \  \\\  \       \ \  \   \ \   __  \   \ \  \                                     ",4,1);
// stringDelayer("                          \ \  \   \ \  \\\  \       \ \  \   \ \  \ \  \   \ \  \____                                ",4,1);
// stringDelayer("                           \ \__\   \ \_______\       \ \__\   \ \__\ \__\   \ \_______\                              ",4,1);
// stringDelayer("                            \|__|    \|_______|        \|__|    \|__|\|__|    \|_______|                              ",4,1);
// stringDelayer("                                                                                                                      ",4,1);
// stringDelayer("                                                                                                                      ",4,1);
// stringDelayer("                                                                                                                      ",4,1);
// stringDelayer(" ________       ___  ___      ___  ___      _________    ________      ________      ___       __       ________      ",4,1);
// stringDelayer("|\   ____\     |\  \|\  \    |\  \|\  \    |\___   ___\ |\   ___ \    |\   __  \    |\  \     |\  \    |\   ___  \    ",4,1);
// stringDelayer("\ \  \___|_    \ \  \\\  \   \ \  \\\  \   \|___ \  \_| \ \  \_|\ \   \ \  \|\  \   \ \  \    \ \  \   \ \  \\ \  \   ",4,1);
// stringDelayer(" \ \_____  \    \ \   __  \   \ \  \\\  \       \ \  \   \ \  \ \\ \   \ \  \\\  \   \ \  \  __\ \  \   \ \  \\ \  \  ",4,1);
// stringDelayer("  \|____|\  \    \ \  \ \  \   \ \  \\\  \       \ \  \   \ \  \_\\ \   \ \  \\\  \   \ \  \|\__\_\  \   \ \  \\ \  \ ",4,1);
// stringDelayer("    ____\_\  \    \ \__\ \__\   \ \_______\       \ \__\   \ \_______\   \ \_______\   \ \____________\   \ \__\\ \__\",4,1);
// stringDelayer("   |\_________\    \|__|\|__|    \|_______|        \|__|    \|_______|    \|_______|    \|____________|    \|__| \|__|",4,1);
// stringDelayer("   \|_________|                                                                                                       ",4,1);
// stringDelayer("                                                                                                                      ",4,1);
// stringDelayer("                                                                                                                      ",4,1);
		stringDelayer(".................................................................",4,1);
		stringDelayer(".........######...####...######...####...##.....................",4,1);
		stringDelayer("...........##....##..##....##....##..##..##.....................",4,1);
		stringDelayer("...........##....##..##....##....######..##.....................",4,1);
		stringDelayer("...........##....##..##....##....##..##..##.....................",4,1);
		stringDelayer("...........##.....####.....##....##..##..######.................",4,1);
		stringDelayer("................................................................",4,1);
		stringDelayer("..####...##..##..##..##..######..#####....####...##...##..##..##.",4,1);
		stringDelayer(".##......##..##..##..##....##....##..##..##..##..##...##..###.##.",4,1);
		stringDelayer("..####...######..##..##....##....##..##..##..##..##.#.##..##.###.",4,1);
		stringDelayer(".....##..##..##..##..##....##....##..##..##..##..#######..##..##.",4,1);
		stringDelayer("..####...##..##...####.....##....#####....####....##.##...##..##.",4,1);
		stringDelayer(".................................................................",4,1);
		
		System.out.println(" \n");


		stringDelayer("Initialized. Process is in progress. User input required", 10, 1);

		System.out.println(" \n");

		stringDelayer("Enabling shutdown hack", 2, 1);
		stringDelayer("default catalog not found, installing...", 2,1);
		stringDelayer("environment init", 2, 1);
		stringDelayer("Loading local Power Reactors... initialized", 2, 1);
		stringDelayer("catalog download failure:http://fgfs.goneabitbursar.com/pkg/3.4.0/default-catalog.xml", 2, 1);
		stringDelayer("Found at least one of the following objects for animation: 'terminal_2'", 2, 1);
		stringDelayer("Could not find at least one of the following objects for animation: 'terminal_2'", 2, 1);
		stringDelayer("Objects/e000n40/e007n46/3072521.stg: load ControlPanel_SHARED 'Models/LSGS_GrassHangar.ac'", 2, 1);
		stringDelayer("Objects/e000n40/e007n46/3072521.stg: load POWER_CONTROL 'LSGS_GrassHangar.ac'", 2, 1);
		stringDelayer("Initializing Error in ground network. Failed to find first waypoint: 0 at LSGG", 2, 1);

		System.out.println(" \n");

		stringDelayer("4lf4N|cK3oooyes@MSKILLER: Total Shutdown.", 10, 0);

		String placeholder = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("Deconstruct Power Lines ... initialized", 2, 1);
		stringDelayer("canvas::Text: No such font: DSEG/DSEG7/Classic-MINI/DSEG7ClassicMini-Bold.ttf", 2, 1);
		stringDelayer("MEDS : CDR1 Load SVG 1", 2, 1);
		stringDelayer("Nasal runtime error: No such member: setColor", 2, 1);
		stringDelayer("  at /home/holger/FlightGear/Aircraft/SpaceShuttle/Nasal/PFD/p_pfd.nas, line 21", 2, 1);
		stringDelayer("  called from: /Nasal/PFD/PFD_main.nas, line 408", 2, 1);
		stringDelayer("  called from: //PFD/PFD_main.nas, line 402", 2, 1);
		stringDelayer("  called from: /Nasal/PFD/PFD_main.nas, line 924", 2, 1);
		stringDelayer("HUD [HUDImage1] Parse SVG 1", 2, 1);
		stringDelayer("HUD [HUDImage2] Parse SVG 1", 2, 1);

		System.out.println(" \n");

		stringDelayer("4lf4N|cK3oooyes@MSKILLER: Are you sure?", 10, 0);

		String placeholder2 = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("Enabling water pumps hack", 2, 1);
		stringDelayer("default catalog found, installing Shutdown...", 2, 1);
		stringDelayer("environment init loading local System Passwords routines...", 2, 1);
		stringDelayer("crash system –-dynamic shutdwon ... initialized", 2, 1);
		stringDelayer("EFB Computer ........ Initialized", 2, 1);
		stringDelayer("REACTOR control ... initialized", 2, 1);
		stringDelayer("find at least one of the following objects for animation: 'terminal_2'", 2, 1);
		stringDelayer("find at least one of the following objects for animation: 'terminal_2'", 2, 1);
		stringDelayer("EHSEZTIKDFFB Computer ........ Initialized", 2, 1);
		stringDelayer("MultiPower --dual control ... initialized", 2, 1);

		System.out.println(" \n");

		stringDelayer("4lf4N|cK3oooyes@MSKILLER: Are you scared?", 10, 0);

		String placeholder3 = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("Total Shutdown Confirmed. Energy providers shut down. Infrastructure is down. Self-regulation options are deactivated.", 10, 1);

		readCSV();

/*		stringDelayer("                         .Nmhso/-`                ",4,1);
		stringDelayer("                         hMMMMMMMMMmhyo/. ",4,1);
		stringDelayer("                 `.-::::+MMMMMMMMMMMMMm+`",4,1);
		stringDelayer("           ./ohmNMMMMMMMMMMMMMMMMMMMMo",4,1);
		stringDelayer("       `+hNMMMMMMNmdhyhMMMMMMMMMMMMMMMNh+-",4,1);
		stringDelayer("     :hMMMMMMMMo.     dMMMMMMMMMMyymMMMMMMNy/ ",4,1);
		stringDelayer("   :dMMMMNmMMMMMmo.  sMMMMMMMMMN/   `-+hNMMMMm+",4,1);
		stringDelayer(" `yMMMMh:  -omMMMMMmsMMMMMMMMMd.        `+NMMMMd-",4,1);
		stringDelayer(".mMMMh.       .omMMMMMMMMMMMMN/`           +NMMMN-",4,1);
		stringDelayer("dMMMy            -yMMMMMMMMMMMMMNo          .mMMMh",4,1);
		stringDelayer("MMMM/             yMMMMMMMMMMMMMy            .MMMN",4,1);
		stringDelayer("mMMM+             -/oydNMMMMMMMNo.            NMMM",4,1);
		stringDelayer("sMMMN`                 mMMMMMMMMMMd+`        +MMMd",4,1);
		stringDelayer(".NMMMd`               +MMMMMMd/yNMMMMh/`    :MMMN-",4,1);
		stringDelayer(" :NMMMm/             `NMMMMMd`  `:yNMMMMy:`sMMMM/",4,1);
		stringDelayer("  -dMMMMmo.          yMMMMMm`       :sNMMMMMMMN:",4,1);
		stringDelayer("    /hMMMMMms:`     -MMMMMm`          -hMMMMMd.",4,1);
		stringDelayer("      .omMMMMMMhs/-`dMMMMm`      .:ohNMMMMMh/ ",4,1);
		stringDelayer("         -odNMMMMMMMMMMMMdhhhhdmMMMMMMMmy/`",4,1);
		stringDelayer("             ./oydNMMMMMMMMMMMMMMMmho:`",4,1);
		stringDelayer("                  `MMMd-----:---.",4,1);
		stringDelayer("                  /MMo ",4,1);
		stringDelayer("                  hd-",4,1);
		stringDelayer("                 `o",4,1);               */


		stringDelayer("                                            `-:+oosssso+/:.                                         ",1,1);
		stringDelayer("                                        -+ymNMMMMMMMMMMMMMMNhs:`                                    ",1,1);
		stringDelayer("                                    `:smMMMMMMMMMMMMMMMMMMMMMMMNh+.                                 ",1,1);
		stringDelayer("                                  -omMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNh/`                              ",1,1);
		stringDelayer("                                :hNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmo.                          ",1,1);
		stringDelayer("                             -hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN+                        ",1,1);
		stringDelayer("                             :NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMy                      ",1,1);
		stringDelayer("                            .mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMo                    ",1,1);
		stringDelayer("                            sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN.                  ",1,1);
		stringDelayer("                           `NMMMNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+                 ",1,1);
		stringDelayer("                           -MMMMNmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMdMMMMh                    ",1,1);
		stringDelayer("                           /MMMMMyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMhNMMMMm                     ",1,1);
		stringDelayer("                           +MMMMMhdMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMoMMMMMm                    ",1,1);
		stringDelayer("                           :MMMMNyhMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNomMMMMd                   ",1,1);
		stringDelayer("                           `NMMMymMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMhdMMMo                   ",1,1);
		stringDelayer("                            +MMsmMMMMNNmdhdmNMMMMMMMMMMMMMMNdhdmNNNMMMMoNMd.                  ",1,1);
		stringDelayer("                            .NmoMMNs:-..`  .:odMMMMMMMMMNy/.`  `..-+dMMdsMo                   ",1,1);
		stringDelayer("                              hsdMN-           `/NMMMMMMh.           `yMM+m-                       ",1,1);
		stringDelayer("                             ::NMh              dMMMMMM:             -MMo/                       ",1,1);
		stringDelayer("                            `:yMMh             -MMMMMMMy`            -MMm/-                       ",1,1);
		stringDelayer("                            oMMMMN`          `+NMMdNdmMMy-`          oMMMMm`                      ",1,1);
		stringDelayer("                            .dMMMMy.`   ``./smMMm/ y..yMMNh+-.`    `:NMMMM+                      ",1,1);
		stringDelayer("                              -MMMMMmyysyhmMMMMMm.  y.  sMMMMMNdyysydMMMMMy                        ",1,1);
		stringDelayer("                              +NMMMMMMMMMMMMMMM/   d/   dMMMMMMMMMMMMMMMh.                       ",1,1);
		stringDelayer("                               .+dNMMMMMMMMMMMM:  .Ns   dMMMMMMMMMMMNms:                        ",1,1);
		stringDelayer("                                  :yyy+:+mMMMMMd-`oMm.`oMMMMMMs::yyyo`                         ",1,1);
		stringDelayer("                                  +MMM/  sMMMMMMMmMMMNNMMMMMMM` `mMMm`                            ",1,1);
		stringDelayer("                ```               hMMMo  oddMMMMMMMMMMMMMMMNym` .NMMM-                            ",1,1);
		stringDelayer("              `ohdho:`            dMMMMh+oydhhhNmNmMNmNNmdhydy-ymMMMM:            -+syhy-        ",1,1);
		stringDelayer("              smmmmmmms`          :NMMMMMmsyhNmdNyMyNmyNhMdsdyNMMMMMy`          -hmmmmmmm-       ",1,1);
		stringDelayer("           `+mmmmmmmmms`          .dMMMMMdyyh+mmdMhMMyNyssmsNMMMMN+           :dmmmmmmmmy`      ",1,1);
		stringDelayer("          `/ymmmmmmmmmmmd+`         `dMMMMMNhyhhhsmoNsdyNohmMMMMMM/          .smmmmmmmmmmmds:       ",1,1);
		stringDelayer("         `dmmmmmmmmmmmmmmmh+`        .NMMMMMMMdhhhmoNymydNMMMMMMMs         .odmmmmmmmmmmmmmmmo      ",1,1);
		stringDelayer("         `dmmmmmmmmmmmmmmmmmdo.       :NMMMMMMMMMMNNNMMMMMMMMMMMy`       -sdmmmmmmmmmmmmmmmmm/     ",1,1);
		stringDelayer("          -dmmmmmmmmmmmmmmmmmmmy/.     .yMMMMMMMMMMMMMMMMMMMMMm+      -+hmmmmmmmmmmmmmmmmmmm/     ",1,1);
		stringDelayer("           -hmmmmmmmmmmmmmmmmmmmmds/.   `-smMMMMMMMMMMMMMMMNh/`   `-+hmmmmmmmmmmmmmmmmmmmmm+       ",1,1);
		stringDelayer("            `:////////+oyhmmmmmmmmmmdy+-`  `:sdmmmmmmmmmdy+.`  `:ohmmmmmmmmmmdyso+/:::::/:.        ",1,1);
		stringDelayer("                        ``./shmmmmmmmmmmho:`  ```````````   ./sdmmmmmmmmmdy+-``                    ",1,1);
		stringDelayer("                             `-/shmmmmmmmmmds/.         `-+ydmmmmmmmmmho:.`                       ",1,1);
		stringDelayer("                                ``-+ydmmmmmmmmdy/-   `:ohdmmmmmmmmds/.`                           ",1,1);
		stringDelayer("                                     `./shmmmmmmmmdy+:sdmmmmmmmdyo:`                               ",1,1);
		stringDelayer("                                        `-+ydmmmmmmmdhsooshhs/.`                                  ",1,1);
		stringDelayer("                                            `:+ydmmmmmmmmhs/-                                     ",1,1);
		stringDelayer("                                         .:ohdhhssyhdmmmmmmmdy/-`                                 ",1,1);
		stringDelayer("                                    `-/ydmmmmmmmmy/-/sdmmmmmmmdho:`                              ",1,1);
		stringDelayer("                                 .:ohdmmmmmmmmhs:.    ./ydmmmmmmmmds/-`                         ",1,1);
		stringDelayer("                             `.-+ydmmmmmmmmmds:.          ./ydmmmmmmmmdhs/.`                     ",1,1);
		stringDelayer("                    ````.-:+yhmmmmmmmmmmds:.               `-+hmmmmmmmmmmdhs+:..```             ",1,1);
		stringDelayer("            .:+ssoosyyhhdmmmmmmmmmmmmdy/.                     `-ohmmmmmmmmmmmmddhhyyso+ooo:`   ",1,1);
		stringDelayer("``        `/hmmmmmmmmmmmmmmmmmmmmmdy+-`                          `-ohmmmmmmmmmmmmmmmmmmmmmmh. ",1,1);
		stringDelayer("```       .dmmmmmmmmmmmmmmmmmmmmh+-`                                `:shmmmmmmmmmmmmmmmmmmmm/     ",1,1);
		stringDelayer("````      `ymmmmmmmmmmmmmmmmmdo:`                                      `:sdmmmmmmmmmmmmmmmmd`     ",1,1);
		stringDelayer("`````      `/ommmmmmmmmmmmmy/`                                            .+hmmmmmmmmmmmmh/.       ",1,1);
		stringDelayer("``````        ymmmmmmmmmms-`                                                `/hmmmmmmmmmm-       ",1,1);
		stringDelayer("````````      /mmmmmmmmh-`                                                    `+mmmmmmmmy`      ",1,1);
		stringDelayer("`````````     `:osyyys/`                                                        -shhdhy+`       ",1,1);
		stringDelayer("```````````                                                                                     ",1,1);
		stringDelayer("````````````                                                                                   ",1,1);
		stringDelayer("``````````````                                                                                     ",1,1);
		stringDelayer("```````````````                                                                                    ",1,1);
		stringDelayer("`````````````````                                                                                     ",1,1);



        stringDelayer("Shutdown Initialized.", 5, 1);
        loadBar();
        stringDelayer("O-: BYE BYE :-O", 5,1);		
        osAndShutdown();         

}
}
