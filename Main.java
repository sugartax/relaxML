//==--==--==--==--==--==--==--==--==--==--==--==--==--==\\
//  ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄  \\
//  █  BUILD JAR FILE  █                       █  X  █  \\
//  █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀                       ▀▀▀▀▀▀█  \\
//  █ $ javac Main.java                              █  \\
//  █ $ jar cfm relaxML.jar MANIFEST.MF Main.class   █  \\
//  █ $ java -jar relaxML.jar                        █  \\
//  █                                                █  \\
//  █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█  \\
//  █  VIEW JAR CONTENTS  █                    █  X  █  \\
//  █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀                    ▀▀▀▀▀▀█  \\ 
//  █ $ jar tf relaxML.jar                           █  \\
//  █                                                █  \\
//  █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█  \\
//  █  CLEANUP  █                              █  X  █  \\
//  █▀▀▀▀▀▀▀▀▀▀▀▀                              ▀▀▀▀▀▀█  \\
//  █ $ rm *.class                                   █  \\  
//  █                                                █  \\
//  █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█  \\
//                                                      \\
//==--==--==--==--==--==--==--==--==--==--==--==--==--==\\ 

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String command = isWindows() ? "cmd.exe /c echo Hello, World!" : "echo Hello, World!";
        
        ProcessBuilder builder = new ProcessBuilder(command.split(" "));
        String filePath = System.getProperty("user.dir");
        builder.directory(new File(filePath));
        builder.redirectErrorStream(true);
        
        try {
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Program returned " + exitCode);
            process.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}

