package homework.homework_8_IDI.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import homework.homework_7_JDI.entities.MetalsColorsFormData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class ResourceLoader {
    private static ResourceLoader instance = null;

    private ResourceLoader() {
    }

    public static synchronized ResourceLoader getInstance() {
        if (instance == null)
            instance = new ResourceLoader();
        return instance;
    }

    public static Map<String,MetalsColorsFormData> loadResource() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(ResourceLoader.class.getClassLoader()
                .getResource("ex8_jdi_metalsColorsDataSet.json").getFile()));

        Type token = new TypeToken<Map<String, MetalsColorsFormData>>() {{
        }}.getType();

        return new Gson().fromJson(jsonReader, token);
    }
}
