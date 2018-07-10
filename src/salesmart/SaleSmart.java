package salesmart;
import app.Login;
import app.SplashScreen;
//import com.sun.javafx.tk.Toolkit;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author Theonlysmartboy <Theonlysmartboy@github.com>
 */
public class SaleSmart extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SplashScreen splashscreen = new SplashScreen();
        splashscreen.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        splashscreen.setLocation(dim.width / 2 - splashscreen.getSize().width / 2, dim.height / 2 - splashscreen.getSize().height / 2);
        Login login = new Login();
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                splashscreen.progressLabel.setText("Loading . . . " + Integer.toString(i) + " %");
                splashscreen.progressBar.setValue(i);
                if (splashscreen.progressBar.getValue() == 100) {
                    login.setVisible(true);
                   login.setLocation(dim.width / 2 - login.getSize().width / 2, dim.height / 2 - login.getSize().height / 2);
                    splashscreen.setVisible(false);
                }
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}