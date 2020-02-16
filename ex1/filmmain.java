import java.util.*;

class Film {
    String name, language, lead_actor, category;
    int duration;

    // parametrized constructor
    public Film(String name, String language, String lead_actor, String category, int duration) {
        this.name = name;
        this.language = language;
        this.lead_actor = lead_actor;
        this.category = category;
        this.duration = duration;
    }

    // accessor functions
    public String getName() {
        return name;
    }

    public String getLang() {
        return language;
    }

    public String getLead() {
        return lead_actor;
    }

    public String getCategory() {
        return category;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLang(String lang) {
        this.language = lang;
    }

    public void setLead(String lead_actor) {
        this.lead_actor = lead_actor;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name + " " + language + " " + lead_actor + " " + category + " " + duration;
    }

}

class filmmain {
    public static void main(String args[]) {
        Vector<Film> x = new Vector<Film>(5);
        Film f1 = new Film("Terminator", "English", "Arnold", "Action", 150);
        Film f2 = new Film("Sivaji", "Tamil", "Rajini", "Action", 150);
        Film f3 = new Film("Hera Pheri", "Hindi", "Akshay", "Comedy", 170);
        x.add(f1);
        x.add(f2);
        x.add(f3);

        for (Film film : x) {
            if (film.language == "English" && film.lead_actor == "Arnold")
                System.out.println("English film with Arnold is: " + film.toString());
            else if (film.language == "Tamil" && film.lead_actor == "Rajini")
                System.out.println("Tamil film with Rajini is: " + film.toString());
            else if (film.category == "Comedy")
                System.out.println("Comedy film are: " + film.toString());
        }
    }
}