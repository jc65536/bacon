import java.io.*;
import java.util.*;
import java.net.*;
import java.util.zip.*;
public class MovieDataRetriever extends DataRetriever {
    final static String MOVIE_DATA_URL = "https://datasets.imdbws.com/name.basics.tsv.gz";

    public MovieDataRetriever() throws Exception {
        super(MovieDataRetriever.MOVIE_DATA_URL);
    }

    public String getNConst() {
        return segments[0];
    }

    public String getName() {
        return segments[1];
    }

    public String getBirthYear() {
        return segments[2];
    }

    public String getDeathYear() {
        if (segments[3].equals("\\N")) {
            return null;
        } else {
            return segments[3];
        }
    }

    public String[] getKnownTitles() {
        return segments[5].split(",");
    }

    public static void main(String[] args) throws Exception {
        ActorDataRetriever dr = new ActorDataRetriever();
        for (int a = 0; a < 10; a++) {
            dr.nextLine();
            for (String s : dr.getKnownTitles()) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}