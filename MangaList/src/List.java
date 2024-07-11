import java.util.ArrayList;
import java.util.Scanner;
import models.Manga;

public class List {
    
    Filesystem fs;
    List(){
        fs = new Filesystem();
        mangaStorage = fs.readFile();
    }

    public void run(){
        while(true){
            switch(menu()){
                case ADD:
                    add();
                break;
                case DISPLAY:
                    display();
                break;
                case UPDATE:
                    update();
                break;
                case DROP:
                    drop();
                break;
                case EXIT:
                System.out.println(" Bye.( ' -' )/ ");
                    System.exit(0);
                break;
                default:
                System.out.println("<<< Invalid Input >>>");
            }
            fs.updateFile(mangaStorage);
        }
    }

    private int menu(){
       
        System.out.println("=====( MyMangaList )=====");
        System.out.println("║   1. Add Manga.       ║");
        System.out.println("║   2. Display Manga.   ║");
        System.out.println("║   3. Update Manga.    ║");
        System.out.println("║   4. Drop Manga.      ║");
        System.out.println("║   5. Exit.            ║");
        System.out.println("=========================");
        System.out.print("=> ");
        return Integer.parseInt(sc.nextLine());
        
    }

    private void add(){
        System.out.print("Enter the title of Manga: ");
        String m = sc.nextLine();
        System.out.print("What is the Genre?: ");
        String g = sc.nextLine();
        System.out.print("Latest chapter you've read: ");
        int c = Integer.parseInt(sc.nextLine());

        Manga manga = new Manga(m, g, c);
        mangaStorage.add(manga);

        System.out.println("<<< " + m + " has been added. >>>\n");
    }

    private void display(){
        int index = 0;
        for(Manga manga : mangaStorage){
            System.out.print("[" + index ++ +  "]: "); 
            manga.info();
        }
    }

    private void update(){
        display();
        System.out.print("Choose index of Manga to update: ");
        int index = Integer.parseInt(sc.nextLine());
        Manga mangas = mangaStorage.get(index);
        System.out.print("Enter the latest chapter you've read: ");
        int c = Integer.parseInt(sc.nextLine());
        
        mangas.setChapter(c);
        mangaStorage.set(index, mangas);
        System.out.println("<<< The manga has been updated. >>>");
        display();
    }

    private void drop(){
        display();
        System.out.print("Enter index of Manga to drop: ");
        int index = Integer.parseInt(sc.nextLine());
        mangaStorage.remove(index);
        System.out.println("<<< The manga has been dropped >>>");
       
    }

    Scanner sc = new Scanner(System.in);
    ArrayList<Manga> mangaStorage = new ArrayList<>(); 
    
    private static final int ADD = 1;
    private static final int DISPLAY = 2;
    private static final int UPDATE = 3;
    private static final int DROP = 4;
    private static final int EXIT = 5;
}

    

