
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


/**
 * Created by Ben Maxwell on 2/8/17.
 */

public class Survey {

    static Scanner input = new Scanner(System.in);
    static FavoriteArtist artist = new FavoriteArtist();
    File f = new File("artist.json");
    String contents;

    public FavoriteArtist loadResponse() throws Exception {
        Scanner scanner = new Scanner(f);

        scanner.useDelimiter("\\Z");
        contents = scanner.next();
        scanner.close();
        JsonParser parser = new JsonParser();

        return parser.parse(contents, FavoriteArtist.class);
    }

    public boolean checkFileExistence() {
        return (f.exists());
    }

    public void displayResponse() throws Exception {
        if (f.exists()) {
            //Display contents of existing file
            JsonParser parser = new JsonParser();

            FavoriteArtist fav = parser.parse(contents, FavoriteArtist.class);
            System.out.println("Favorite Artist Survey Info:" +
                    "\n---------------------------" +
                    "\nFavorite Artist Name: " + fav.getName() +
                    "\nFavorite Album: " + fav.getAlbum() +
                    "\nFavorite Song: " + fav.getSong() +
                    "\nFavorite Artist Genre: " + fav.getGenre() +
                    "\nFavorite Artist On Tour? " + fav.isOnTour());


        } else {
            //Display welcome message
            System.out.println("We could not find a pre-existing survey responses.\nThis may be your first time taking this survey.\n");
        }

    }

    public void createFile() throws Exception {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(startSurvey());
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public FavoriteArtist startSurvey() {

        System.out.println("\nPlease answer the following questions regarding your favorite musical artist.");
        System.out.println("What is the name of your favorite artist?");
        artist.name = input.nextLine();
        System.out.println("What is your favorite album by this artist?");
        artist.album = input.nextLine();
        System.out.println("What is your favorite song by this artist?");
        artist.song = input.nextLine();
        System.out.println("What is this artist's genre?");
        artist.genre = input.nextLine();
        System.out.println("Is this artist currently on tour? [true/false]");
        artist.onTour = input.nextBoolean();

        System.out.println("\nThank you for your responses!");
        return artist;

    }

    public void updateSurvey() throws Exception {
        System.out.println("\nWelcome back to the musical artist survey! Your previous answers are listed above.\nWould you like to update your survey responses? (Please select a number below)\n\n1. Yes\n2. No");
        int choice = input.nextInt();
        input.nextLine();//consumes next line left over by nextInt

        switch (choice) {
            case 1:
                createFile();
                break;
            case 2:
                System.out.println("\nThank you! Please come back and update your responses if you have any changes.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid entry.");
                break;
        }
    }

}


