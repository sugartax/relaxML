public class Main {
    public static void main(String[] args) {
        Options options = new Options(args);
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("Debug: " + options.isDebug());
        System.out.println("Output Directory: " + options.getOutputDirectory());
        System.out.println("Help: " + options.isHelp());
        System.out.println("Input File: " + options.getInputFile());
        System.out.println("Output Html File: " + options.getOutputHtmlFile());
        System.out.println("Output Css File: " + options.getOutputCssFile());
        System.out.println("Output Js File: " + options.getOutputJsFile());
        System.out.println("Verbose: " + options.isVerbose());
        System.out.println("Version: " + options.isVersion());
        System.out.println("Wall: " + options.isWarningsAll());
        System.out.println("Werror: " + options.isWarningsError());
        System.out.println("Wnone: " + options.isWarningsNone());
    }
}




// import java.io.*;

// public class Main {
//     public static void main(String[] args) {
//         String command = isWindows() ? "cmd.exe /c echo Hello, World!" : "echo Hello, World!";
        
//         ProcessBuilder builder = new ProcessBuilder(command.split(" "));
//         String filePath = System.getProperty("user.dir");
//         builder.directory(new File(filePath));
//         builder.redirectErrorStream(true);
        
//         try {
//             Process process = builder.start();
//             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

//             String line;
//             while ((line = reader.readLine()) != null) {
//                 System.out.println(line);
//             }

//             int exitCode = process.waitFor();
//             System.out.println("Program returned " + exitCode);
//             process.destroy();
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
    
//     private static boolean isWindows() {
//         return System.getProperty("os.name").toLowerCase().contains("win");
//     }
// }

