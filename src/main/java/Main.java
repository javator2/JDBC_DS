import model.Student;
import resolver.StudentResolver;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu: \n" +
                "1.Pokaż rekordy\n" +
                "2.Dodaj rekord\n" +
                "3.Usuń rekord [id=]\n" +
                "4.Nadpisz rekord [id=]\n" +
                "5.Koniec");
        int choose = scanner.nextInt();

        StudentResolver studentResolver = new StudentResolver();

        switch (choose) {
            case 1:
                List<Student> studentList = studentResolver.get();
                for(Student s: studentList){
                    System.out.println(s.getId()+ ". " + s.getName() + " " + s.getLastname());
                }
                break;
            case 2:
                Map<String, String> params = new HashMap<>();
                System.out.println("podaj imię: ");
                String name = scanner.next();
                params.put("name", name);
                System.out.println("podaj nazwisko: ");
                String lastname = scanner.next();
                params.put("lastname", lastname);
                studentResolver.insert(params);
                break;
            case 3:
                System.out.println("podaj id do usunięcia: ");
                int id = scanner.nextInt();
                studentResolver.delete(id);
                break;
            case 4:
                System.out.println("podaj id: ");
                int updateId = scanner.nextInt();
                Map<String, String> updateParams = new HashMap<>();
                System.out.println("podaj nowe imię: ");
                String updateName = scanner.next();
                updateParams.put("name", updateName);
                System.out.println("podaj nowe nazwisko: ");
                String updateLastname = scanner.next();
                updateParams.put("lastname", updateLastname);
                studentResolver.update(updateId, updateParams);
                break;
            case 5:
                System.out.println("Do zobaczenia");
                break;
            default:
                System.out.println("ERROR!");
        }
    }
}

/*1.Pokaż rekordy
2.Dodaj rekord
3.Usuń rekord [id=]
4.Nadpisz rekord [id=]
5.Koniec*/
