package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();
    static  {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}
