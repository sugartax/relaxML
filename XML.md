# Creating a `relaxML-build.xml` file

A `relaxML-build.xml` file is required to create an executable for ReLaX ML.

1. Copy the XML below into a new file called `relaxML-build.xml`:

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <launch4jConfig>
        <dontWrapJar>false</dontWrapJar>
        <headerType>console</headerType>
        <jar></jar>
        <outfile></outfile>
        <errTitle></errTitle>
        <cmdLine></cmdLine>
        <chdir></chdir>
        <priority>normal</priority>
        <downloadUrl></downloadUrl>
        <supportUrl></supportUrl>
        <stayAlive>false</stayAlive>
        <restartOnCrash>false</restartOnCrash>
        <manifest></manifest>
        <icon></icon>
        <jre>
            <path></path>
            <requiresJdk>false</requiresJdk>
            <requires64Bit>false</requires64Bit>
            <minVersion></minVersion>
            <maxVersion></maxVersion>
        </jre>
    </launch4jConfig>
    ```

2. Fill out the following based on your device:

    1. `<jar>` -> The path to the jar file. (Ex. `C:\Users\john\relaxML\relaxML.jar`)
    2. `<outfile>` -> The path to where the final executable will be located. (Ex. `C:\Users\john\relaxML\relaxML.exe`)
    3. `<path>` -> The path to your JDK. (Ex. `C:\Program Files\Java\jdk-17`)
