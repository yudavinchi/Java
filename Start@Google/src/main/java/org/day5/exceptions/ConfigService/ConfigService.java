package org.day5.exceptions.ConfigService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class ConfigService {

    Map<String, String> config;

    public void readFile(String path) {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();

            config = gson.fromJson(new FileReader(path), type);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ", a default config file was initialized");

            try (FileWriter defaultFile = new FileWriter("defaultConfig.txt")) {
                writeDefaultConfig(defaultFile);
                readFile("defaultConfig.txt");
            } catch (IOException ioException) {
                System.out.println(ioException);
            }
        }
    }

    public Map<String, String> getConfigData() {
        if (config != null) {
            return config;
        }
        throw new NullPointerException("config has not been initialized");
    }

    public String getConfigKey(String key) {
        String value = config.get(key);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException("key doesn't exist");
    }

    private void writeDefaultConfig(FileWriter defaultFile) throws IOException {
        defaultFile.write("{ \n" +
                "   \"field1\" : \"value1\",\n" +
                "   \"field2\" : \"value2\",\n" +
                "   \"field3\" : \"value3\"\n" +
                "}");
    }
}
