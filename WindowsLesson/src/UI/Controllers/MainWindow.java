package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Runs when window opens");
    }

    public void addMemberWindow(ActionEvent actionEvent) {
        loadWindow("../Layouts/addmember.fxml", "Add Member");
    }


    public void createMessageWindow(ActionEvent actionEvent) {
    }

    void loadWindow(String location, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
