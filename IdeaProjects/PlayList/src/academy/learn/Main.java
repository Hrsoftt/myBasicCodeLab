package academy.learn;

import java.util.*;

public class Main {

    private static List<Album>albums=new ArrayList<>();

    public static void main(String[] args) {
	    Album album =new Album("Made in Lagos", "WizKid");
        album.addSong("Mood",3.21);
        album.addSong("Blessed",2.46);
        album.addSong("Anoti", 2.50);
        album.addSong("Gyrate", 3.00);
        album.addSong("Mighty wine",3.21);
        album.addSong("She tell me say", 45.6);
        albums.add(album);

        album = new Album("V","Asa");
        album.addSong("Mayana",2.34);
        album.addSong("Ocean",2.23);
        album.addSong("IDG",2.31);
        album.addSong("Show me off", 2.41);
        album.addSong("Morning man",2.11);
        album.addSong("Idan gan gan", 2.13);
        albums.add(album);

        List<Song> playList = new ArrayList<>();
        albums.get(1).addToPlayList("Ocean",playList);
        albums.get(0).addToPlayList("Loud",playList);
        albums.get(0).addToPlayList("She tell me say",playList);
        albums.get(1).addToPlaylist(3,playList);
        albums.get(1).addToPlaylist(5,playList);
        albums.get(1).addToPlaylist(6,playList);
        albums.get(1).addToPlaylist(7,playList);

        play(playList);
    }
    private static void play(List<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit= false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size()==0){
            System.out.println("No song in playlist");
            return;
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist Complete");
                    quit=true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }forward=true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing "+ listIterator.next().toString());
                    }else {
                        System.out.println("We have reached the end of the playlist");
                        forward =false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }forward =false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());

                    }else {
                        System.out.println("We are at the start of the playlist");
                        forward=true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying "+ listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying "+ listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next());
                        }else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - to list songs available\n" +
                "5 - print available actions.\n" +
                "6 -  delete current song from playlist");
    }

    private static void printList(List<Song> playList){
        Iterator<Song>iterator = playList.iterator();
        System.out.println("===============================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============================");
    }

}
