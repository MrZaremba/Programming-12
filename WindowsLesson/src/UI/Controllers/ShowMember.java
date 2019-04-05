package UI.Controllers;

import Database.DatabaseHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowMember implements Initializable {


    public TableView table;

    public static class Member{
        private final SimpleStringProperty name;
        private final SimpleStringProperty id;
        private final SimpleStringProperty email;
        private final SimpleStringProperty nick;

        Member(String name, String id, String email, String nickName){
            this.name = new SimpleStringProperty(name);
            this.id = new SimpleStringProperty((id));
            this.email = new SimpleStringProperty(email);
            this.nick = new SimpleStringProperty(nickName);
        }

        public String getName() {
            return name.get();
        }
        public String getId() {
            return id.get();
        }
        public String getEmail() {
            return email.get();
        }
        public String getNick() {
            return nick.get();
        }
    }
    public ObservableList<Member> members = FXCollections.observableArrayList();
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableColumn emailCol;
    public TableColumn nickCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initiCol();
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void loadData() throws SQLException {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String qu = "SELECT * FROM MEMBER";
        ResultSet rs = handler.execQuery(qu);
        while(rs.next()){
            String name = rs.getString("name");
            String id = rs.getString("id");
            String email = rs.getString("email");
            String nick = rs.getString("nickname");

            members.add(new Member(name,id,email,nick));
        }
        table.getItems().setAll(members);
    }

    private void initiCol() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        nickCol.setCellValueFactory(new PropertyValueFactory<>("nick"));
    }
}
