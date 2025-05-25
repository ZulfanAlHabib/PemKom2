package phbmediaplayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {

    private MediaPlayer mediaPlayer;

    @FXML private MediaView mediaView;
    @FXML private StackPane sPane;
    @FXML private Button playPause;
    @FXML private Slider volume;
    @FXML private Slider seek;
    @FXML private BorderPane bPane;

    List<String> playlist = new ArrayList<>();
    List<String> sourceName = new ArrayList<>();
    static int INDEX = 0;
    static int PLAY = 0;

    @FXML
    private void openFiles(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Media File", "*.mp4", "*.mp3");
        fc.getExtensionFilters().add(filter);
        List<File> files = fc.showOpenMultipleDialog(null);

        if (files != null) {
            playlist.clear();
            sourceName.clear();
            for (File file : files) {
                playlist.add(file.toURI().toString());
                sourceName.add(file.getName());
            }
            INDEX = 0;
            playMedia(INDEX);

            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Multimedia");
            dialog.setContentText("Proses media!!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.initStyle(StageStyle.UTILITY);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();
        }
    }

    private void playMedia(int index) {
        String source = playlist.get(index);
        Media media = new Media(source);

        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }

        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setPreserveRatio(true);

        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

        volume.setValue(50);
        volume.valueProperty().addListener((Observable observable) -> {
            mediaPlayer.setVolume(volume.getValue() / 100);
        });

        mediaPlayer.setOnReady(() -> {
            Duration total = mediaPlayer.getMedia().getDuration();
            seek.setMax(total.toSeconds());
        });

        mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
            seek.setValue(newValue.toSeconds());
        });

        seek.setOnMouseClicked(event -> mediaPlayer.seek(Duration.seconds(seek.getValue())));
        seek.setOnMouseDragged(event -> mediaPlayer.seek(Duration.seconds(seek.getValue())));

        mediaPlayer.play();
        PLAY = 1;

        Image imagePause = new Image(getClass().getResourceAsStream("/images/00.png"));
        playPause.setGraphic(new ImageView(imagePause));
    }

    @FXML
    private void seekBackward(ActionEvent event) {
        if (INDEX > 0) {
            INDEX--;
            playMedia(INDEX);
        }
    }

    @FXML
    private void seekForward(ActionEvent event) {
        if ((INDEX + 1) < playlist.size()) {
            INDEX++;
            playMedia(INDEX);
        }
    }

    @FXML
    private void stop(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            Image imagePlay = new Image(getClass().getResourceAsStream("/images/5.png"));
            playPause.setGraphic(new ImageView(imagePlay));
            PLAY = 0;
        }
    }

    @FXML
    private void playPause(ActionEvent event) {
        if (mediaPlayer != null) {
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if (status == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                Image imagePlay = new Image(getClass().getResourceAsStream("/images/5.png"));
                playPause.setGraphic(new ImageView(imagePlay));
                PLAY = 0;
            } else {
                mediaPlayer.play();
                Image imagePause = new Image(getClass().getResourceAsStream("/images/00.png"));
                playPause.setGraphic(new ImageView(imagePause));
                PLAY = 1;
            }

            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Multimedia");
            dialog.setContentText("Proses media!!");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.initStyle(StageStyle.UTILITY);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();
        }
    }

    @FXML
    private void backward(ActionEvent event) {
        if (mediaPlayer != null) {
            Duration current = mediaPlayer.getCurrentTime();
            mediaPlayer.seek(current.subtract(Duration.seconds(5)));
        }
    }

    @FXML
    private void forward(ActionEvent event) {
        if (mediaPlayer != null) {
            Duration current = mediaPlayer.getCurrentTime();
            mediaPlayer.seek(current.add(Duration.seconds(5)));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Optional: anything you want to initialize
    }
}
