import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("----------Welcome to Student Management App----------");
            System.out.println("*****************************************************");
            System.out.println("*\tPress 1 to add student                          *");
            System.out.println("*\tPress 2 to delete student                       *");
            System.out.println("*\tPress 3 to display student                      *");
            System.out.println("*\tPress 4 to update student                       *");
            System.out.println("*\tPress 5 to exit app                             *");
            System.out.println("*****************************************************");
            int n = Integer.parseInt(br.readLine());
            if(n==1)
            {
                System.out.println("Enter Student id");
                int sid= Integer.parseInt(br.readLine());
                System.out.println("Enter Student name ");
                String sname= br.readLine();
                System.out.println("Enter Phone number");
                int sphone= Integer.parseInt(br.readLine());
                System.out.println("Enter area name");
                String area = br.readLine();
                Student student1 = new Student(sid,sname,sphone,area);
                boolean answer = StudentDao.insertStudentToDb(student1);
                if(answer)
                {
                    System.out.println("Student successfully added");
                }
                else
                {
                    System.out.println("Student is not added");
                }
            }
            else if(n==2)
            {
                System.out.println("Enter Student id to delete");
                int sid1= Integer.parseInt(br.readLine());
                boolean answer = StudentDao.deleteData(sid1);
                if(answer)
                {
                    System.out.println("Data deleted successfully");
                }
                else
                {
                    System.out.println("Something wrong.....");
                }
            }
            else if(n==3)
            {
              StudentDao.displayData();
            }
            else if(n==4)
            {
                System.out.println("Enter old Student id");
                int oldId=Integer.parseInt(br.readLine());
                System.out.println("-------------------------");
                System.out.println("Enter New Details");
                System.out.println("-------------------------");
                System.out.println("Enter Student id");
                int sid= Integer.parseInt(br.readLine());
                System.out.println("Enter Student name ");
                String sname= br.readLine();
                System.out.println("Enter Phone number");
                int sphone= Integer.parseInt(br.readLine());
                System.out.println("Enter area name");
                String area = br.readLine();
                Student st= new Student(sid,sname,sphone,area);
                boolean answer = StudentDao.updateData(st,oldId);
                if(answer)
                {
                    System.out.println("Data is Updated Successfully");
                }
                else
                {
                    System.out.println("Data is not updated");
                }
            }
            else if(n==5)
            {
              break;
            }
            else
            {
                System.out.println("You pressed wrong key, try again!");
            }

        }
        System.out.println("Thank You for using our app");
        System.out.println("See you again....");


    }
}