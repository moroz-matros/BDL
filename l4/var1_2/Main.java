package l4.var1_2;

/* 4. Создать класс Художественная Выставка с внутренним классом,
* помощью объектов которого можно хранить информацию о картинах,
* авторах и времени проведения выставок.
*/

public class Main {
    public static void main(String[] args) {
        Exhibition exhibition = new Exhibition("The Great Masters", 2000);

        String[] artists = { "Vincent van Gogh", "Pablo Picasso" };
        String[] paintings = { "The Starry Night", "The Old Guitarist" };
        String date = "2023-03-29";
        Exhibition.ExhibitionEvent event = exhibition.new ExhibitionEvent(artists, paintings, date);

        System.out.println("Event from the exhibition " + exhibition.getTitle());
        System.out.println("Featuring the works of: ");
        for (String artist : event.getArtists()) {
            System.out.println(artist);
        }

        System.out.println("Including Paintings: ");
        for (String painting : event.getPaintings()) {
            System.out.println(painting);
        }

        System.out.println("Taking place on: " + event.getDate());
    }
}
