public class DiplomaData {
    public String number;
    public String category;
    public String name;
    public int year14;
    public int year15;
    public int year16;
    public int year17;
    public int year18;
    public int year19;


    // Parameterized Constructor
    public DiplomaData(String number, String category, String name, int year14, int year15,
                       int year16, int year17, int year18, int year19) {
        this.number = number;
        this.category = category;
        this.name = name;
        this.year14 = year14;
        this.year15 = year15;
        this.year16 = year16;
        this.year17 = year17;
        this.year18 = year18;
        this.year19 = year19;
    }

    @Override
    public String toString() {
        return "Category = "+category+", Name = "+name+", " +
                "Year 2014 = "+year14+", Year 2015 = "+year15+", Year 2016 = "+year16+", " +
                "Year 2017 = "+year17+", Year 2018 = "+year18+", Year 2019 = "+year19;
    }

    public int total(){
        return year14 + year15 + year16 + year17 + year18 + year19;
    }

    public int  max(){
        return Math.max(year19, Math.max(year18, Math.max(year17, Math.max(year16,Math.max(year15,year14)))));
    }
    public int  min(){
        return Math.min(year19, Math.min(year18, Math.min(year17, Math.min(year16,Math.min(year15,year14)))));
    }

}