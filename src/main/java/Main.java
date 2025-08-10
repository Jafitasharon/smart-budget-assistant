
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       System.out.println("Testing resource path...");
       System.out.println(getClass().getResource("/main/view/login.fxml"));

       FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/view/login.fxml"));
       Parent root = loader.load();
       primaryStage.setScene(new Scene(root));
       primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
