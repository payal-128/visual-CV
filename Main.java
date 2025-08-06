package sample;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resume_builder.fxml"));
        primaryStage.setTitle("Resume Builder");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
