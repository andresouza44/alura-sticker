package metodos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiKey {
    public static String getApiKey(String apiName){
        try {
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream("./properties/config.properties");
            prop.load(file);
          return   prop.getProperty(apiName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
