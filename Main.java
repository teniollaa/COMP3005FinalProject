
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static String url = "jdbc:postgresql://localhost:5432/Fitness"; //Your localhost port and database name.
    private static String user = "postgres"; //Your postsql user.
    private static String password = "theawesome01"; //Your postsql password.
    private static Connection connection; //Connection we will use once established.

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password); //Establish connection and login.
            if (connection != null) {
                System.out.println("Connected to database.");
                int choice = 0;
                Scanner scan = new Scanner(System.in);
                while (choice != 5) { //Loop that goes through until wish to exit to call each function.
                    System.out.println("[Main Menu]\nInput function choice: \n" +
                            "[1] = (Member Functions)\n" +
                            "[2] = (Trainer Functions)\n" +
                            "[3] = (Administrative Staff Functions)\n" +
                            "[4] = createData()\n" +
                            "[5] = exit.");
                    choice = scan.nextInt();
                    if (choice == 1) { //Run Member Functions options.
                        int choice1 = 0;
                        while (choice1 != 5) {
                            System.out.println("[Member Functions]\nInput function choice: \n" +
                                    "[1] = getAllMembers()\n" +
                                    "[2] = addMember(first_name, last_name, email, height, mass, goal)\n" +
                                    "[3] = deleteMember(member_id)\n" +
                                    "[4] = profileMan(member_id)\n" +
                                    "[5] = exit.");
                            choice1 = scan.nextInt();
                            if (choice1 == 1) {
                                getAllMembers(); //Calls function.
                            } else if (choice1 == 2) {
                                System.out.println("Input first_name: ");
                                String first_name = scan.next();
                                System.out.println("Input last_name: ");
                                String last_name = scan.next();
                                System.out.println("Input email: ");
                                String email = scan.next();
                                System.out.println("Input height (Float): ");
                                float height = scan.nextFloat();
                                System.out.println("Input Mass (Float): ");
                                float mass = scan.nextFloat();
                                System.out.println("Input Weight Goal (Float): ");
                                float goal = scan.nextFloat();
                                addMember(first_name,last_name,email,height,mass,goal); //Calls function.
                            } else if (choice1 == 3) {
                                System.out.println("Input existing member_id to delete: ");
                                int member_id = scan.nextInt();
                                deleteMember(member_id); //Calls function.
                            } else if (choice1 == 4) {
                                System.out.println("Input existing member_id to manage profile: ");
                                int member_id = scan.nextInt();
                                deleteMember(member_id); //Calls function.
                            } else if (choice1 == 5) { break; }
                        }
                    } else if (choice == 2) { //Run Trainer Functions options.
                        int choice1 = 0;
                        while (choice1 != 5) {
                            System.out.println("[Member Functions]\nInput function choice: \n" +
                                    "[1] = addTrainer(first_name,last_name,email,start,end)\n" +
                                    "[2] = deleteTrainer(trainer_id)\n" +
                                    "[3] = setAvailability(trainer_id,start,end)\n" +
                                    "[4] = profileView(first_name)\n" +
                                    "[5] = exit.");
                            choice1 = scan.nextInt();
                            if (choice1 == 1) {
                                System.out.println("Input first_name: ");
                                String first_name = scan.next();
                                System.out.println("Input last_name: ");
                                String last_name = scan.next();
                                System.out.println("Input email: ");
                                String email = scan.next();
                                System.out.println("Input start availability (int - {Military Time}): ");
                                int start = scan.nextInt();
                                System.out.println("Input end availability (int - {Military Time}): ");
                                int end = scan.nextInt();
                                addTrainer(first_name,last_name,email,start,end); //Calls function.
                            } else if (choice1 == 2) { //delete trainer
                                System.out.println("Input existing trainer_id to delete: ");
                                int trainer_id = scan.nextInt();
                                deleteTrainer(trainer_id); //Calls function.
                            } else if (choice1 == 3) { //Schedule Management (Trainer can set the time for which they are available).
                                System.out.println("Input existing trainer_id to set availability for: ");
                                int trainer_id = scan.nextInt();
                                System.out.println("Input start availability (int): ");
                                int start = scan.nextInt();
                                System.out.println("Input end availability (int): ");
                                int end = scan.nextInt();
                                setAvailability(trainer_id,start,end);
                            } else if (choice1 == 4) { //Member Profile Viewing (Search by Member’s name).
                                System.out.println("Input first_name: ");
                                String first_name = scan.next();
                                profileView(first_name);
                            } else if (choice1 == 5) { break; }
                        }
                    } else if (choice == 3) { //Run Administrative Staff Functions options.
                        int choice1 = 0;
                        while (choice1 != 6) {
                            System.out.println("[Member Functions]\nInput function choice: \n" +
                                    "[1] = roomBooking()\n" + //do last
                                    "[2] = equipMaintenance()\n" + //do last
                                    "[3] = createSession(member_id,length)\n" + // Finds available trainer for member within certain time for requested length and creates session.
                                    "[4] = classSchedUpdate(session_id)\n" + //Find schedule and update it (change times or trainers or remove)
                                    "[5] = billProcess(member_id,bill)\n" + //Bill member amount.
                                    "[6] = exit.");
                            choice1 = scan.nextInt();
                            if (choice1 == 1) {
                                //Room Booking Management.
                            } else if (choice1 == 2) {
                                //Equipment Maintenance Monitoring.
                            } else if (choice1 == 3) { // Create session with member and trainer.
                                System.out.println("Input existing member_id to create session for: ");
                                int member_id = scan.nextInt();
                                System.out.println("Input requested length of session (int): ");
                                int length = scan.nextInt();
                                createSession(member_id,length);
                            } else if (choice1 == 4) {
                                //Class Schedule Updating (Link trainer with available time to session with member).
                                System.out.println("Input existing session_id to update schedule: ");
                                int session_id = scan.nextInt();
                                deleteMember(session_id); //Calls function.
                                classSchedUpdate(session_id);
                            } else if (choice1 == 5) { //Billing and Payment Processing (Your system should assume integration with a payment service.
                                System.out.println("Input existing member_id to bill (int): ");
                                int member_id = scan.nextInt();
                                System.out.println("Input amount to bill (float): ");
                                float bill = scan.nextFloat();
                                billProcess(member_id,bill);
                            } else if (choice1 == 6) { break; }
                        }
                    } else if (choice == 4) { // Generate data
                        createData();
                    } else if (choice == 5) { break; }
                }
            } else {
                System.out.println("Failed to connect to database.");
            }
        }
        catch(Exception e){System.out.println(e);}
    }

    static public void getAllMembers() throws SQLException {//Function correctly retrieves and displays records.
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        statement.executeQuery("SELECT * FROM Members"); //Executes command but returns a result.
        ResultSet resultSet = statement.getResultSet(); //Grabs results from query.
        while(resultSet.next()) { //Traverses through all results (each row).
            System.out.print(resultSet.getInt("member_id") + "\t"); //"\t" = tab //Gets and prints member_id.
            System.out.print(resultSet.getString("first_name") + "\t"); //Gets and prints first_name.
            System.out.print(resultSet.getString("last_name") + "\t"); //Gets and prints last_name.
            System.out.print(resultSet.getString("email") + "\t"); //Gets and prints email.
            System.out.print(resultSet.getFloat("height") + "\t"); //Gets and prints height.
            System.out.print(resultSet.getFloat("mass") + "\t"); //Gets and prints mass.
            System.out.print(resultSet.getFloat("goal_weight") + "\t"); //Gets and prints goal_weight.
            System.out.print(resultSet.getBoolean("achieved") + "\t"); //Gets and prints achieved.
            System.out.print(resultSet.getFloat("owed_bills") + "\t\n"); //Gets and prints owed bills.
        }
        System.out.print("\n");
    } //Complete.

    static public void addMember(String first_name, String last_name, String email, float height, float mass, float goal) throws SQLException { //Inserts a new member record into the members table.
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        String sqlCmd = "INSERT INTO Members (first_name, last_name, email, height, mass, goal_weight, achieved, owed_bills) VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + height + "', '" + mass +  "', '" + goal +  "', '" + false + "', '" + 0 + "')";
        statement.executeUpdate(sqlCmd); //Executes command.
    } //Since the member ID auto increments, we just input everything else. //Complete.

    static public void deleteMember(int member_id) throws SQLException { //Function successfully removes a member record
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        String sqlCmd = "DELETE FROM Members WHERE member_id = " + member_id; //Deletes row where member_id matches input.
        statement.executeUpdate(sqlCmd); //Executes command.

        //After deleted here, delete all sessions associated with the same member_id:

        //delete sessions here

    } //Almost Complete.

    static public void addTrainer(String first_name, String last_name, String email, int start, int end) throws SQLException { //Inserts new trainer.
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        String sqlCmd = "INSERT INTO Trainers (first_name, last_name, email, start_availability, end_availability) VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + start + "', '" + end + "')";
        statement.executeUpdate(sqlCmd); //Executes command.
    }

    static public void deleteTrainer(int trainer_id) throws SQLException { //Function successfully removes a trainer.
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        String sqlCmd = "DELETE FROM Trainers WHERE member_id = " + trainer_id; //Deletes row where member_id matches input.
        statement.executeUpdate(sqlCmd); //Executes command.

        //After deleted here, delete all sessions associated with the same trainer_id:
        //delete sessions here----------

    }

    static public void setAvailability(int trainer_id, int start, int end) throws SQLException {
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        String sqlCmd = "UPDATE Trainers SET start_availability = '" + start + "' WHERE trainer_id = " + trainer_id;
        statement.executeUpdate(sqlCmd); //Executes command.
        sqlCmd = "UPDATE Trainers SET end_availability = '" + end + "' WHERE trainer_id = " + trainer_id;
        statement.executeUpdate(sqlCmd); //Executes command.
        //Check all existing sessions and if they don't match up with trainers availability any more than delete those
        //sessions that were made.

        //[DO HERE]

    } //Almost Done.

    static public void profileView(String first_name) throws SQLException { //Search all members and if they have that name then print.
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        statement.executeQuery("SELECT * FROM Members"); //Executes command but returns a result.
        ResultSet resultSet = statement.getResultSet(); //Grabs results from query.
        while(resultSet.next()) { //Traverses through all results (each row).
            if (resultSet.getString("first_name") == first_name) {
                System.out.print(resultSet.getInt("member_id") + "\t"); //"\t" = tab //Gets and prints member_id.
                System.out.print(resultSet.getString("first_name") + "\t"); //Gets and prints first_name.
                System.out.print(resultSet.getString("last_name") + "\t"); //Gets and prints last_name.
                System.out.print(resultSet.getString("email") + "\t"); //Gets and prints email.
                System.out.print(resultSet.getFloat("height") + "\t"); //Gets and prints height.
                System.out.print(resultSet.getFloat("mass") + "\t\n"); //Gets and prints mass.
            }
        }
        System.out.print("\n");
    }


    static public void createSession(int member_id, int reqLength) throws SQLException {
        //Find available trainer within that time.
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        statement.executeQuery("SELECT * FROM Trainers"); //Executes command but returns a result.
        ResultSet resultSet = statement.getResultSet(); //Grabs results from query.
        boolean avail = false;
        while(resultSet.next()) { //Traverses through all results (each row).
            int totTime = resultSet.getInt("end_availability") - resultSet.getInt("start_availability");
            if (reqLength <= totTime ) { // Checks if requested session time fits in trainers availability range,
                int trainer_id = resultSet.getInt("trainer_id");
                int start = resultSet.getInt("start_availability");
                Statement statement3 = connection.createStatement(); //Creates statement to be executed.
                String sqlCmd3 = "INSERT INTO Sessions (trainer_id, member_id, start_time, end_time, room_number) VALUES ('" + trainer_id + "', '" + member_id + "', '" + start + "', '" + (start+reqLength) + "', '" + 1 + "')";
                statement3.executeUpdate(sqlCmd3); //Executes command.
                avail = true;
                //Check all trainer session times
                /*
                Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                int trainer_id = resultSet.getInt("trainer_id");
                String sqlCmd2 = "SELECT * FROM Sessions WHERE trainer_id = " + resultSet.getInt("trainer_id");
                statement2.executeQuery(sqlCmd2); //Executes command but returns a result.
                ResultSet resultSet2 = statement2.getResultSet(); //Grabs results from query.
                while(resultSet2.next()) {
                    int sessTime = resultSet2.getInt("end_time") - resultSet2.getInt("start_time");
                    if ((totTime - sessTime) > reqLength) {//now check from left and right ends
                        if ((resultSet.getInt("end_availability") - resultSet2.getInt("end_time")) >= reqLength) {
                            Statement statement3 = connection.createStatement(); //Creates statement to be executed.
                            String sqlCmd3 = "INSERT INTO Sessions (trainer_id, member_id, start_time, end_time, room_number) VALUES ('" + trainer_id + "', '" + member_id + "', '" + resultSet2.getInt("end_time") + "', '" + (resultSet2.getInt("end_time") + reqLength) + "', '" + 1 + "')";
                            statement3.executeUpdate(sqlCmd3); //Executes command.
                            avail = true;
                            break;
                        } else if ((resultSet2.getInt("start_time") - (resultSet.getInt("start_availability"))) <= reqLength) {
                            Statement statement3 = connection.createStatement(); //Creates statement to be executed.
                            String sqlCmd3 = "INSERT INTO Sessions (trainer_id, member_id, start_time, end_time, room_number) VALUES ('" + trainer_id + "', '" + member_id + "', '" + resultSet.getInt("start_availability") + "', '" + (resultSet.getInt("start_availability") + reqLength) + "', '" + 1 + "')";
                            statement3.executeUpdate(sqlCmd3); //Executes command.
                            avail = true;
                            break;
                        }

                    }
                }
                if (avail == true) { break; }
                */
            }
        }

        if (avail == false) {
            System.out.println("No available trainers during this time. Booking failed, please try again.");
        } else { System.out.println("Session Booking was successful."); }

        System.out.print("\n");
        //Loop through all trainers. If trainers availability lines up, then check if they have existing session.
    } //Done.

    static public void classSchedUpdate(int session_id) throws SQLException {
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        statement.executeQuery("SELECT * FROM Sessions"); //Executes command but returns a result.
        ResultSet resultSet = statement.getResultSet(); //Grabs results from query.
        while(resultSet.next()) { //Traverses through all results (each row).
            if (resultSet.getInt("session_id") == session_id) {
                Scanner scan = new Scanner(System.in);
                int choice = 0;
                while (choice != 6) {
                    System.out.println("[Main Menu]\nInput function choice: \n" +
                            "[1] = Change Room.\n" +
                            "[2] = Change Trainer.\n" +
                            "[3] = Change Member.\n" +
                            "[4] = Change Start and End Time.\n" +
                            "[5] = Delete Session.\n" +
                            "[6] = exit.");
                    if (choice == 1) {
                        System.out.println("Input new room number (int): ");
                        int room_number = scan.nextInt();
                        Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                        String sqlCmd2 = "UPDATE Sessions SET room_number = '" + room_number + "' WHERE session_id = " + session_id;
                        statement2.executeUpdate(sqlCmd2); //Executes command.
                    } else if (choice == 2) {
                        System.out.println("Input new existing trainer_id for session (int): ");
                        String trainer_id = scan.next();
                        Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                        String sqlCmd2 = "UPDATE Sessions SET trainer_id  = '" + trainer_id + "' WHERE session_id = " + session_id;
                        statement2.executeUpdate(sqlCmd2); //Executes command.
                    } else if (choice == 3) {
                        System.out.println("Input new existing member_id for session (int): ");
                        String member_id = scan.next();
                        Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                        String sqlCmd2 = "UPDATE Sessions SET member_id  = '" + member_id + "' WHERE session_id = " + session_id;
                        statement2.executeUpdate(sqlCmd2); //Executes command.
                    } else if (choice == 4) {
                        System.out.println("Input new start time for session (int): ");
                        int start = scan.nextInt();
                        System.out.println("Input new end time for session (int): ");
                        int end = scan.nextInt();
                        Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                        String sqlCmd2 = "UPDATE Sessions SET start_time  = '" + start + "' WHERE session_id = " + session_id;
                        statement2.executeUpdate(sqlCmd2); //Executes command.
                        sqlCmd2 = "UPDATE Sessions SET end_time  = '" + end + "' WHERE session_id = " + session_id;
                        statement2.executeUpdate(sqlCmd2); //Executes command.
                    } else if (choice == 5) {
                        Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                        String sqlCmd2 = "DELETE FROM Sessions WHERE session_id = " + session_id; //Deletes row where session_id matches input.
                        statement2.executeUpdate(sqlCmd2); //Executes command.
                        break;
                    } else if (choice == 6) { break; }
                }
            }
        }
    } //Done.

    static public void billProcess(int member_id, float bill) throws SQLException {
        Statement statement = connection.createStatement(); //Creates statement to be executed.
        statement.executeQuery("SELECT * FROM Members"); //Executes command but returns a result.
        ResultSet resultSet = statement.getResultSet(); //Grabs results from query.
        while(resultSet.next()) { //Traverses through all results (each row).
            if (resultSet.getInt("member_id") == member_id) {
                Statement statement2 = connection.createStatement(); //Creates statement to be executed.
                String sqlCmd2 = "UPDATE Members SET owed_bills = '" + (resultSet.getFloat("owed_bills")+bill) + "' WHERE member_id = " + member_id;
                statement2.executeUpdate(sqlCmd2); //Executes command.
                break;
            }
        }
    }

    static public void createData() throws SQLException { //Creates data set and inserts default values as spec requires.
        //Make it use the dll file to create the tables and then make it use the dml to generate data for it:


        /*Old code:
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (student_id SERIAL PRIMARY KEY,first_name TEXT NOT NULL,last_name TEXT NOT NULL,email TEXT NOT NULL UNIQUE,enrollment_date DATE)");
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');");
        */
    } //Complete.
}