
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File diplomaset = new File("diploma.csv");

        int index = 0;

        ArrayList<DiplomaData> diplomaData = new ArrayList<>();

        ArrayList<String> programs = new ArrayList<>();
        ArrayList<String> course = new ArrayList<>();

        ArrayList<String> DiplomaLanjutan= new ArrayList<>();
        ArrayList<String> KursusPengkhususan= new ArrayList<>();


        if(diplomaset.exists()) {
            System.out.println("File exists");

            if (diplomaset.canRead()) {
                System.out.println("File is readable.");
                System.out.println();
            } else {
                System.out.println("File is unreadable.");
                System.out.println();
            }
            try(Scanner reader = new Scanner(diplomaset)) {
                while (reader.hasNext()) {
                    String line = reader.nextLine();
                    if(index > 0) {
                        String[] items = line.split(",");

                        DiplomaData data = new DiplomaData(items[0], items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]),
                                Integer.parseInt(items[5]), Integer.parseInt(items[6]), Integer.parseInt(items[7]), Integer.parseInt(items[8]));

                        diplomaData.add(data);

                        System.out.print(index + " ");
                        System.out.println(data);
                        System.out.println();
                    }
                    index++;
                }

                for(int i=0; i<diplomaData.size();i++){
                    System.out.println("Total student in "+diplomaData.get(i).name+ " is " + diplomaData.get(i).total());
                    System.out.println("Maximum number of intakes between the year 2014 to 2019 for "+diplomaData.get(i).name+ " is " + diplomaData.get(i).max());
                    System.out.println("Minimum number of intakes between the year 2014 to 2019 for "+diplomaData.get(i).name+ " is " + diplomaData.get(i).min());
                }

                System.out.println();
                System.out.println("-------------------------------------------------------------------------");
                System.out.println();
                //List program & course + seperate
                for(DiplomaData row: diplomaData) {
                    if(!(programs.contains(row.category))) {
                        programs.add(row.category);
                    }
                    if(!(course.contains(row.name))) {
                        course.add(row.name);
                    }
                }
                System.out.println(programs);
                System.out.println(course);
                for(DiplomaData row: diplomaData){
                    if(row.category.equals(programs.get(0)))
                        DiplomaLanjutan.add(row.name);
                    if(row.category.equals(programs.get(1)))
                        KursusPengkhususan.add(row.name);
                }

                System.out.println();
                System.out.println("-------------------------------------------------------------------------");
                System.out.println();
                //Print Diploma Lanjutan
                for(String row:DiplomaLanjutan){
                    System.out.println(row);
                }
                System.out.println();
                System.out.println("-------------------------------------------------------------------------");
                System.out.println();
                //Print Kursus Pengkhususan
                for(String row:KursusPengkhususan){
                    System.out.println(row);
                }


                for(String state: programs) {
                    try(PrintWriter writer = new PrintWriter(new File(state+".txt"))){
                        for(DiplomaData row: diplomaData) {
                            if(state.equals(row.category)) {
                                writer.println(row);
                            }
                        }
                    } catch (FileNotFoundException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            } catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }

    }
}