package NetWork.GUI.View;

import NetWork.Data.Database.Service.ConfigurationFile;
import NetWork.Data.Database.Service.DatabaseService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author Crunchify.com
 *
 */

public class CrunchifyGetPropertyValues {
    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "Recources.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String Server = prop.getProperty("Server");
            String Database = prop.getProperty("Database");
            String User = prop.getProperty("User");
            String Password = prop.getProperty("Password");

            ConfigurationFile.Servername=Server;
            ConfigurationFile.Database=Database;
            ConfigurationFile.User =User;
            ConfigurationFile.Password=Password;

            result = "Company List = " + Server + ", " + Database + ", " + User+", "+Password;
            System.out.println(result + "\nProgram Ran on " + time + " by user=" + User);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}