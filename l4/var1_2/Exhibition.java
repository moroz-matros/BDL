package l4.var1_2;

public class Exhibition {
    private String title;

    public Exhibition(String title, int year) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public class ExhibitionEvent {
        private String[] artists;
        private String[] paintings;
        private String date;

        public ExhibitionEvent(String[] artists, String[] paintings, String date) {
            this.artists = artists;
            this.paintings = paintings;
            this.date = date;
        }

        public String[] getArtists() {
            return artists;
        }

        public String[] getPaintings() {
            return paintings;
        }

        public String getDate() {
            return date;
        }
    }
}
