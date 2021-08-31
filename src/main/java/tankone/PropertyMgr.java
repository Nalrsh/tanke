package tankone;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }

    public static void main(String[] args) throws IOException {
//        InputStream in = PropertyMgr.class.getClassLoader().getResourceAsStream("config");
//        props.load(in);
//                     String value = props.getProperty("initTankCount");
//                     System.out.println("initTankCount" + " = " + value);



        System.out.println( props.get("goodFS"));

//        System.out.println(PropertyMgr.get("initTankCount"));
//        System.out.println("asafafasf");
//        GetValueByKey("C:\\rua\\xxxx\\src\\config","initTankCount");
    }


}
