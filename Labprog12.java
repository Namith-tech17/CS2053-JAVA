import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Labprog12 extends Application {
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label rollLabel = new Label("Roll No:");
        TextField rollField = new TextField();

        Label courseLabel = new Label("Course:");
        TextField courseField = new TextField();

        Button submitBtn = new Button("Add Record");
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);

        submitBtn.setOnAction(e -> {
            String name = nameField.getText();
            String roll = rollField.getText();
            String course = courseField.getText();

            if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
                displayArea.appendText(" Please fill all fields!\n");
            } else {
                displayArea.appendText(" " + name + " (" + roll + ") - " + course + "\n");
                nameField.clear();
                rollField.clear();
                courseField.clear();
            }
        });

        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);
        form.addRow(0, nameLabel, nameField);
        form.addRow(1, rollLabel, rollField);
        form.addRow(2, courseLabel, courseField);
        form.add(submitBtn, 1, 3);

        VBox layout = new VBox(15, form, displayArea);
        layout.setStyle("-fx-padding: 20; -fx-font-size: 14px;");

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Student Record System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
