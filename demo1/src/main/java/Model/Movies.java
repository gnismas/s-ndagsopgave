package Model;

public class Movies {
    private int ID;
    private String title;
    private int year;
    private int length;
    private String subject;
    private int popularity;
    private boolean awards;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    public void setAwards(boolean awards) {
        this.awards = awards;
    }

    public Movies(int id, String title, int year, int length, String subject, int popularity, String awards) {
        this.ID = id;
        this.title = title;
        this.year = year;
        this.length = length;
        this.subject = subject;
        this.popularity = popularity;
        if (awards.equals("Yes")) {
            this.awards = true;
        }
        else this.awards = false;
    }


    @Override
    public String toString() {
        return "title='" + title +
                "; year=" + year +
                "; length=" + length +
                "; subject='" + subject +
                "; popularity=" + popularity +
                "; awards=" + awards + "<br>";
    }
}
