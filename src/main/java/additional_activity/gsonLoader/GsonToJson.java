package additional_activity.gsonLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonToJson {


    //    public static void main(String args[]) {
    public static String convertToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        UserCreds creds = new UserCreds();
        creds.setName("dima");
        creds.setPassword("1234");
        String jsonString = gson.toJson(creds);
        System.out.println(jsonString);

        return jsonString;
    }

    //    public static void main(String args[]) {
    public static Object convertToObject() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = "[\n" +
                "  {\n" +
                "    \"name\":\"dima\",\n" +
                "    \"password\": \"1234\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\":\"vova\",\n" +
                "    \"password\": \"1234\"\n" +
                "  }\n" +
                "]";
        return gson.fromJson(jsonString, UserCreds.class);
    }
}
