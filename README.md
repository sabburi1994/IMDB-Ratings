# IMDB-Ratings
get story, language and imdb review of your specified movie

This is a simple java program to fetch the data from omdbapi website and perform string handling on the data received during the request. 
This provides the story line, languages available in and the imdb rating.


Initially you need to get an api key from the below mentioned website by providing few details such as email address. After the api key is received replace the string given in the script with your apikey. 

 public static String[] return_data() throws IOException {
        String apikey;//enter your apikey obtained from omdbapi
        apikey = "xxxxxxx"; # place your api key
        String api_title, title,data, story, languages, rating;
        String[] array_values = new String[4];
