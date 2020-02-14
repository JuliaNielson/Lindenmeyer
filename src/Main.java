import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import sample.*;


public class Main extends Application{

    private static double lastX, lastY;
    private LSystem testSystem;

    Pane imagePane = new Pane();
    final DoubleProperty zoomController = new SimpleDoubleProperty(1.0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        testSystem = new PlantTest();
        //testSystem = new DragonCurve();
        Path testPath = new Path();

        primaryStage.setTitle("FractalTown");
        Scene primaryScene = new Scene(imagePane, 1000, 1000);
        primaryStage.setScene(primaryScene);


        MoveTo initializePath = new MoveTo(0, 0);
        testPath.getElements().add(initializePath);
        testPath.getElements().addAll(testSystem.getPathElements(6));

        zoomController.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable arg0) {
                imagePane.setScaleX(zoomController.get());
                imagePane.setScaleY(zoomController.get());
                centerPathInScene(testSystem, primaryScene);
            }
        });


        primaryScene.setOnMouseDragged(event -> this.DragEventProcessor(event));
        primaryScene.setOnMouseClicked(event -> {
            this.lastX = 0;
            this.lastY = 0;
        });



        primaryScene.addEventFilter(ScrollEvent.ANY, event -> {
            double deltaY = event.getDeltaY()/40.0;

            if (deltaY > 0) {
                for (int i = 0; i < deltaY;i++) {
                    zoomController.set(zoomController.get() * 1.1);
                    }
            } else if (event.getDeltaY() < 0) {
                for (int i = 0; i > deltaY; i-- ){
                    zoomController.set(zoomController.get() / 1.1);}
            }
            System.out.println(deltaY);
        });

        primaryStage.show();

        imagePane.getChildren().add(testPath);
        zoomToFit(testSystem, primaryScene);
        centerPathInScene(testSystem, primaryScene);

    }

    public void centerPathInScene(LSystem system, Scene scene){
        double pathMidY = system.getMidY();
        double pathMidX = system.getMidX();
        double sceneMidY = scene.getHeight()/2.0;
        double sceneMidX = scene.getWidth()/2.0;

        double unscaledYLocation = sceneMidY-pathMidY;
        double unscaledXLocation = sceneMidX-pathMidX;


        imagePane.relocate(unscaledXLocation*zoomController.get(), unscaledYLocation*zoomController.get());
    }

    public void zoomToFit(LSystem system, Scene scene){
        double xZoom = scene.getWidth()/system.getTotalX();
        double yZoom = scene.getHeight()/system.getTotalY();
        zoomController.set(Math.min(xZoom, yZoom));
    }

    private void DragEventProcessor(MouseEvent event){
        double nextX = event.getSceneX() - this.lastX;
        double nextY = event.getSceneY() - this.lastY;

        if (this.lastX != 0){
            imagePane.setLayoutX(imagePane.getLayoutX() + nextX);
            imagePane.setLayoutY(imagePane.getLayoutY() + nextY);
        }

        this.lastX = event.getSceneX();
        this.lastY = event.getSceneY();
    }
}
