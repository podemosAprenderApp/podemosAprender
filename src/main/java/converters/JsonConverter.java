package converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

import java.time.LocalDateTime;

public class JsonConverter {
    private final static Gson gson =  new GsonBuilder()
                                .excludeFieldsWithoutExposeAnnotation()
                                .setPrettyPrinting()
                                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeConverter())
                                .create();

    public static ResponseTransformer toJson() {
        return gson::toJson;
    }

    public static <T> T fromJson(String json, Class<T> classOfObject){
        return gson.fromJson(json, classOfObject);
    }

    public static Gson gson(){
        return gson;
    }
}
