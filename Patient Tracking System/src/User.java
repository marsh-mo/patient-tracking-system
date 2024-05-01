import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public abstract class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
    private int age;
    private LocalDate dob;

    public User() {
    }

    public User(String name, String email, String password, String phoneNumber, String gender) {
    
       this.email=email;
       this.password=password;
       this.gender=gender;
       this.name=name;
       
    }

    public User(int id ,String name, String email, String password, String phoneNumber,String gender, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.id=id;
    }

    public User(int id ,String name,String email ,String phoneNumber,String gender,int age){
        this.id=id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public User(String name,String email , String password,String phoneNumber){
       
        this.name = name;
         this.email=email;
         this.password=password;
        this.phoneNumber = phoneNumber;
      
       
    }

    public User(int id ,String name ,String phoneNumber,String gender,int age){
       
        this.name = name;
        this.id=id;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
       
    }


    public User(String email ,String name ,String phoneNumber,String gender,LocalDate dob){
       
        this.name = name;
        this.email=email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dob=dob;
       
    }



    public boolean login(String userType) {
        boolean loggedIn = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assigment", "root", "mmhh11D@");
    
           
            String tableName;
            String passwordColumn;
    
            if (userType.equalsIgnoreCase("doctor")) {
                tableName = "doctor";
                passwordColumn = "Doctor_Password";
            } else if (userType.equalsIgnoreCase("patient")) {
                tableName = "patient";
                passwordColumn = "Patient_Password";
            } else if (userType.equalsIgnoreCase("admin")) {
                tableName = "admin";
                passwordColumn = "Admin_Password";
            } else {
                throw new IllegalArgumentException("Invalid userType: " + userType);
            }
    
            preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + userType + "_Email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
    
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString(passwordColumn);
                    if (retrievedPassword.equals(this.password)) {
                        loggedIn = true;
                        this.name = resultSet.getString(userType + "_Name");
                        this.gender = resultSet.getString(userType + "_Gender");
                        this.phoneNumber = resultSet.getString(userType + "_Phone_Number");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return loggedIn;
    }
    


    

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
}
