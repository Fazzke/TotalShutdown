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
		
		System.out.println("\n");
		
		//__________________________________________________________________________


		stringDelayer("Initialized. Process is in progress. User input required", 10, 1);

		stringDelayer("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", 10, 1);
		stringDelayer("->->->->->->->->->", 30, 0);
		stringDelayer("->->->->->->->->->->->->->->->->->->->->->->->->->->->", 10, 1);

		stringDelayer("fazzke@Tuempel: Total Shutdown.", 10, 0);

		String placeholder = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("fazzke@Tuempel: Are you sure?", 10, 0);

		String placeholder2 = IO.readString(" (yes/no) ");

		System.out.println(" \n");

		stringDelayer("fazzke@Tuempel: Are you scared?", 10, 0);

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
