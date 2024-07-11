import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import models.Manga;

public class Filesystem {

    public Filesystem(){
        try{
            file = new File("manga.data");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(Exception e){}
    }

    public ArrayList<Manga> readFile(){
        ArrayList<Manga> array = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String raw = sc.nextLine();
                String[] substrings = raw.trim().split("/");
                Manga m = new Manga(substrings[0], substrings[1], Integer.parseInt(substrings[2]));
                array.add(m);
            }  
            sc.close();
        }catch(Exception e){}
        return array;
    }

    public void updateFile(ArrayList<Manga> manga){
        try{
            FileWriter writer = new FileWriter(file);
            for (Manga m : manga) {
                writer.write(m.serialized());
            }
            writer.close();
        }catch(Exception e){}
    }

    File file;
}

