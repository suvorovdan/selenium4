package Page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private static TestProperties ourInstance = null;
    private final Properties properties = new Properties();

    public static TestProperties getInstance() {
        if(ourInstance == null){
            ourInstance = new TestProperties();
        }
        return ourInstance;
    }

    private TestProperties() {
        try{
            properties.load(new FileInputStream(
                    new File("src/main/other/"+System
                            .getProperty("environment","application")+".properties")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Properties getProperties(){
        return properties;
    }
}
