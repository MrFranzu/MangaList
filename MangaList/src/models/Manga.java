package models;

public class Manga {
    public Manga(String m, String g, int c){
        manga = m;
        genre = g;
        chapter = c;
    }

    public void info(){
        System.out.println("║ Manga: " + "[" + manga + "]\n" + 
                           "     ║ Genre: " + "[" + genre + "]\n" + 
                           "     ║ Chapter: " + "[" + chapter + "]\n");
    }
    public void setManga(String m){
         manga = m;
    }

    public void setAuthor(String g){
        genre = g;
    }

    public void setChapter(int c){
        chapter = c;
    }
    
    public String serialized(){
        return "║ Manga: " + "[" + manga + "]\n" + 
               "║ Genre: " + "[" + genre + "]\n" + 
               "║ Chapter: " + "[" + chapter + "]" + "\n"
             + "===============================" +  "\n";
    }

    private String manga;
    private String genre;
    private int chapter;
}
    





