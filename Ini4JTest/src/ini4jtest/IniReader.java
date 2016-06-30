package ini4jtest;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.ini4j.Config;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;

public class IniReader {

	public static void main(final String args[]) throws InvalidFileFormatException, IOException {
		final File input = new File("D:\\Servers\\Protheus\\P12\\binNov5\\appserver_x32\\AppServer.ini");
		final Wini ini = new Wini(input);

		Config.getGlobal().setLowerCaseSection(true);
		Config.getGlobal().setLowerCaseOption(true);

		ini.getConfig().setLowerCaseOption(true);
		ini.getConfig().setLowerCaseSection(true);

		System.out.println("O ini:");
		System.out.println("");
		System.out.println(ini.toString());

		final Set<String> sectionNames = ini.keySet();
		System.out.println("Se�oes:");
		System.out.println("");
		for (final String string : sectionNames) {
			System.out.println("Section: " + string);
		}

		System.out.println("");
		System.out.println(">>>>>> Lendo a se��o General inteira: ");
		System.out.println("");
		final Section section = ini.get("General");
		final Set<String> keySet = section.keySet();
		for (final String string : keySet) {
			System.out.println(string);
		}

		System.out.println("");
		System.out.println(">>>>>> Lendo o SOURCEPATH do ambiente P12");
		// System.out.println("");
		final Section sectionP12 = ini.get("P12");
		final String string = sectionP12.get("SOURCEPATH");
		// sectionP12.put("TRACE", 1);
		// sectionP12.replace("TRACE", "0");
		// ini.put("P21", sectionP12);
		System.out.println("Value: " + string);
		System.out.println("");
		System.out.println("Lendo comentario: " + sectionP12.getComment("DBSERVER"));
		System.out.println("");
		System.out.println("LENDO A SE��O P12 INTEIRA:");
		Set<String> keySetP12 = sectionP12.keySet();
		for (String p12Section : keySetP12) {
			String value = sectionP12.get(p12Section);
			System.out.println(p12Section + " = " + value);
		}
		ini.putComment("P12", "Ambiente P12");

		ini.store();

	}

}
