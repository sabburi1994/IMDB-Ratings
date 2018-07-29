import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class DownloadData{

    public static String get_user_input(){
        System.out.println("Enter the title");
        Scanner s = new Scanner(System.in);
        String title;
        title = s.nextLine().replace(" ","+");
        return title;
    }

    public static String get_data(String apikey, String title) throws IOException {
        String line;
        String url_string = "http://www.omdbapi.com/?t=" + title+"&plot=full&r=xml&apikey=" + apikey;
        URL url = new URL(url_string);
        URLConnection connection = url.openConnection();
        try (InputStream inputstream = connection.getInputStream()) {
            BufferedReader data = new BufferedReader(new InputStreamReader(inputstream));
            while((line = data.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return line;
    }

    public static String get_story(String data){
        String story;
        story = data.substring(data.indexOf("plot")+6,data.indexOf("language")-2);
        return story;
    }

    public static String get_languages(String data){
        String languages;
        languages = data.substring(data.indexOf("language")+10,data.indexOf("country")-2);
        return languages;
    }

    public static String get_rating(String data){
        String rating;
        rating = data.substring(data.indexOf("imdbRating")+12,data.indexOf("imdbVotes")-2);
        return rating;
    }

    public static String[] return_data() throws IOException {
        String apikey;//enter your apikey obtained from omdbapi
        apikey = "464d4d63";
        String api_title, title,data, story, languages, rating;
        String[] array_values = new String[4];
        api_title = get_user_input();
        title = api_title.replace("+"," ");
        data = get_data(apikey, api_title);
        story = get_story(data);
        languages = get_languages(data);
        rating = get_rating(data);
        array_values[0] = title;
        array_values[1] = story;
        array_values[2] = languages;
        array_values[3] = rating;
        return array_values;
    }

    public static void main(String[] args) throws IOException {
        String feedback_value;
        loop:
        while (true) {
            String[] array_values, fee;
            array_values = return_data();
            System.out.println("Details taken from IMDB:\n");
            int i;
            for (i = 0; i < array_values.length; i++) {
                System.out.println(array_values[i]);
            }
        System.out.println("Not what you are looking for? ");
        Scanner s = new Scanner(System.in);
        feedback_value = s.nextLine().toLowerCase();
        if (feedback_value.contentEquals("yes")) {
            System.out.println("Retry again!!");
            continue loop;
        }
        else {
            break loop;
        }
        }
        }
    }
