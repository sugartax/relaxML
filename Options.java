import java.util.HashMap;
import java.util.Map;

public class Options {
    private String[] userOptions;
    private Map<String, Runnable> compilerOptions;

    private boolean parseOutputDirectoryParameters;
    private boolean parseInputFileParameters;
    private boolean parseOutputFileParameters;

    private boolean debug;
    private String outputDirectory;
    private boolean help;
    private String inputFile;
    private String outputHtmlFile;
    private String outputCssFile;
    private String outputJsFile;
    private boolean verbose;
    private boolean version;
    private boolean warningsAll;
    private boolean warningsError;
    private boolean warningsNone;

    public Options(String[] options) {
        userOptions = options;
        compilerOptions = new HashMap<>(Map.ofEntries(
            Map.entry("-d", () -> debugOption()),
            Map.entry("--debug", () -> debugOption()),
            Map.entry("-dir", () -> outputDirectoryOption()),
            Map.entry("-h", () -> helpOption()),
            Map.entry("--help", () -> helpOption()),
            Map.entry("-i", () -> inputFileOption()),
            Map.entry("-o", () -> outputFileOption()),
            Map.entry("--verbose", () -> verboseOption()),
            Map.entry("-v", () -> versionOption()),
            Map.entry("--version", () -> versionOption()),
            Map.entry("-Wall", () -> warningsAllOption()),
            Map.entry("-Werror", () -> warningsErrorOption()),
            Map.entry("-Wnone", () -> warningsNoneOption())));
        loadDefault();
        compareOptions();
        fullPath();
    }

    public void compareOptions() {
        for (int i = 0; i < userOptions.length; i++) {
            String option = userOptions[i];
            if (compilerOptions.containsKey(option)) {
                parseOutputDirectoryParameters = false;
                parseInputFileParameters = false;
                parseOutputFileParameters = false;
                compilerOptions.get(option).run();
            } else if (parseOutputDirectoryParameters) {
                outputDirectoryParameters(option);
            } else if (parseInputFileParameters) {
                inputFileParameters(option);
            } else if (parseOutputFileParameters) {
                outputFileParameters(option);
            }
        }
    }

    public boolean isDebug() {
        return debug;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public boolean isHelp() {
        return help;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputHtmlFile() {
        return outputHtmlFile;
    }

    public String getOutputCssFile() {
        return outputCssFile;
    }

    public String getOutputJsFile() {
        return outputJsFile;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public boolean isVersion() {
        return version;
    }

    public boolean isWarningsAll() {
        return warningsAll;
    }
    
    public boolean isWarningsError() {
        return warningsError;
    }

    public boolean isWarningsNone() {
        return warningsNone;
    }

    private void debugOption() {
        debug = true;
    }

    private void outputDirectoryOption() {
        parseOutputDirectoryParameters = true;
    }

    private void helpOption() {
        help = true;
    }

    private void inputFileOption() {
        parseInputFileParameters = true;
    }

    private void outputFileOption() {
        parseOutputFileParameters = true;
    }

    private void verboseOption() {
        verbose = true;
    }

    private void versionOption() {
        version = true;
    }

    private void warningsAllOption() {
        warningsAll = true;
    }

    private void warningsErrorOption() {
        warningsError = true;
    }

    private void warningsNoneOption() {
        warningsNone = true;
    }

    private void outputDirectoryParameters(String option) {
        outputDirectory = option;
        if (outputDirectory.endsWith("\\") || outputDirectory.endsWith("/")) {
            outputDirectory = outputDirectory.substring(0, outputDirectory.length() - 1);
        }
    }

    private void inputFileParameters(String option) {
        inputFile = option;
    }

    private void outputFileParameters(String option) {
        if (option.endsWith(".html")) {
            outputHtmlFile = option;
        } else if (option.endsWith(".css")) {
            outputCssFile = option;
        } else if (option.endsWith(".js")) {
            outputJsFile = option;
        }
    }

    private void fullPath() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            outputHtmlFile = outputDirectory + "\\" + outputHtmlFile;
            outputCssFile = outputDirectory + "\\" + outputCssFile;
            outputJsFile = outputDirectory + "\\" + outputJsFile;
        } else {
            outputHtmlFile = outputDirectory + "/" + outputHtmlFile;
            outputCssFile = outputDirectory + "/" + outputCssFile;
            outputJsFile = outputDirectory + "/" + outputJsFile;
        }
    }

    private void loadDefault() {
        debug = false;
        outputDirectory = System.getProperty("user.dir");
        help = false;        
        outputHtmlFile = "index.html";
        outputCssFile = "style.css";
        outputJsFile = "index.js";
        verbose = false;
        version = false;
        warningsError = false;
        warningsAll = false;
        warningsNone = false;
    }
}
