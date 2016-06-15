package executor; /**
 * Created by pavan.r on 04/04/16.
 */

import java.io.*;
import java.util.Properties;

/**
 * Created by pavan.r on 15/03/16.
 */

public class SparkExecutor implements Serializable{
    private Properties properties;
    private String configFile;

    public SparkExecutor(String configFile){
        this.configFile = configFile;
    }

    public Properties getProperties() { return properties; }

    public void initialize(){
        try {
            InputStream file = SparkExecutor.class.getClassLoader().getResourceAsStream(configFile);
            properties = new Properties();
            properties.loadFromXML(file);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

