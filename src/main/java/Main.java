import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(coursesSW("&CourseTitle=software%20engineering"));
        System.out.println(coursesSW("&CourseTitle=software%20engineering&Term=Fall%202021"));
        System.out.println(coursesSW("&CourseTitle=software%20engineering&Term=Fall%202021&Credits=3.00"));
        System.out.println(coursesSW("&CourseTitle=software%20engineering&Term=Fall%202021&Credits=3.00&Status=Open"));
    }

    public static String coursesSW(String specific) throws IOException{
        String BASE_URL = "https://sis.jhu.edu/api/classes";
        String KEY = System.getenv("SIS_API_KEY");

        String endpoint = BASE_URL + "?Key=" + KEY + specific;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(endpoint)
                .build();
        Response response = client.newCall(request).execute();
        return (response.body().string());
    }
//    public static String coursesSWF21() throws IOException{
//        String BASE_URL = "https://sis.jhu.edu/api/classes";
//        String KEY = System.getenv("SIS_API_KEY");
//        String softwareSpecific = "&CourseTitle=software%20engineering&Term=Fall%202021";
//
//        String endpoint = BASE_URL + "?Key=" + KEY + softwareSpecific;
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(endpoint)
//                .build();
//        Response response = client.newCall(request).execute();
//        return (response.body().string());
//    }
//    public static String coursesSWF21_3() throws IOException{
//        String BASE_URL = "https://sis.jhu.edu/api/classes";
//        String KEY = System.getenv("SIS_API_KEY");
//        String softwareSpecific = "&CourseTitle=software%20engineering&Term=Fall%202021&Credits=3.00";
//
//        String endpoint = BASE_URL + "?Key=" + KEY + softwareSpecific;
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(endpoint)
//                .build();
//        Response response = client.newCall(request).execute();
//        return (response.body().string());
//    }
//    public static String coursesSWF21_3open() throws IOException{
//        String BASE_URL = "https://sis.jhu.edu/api/classes";
//        String KEY = System.getenv("SIS_API_KEY");
//        String softwareSpecific = "&CourseTitle=software%20engineering&Term=Fall%202021&Credits=3.00&Status=Open";
//
//        String endpoint = BASE_URL + "?Key=" + KEY + softwareSpecific;
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(endpoint)
//                .build();
//        Response response = client.newCall(request).execute();
//        return (response.body().string());
//    }
}
