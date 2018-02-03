package homework.homework_8_JDI.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import homework.homework_7_JDI.entities.MetalsColorsFormData;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;


public class ResourceLoader {
    private static Map<String, MetalsColorsFormData> mcData = null;

    @SneakyThrows
    private static void loadResource() {
        JsonReader jsonReader = new JsonReader(new FileReader(ResourceLoader.class.getClassLoader()
                .getResource("ex8_jdi_metalsColorsDataSet.json").getFile()));

        Type token = new TypeToken<Map<String, MetalsColorsFormData>>() {{
        }}.getType();

        mcData = new Gson().fromJson(jsonReader, token);
    }

    @SneakyThrows
    public static Map<String, MetalsColorsFormData> getData() {
        if (Objects.isNull(mcData)) {
            loadResource();
        }
        return mcData;
    }

    public static MetalsColorsFormData getDataByID(String dataID) {
        return getData().get(dataID);
    }
}
