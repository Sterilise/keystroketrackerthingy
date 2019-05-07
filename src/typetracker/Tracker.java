package typetracker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Tracker extends Application {
    private Label label;
    private Processor processor;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new VBox();
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);


        addLabel(root);
        processor = new SimpleProcessor(label);
        initialiseKeyLogging();

        Button resetButton = new Button("Reset WPM");
        resetButton.setOnAction(value -> processor.reset());
        root.getChildren().add(resetButton);

        primaryStage.show();
    }

    private void addLabel(Pane parent) {
        parent.getChildren().add(label = new Label());
    }

    /**
     * Needs to be filled out once found out how to detect key press event.
     */

    private void initialiseKeyLogging() {

        try
        {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyListener()
            {

                @Override
                public void nativeKeyTyped(NativeKeyEvent nativeEvent)
                {

                }

                @Override
                public void nativeKeyReleased(NativeKeyEvent nativeEvent)
                {

                }

                @Override
                public void nativeKeyPressed(NativeKeyEvent nativeEvent)
                {
                    //dispatches event to relevant classes
                    processor.processKey(new Key(nativeEvent));
                }
            });
            // Clear previous logging configurations.
            LogManager.getLogManager().reset();

            // Get the logger for "org.jnativehook" and set the level to off.
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
        }
        catch (NativeHookException e)
        {
            e.printStackTrace();
        }
    }
}
