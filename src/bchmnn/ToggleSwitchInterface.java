package bchmnn;

import javafx.animation.TranslateTransition;
import javafx.beans.property.*;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

interface ToggleSwitchInterface {

    Region region = new Region();
    Rectangle background = new Rectangle();
    Rectangle trigger = new Rectangle();

    BooleanProperty selected = new SimpleBooleanProperty();
    BooleanProperty armed = new SimpleBooleanProperty();

    DoubleProperty width = new SimpleDoubleProperty();
    DoubleProperty height = new SimpleDoubleProperty();
    DoubleProperty widthBackground = new SimpleDoubleProperty();
    DoubleProperty heightBackground = new SimpleDoubleProperty();
    DoubleProperty widthTrigger = new SimpleDoubleProperty();
    DoubleProperty heightTrigger = new SimpleDoubleProperty();
    DoubleProperty widthBorderBackground = new SimpleDoubleProperty();
    DoubleProperty widthBorderTrigger = new SimpleDoubleProperty();
    DoubleProperty arcBackground = new SimpleDoubleProperty();
    DoubleProperty arcTrigger = new SimpleDoubleProperty();
    DoubleProperty speedAnimation = new SimpleDoubleProperty();

    StringProperty colorBackgroundOn = new SimpleStringProperty();
    StringProperty colorBackgroundOff = new SimpleStringProperty();
    StringProperty colorBorderOn = new SimpleStringProperty();
    StringProperty colorBorderOff = new SimpleStringProperty();
    StringProperty colorTriggerOn = new SimpleStringProperty();
    StringProperty colorTriggerOff = new SimpleStringProperty();
    StringProperty colorBorderTriggerOn = new SimpleStringProperty();
    StringProperty colorBorderTriggerOff = new SimpleStringProperty();

    StringProperty colorHoverBackgroundOn = new SimpleStringProperty();
    StringProperty colorHoverBackgroundOff = new SimpleStringProperty();
    StringProperty colorHoverBorderOn = new SimpleStringProperty();
    StringProperty colorHoverBorderOff = new SimpleStringProperty();
    StringProperty colorHoverTriggerOn = new SimpleStringProperty();
    StringProperty colorHoverTriggerOff = new SimpleStringProperty();
    StringProperty colorHoverBorderTriggerOn = new SimpleStringProperty();
    StringProperty colorHoverBorderTriggerOff = new SimpleStringProperty();

    StringProperty colorArmedBackgroundOn = new SimpleStringProperty();
    StringProperty colorArmedBackgroundOff = new SimpleStringProperty();
    StringProperty colorArmedBorderOn = new SimpleStringProperty();
    StringProperty colorArmedBorderOff = new SimpleStringProperty();
    StringProperty colorArmedTriggerOn = new SimpleStringProperty();
    StringProperty colorArmedTriggerOff = new SimpleStringProperty();
    StringProperty colorArmedBorderTriggerOn = new SimpleStringProperty();
    StringProperty colorArmedBorderTriggerOff = new SimpleStringProperty();

    TranslateTransition transition = new TranslateTransition();



    BooleanProperty selectedProperty();
    BooleanProperty armedProperty();
    DoubleProperty widthProperty();
    void setWidth(double width);
    DoubleProperty heightProperty();
    void setHeight(double height);
    DoubleProperty widthBackgroundProperty();
    void setWidthBackground(double widthBackground);
    DoubleProperty heightBackgroundProperty();
    void setHeightBackground(double heightBackground);
    DoubleProperty widthTriggerProperty();
    void setWidthTrigger(double widthTrigger);
    DoubleProperty heightTriggerProperty();
    void setHeightTrigger(double heightTrigger);
    DoubleProperty widthBorderBackgroundProperty();
    void setWidthBorderBackground(double widthBorderBackground);
    DoubleProperty widthBorderTriggerProperty();
    void setWidthBorderTrigger(double widthBorderTrigger);
    DoubleProperty arcBackgroundProperty();
    void setArcBackground(double arcBackground);
    DoubleProperty arcTriggerProperty();
    void setArcTrigger(double arcTrigger);
    DoubleProperty speedAnimationProperty();
    void setSpeedAnimation(double speedAnimation);

    StringProperty colorBackgroundOnProperty();
    void setColorBackgroundOn(String colorBackgroundOn);
    StringProperty colorBackgroundOffProperty();
    void setColorBackgroundOff(String colorBackgroundOff);
    StringProperty colorBorderOnProperty();
    void setColorBorderOn(String colorBorderOn);
    StringProperty colorBorderOffProperty();
    void setColorBorderOff(String colorBorderOff);
    StringProperty colorTriggerOnProperty();
    void setColorTriggerOn(String colorTriggerOn);
    StringProperty colorTriggerOffProperty();
    void setColorTriggerOff(String colorTriggerOff);
    StringProperty colorBorderTriggerOffProperty();
    void setColorBorderTriggerOff(String colorTriggerOff);

    StringProperty colorHoverBackgroundOnProperty();
    void setColorHoverBackgroundOn(String colorHoverBackgroundOn);
    StringProperty colorHoverBackgroundOffProperty();
    void setColorHoverBackgroundOff(String colorHoverBackgroundOff);
    StringProperty colorHoverBorderOnProperty();
    void setColorHoverBorderOn(String colorHoverBorderOn);
    StringProperty colorHoverBorderOffProperty();
    void setColorHoverBorderOff(String colorHoverBorderOff);
    StringProperty colorHoverTriggerOnProperty();
    void setColorHoverTriggerOn(String colorHoverTriggerOn);
    StringProperty colorHoverTriggerOffProperty();
    void setColorHoverTriggerOff(String colorHoverTriggerOff);
    StringProperty colorHoverBorderTriggerOffProperty();
    void setColorHoverBorderTriggerOff(String colorHoverTriggerOff);

    StringProperty colorArmedBackgroundOnProperty();
    void setColorArmedBackgroundOn(String colorArmedBackgroundOn);
    StringProperty colorArmedBackgroundOffProperty();
    void setColorArmedBackgroundOff(String colorArmedBackgroundOff);
    StringProperty colorArmedBorderOnProperty();
    void setColorArmedBorderOn(String colorArmedBorderOn);
    StringProperty colorArmedBorderOffProperty();
    void setColorArmedBorderOff(String colorArmedBorderOff);
    StringProperty colorArmedTriggerOnProperty();
    void setColorArmedTriggerOn(String colorArmedTriggerOn);
    StringProperty colorArmedTriggerOffProperty();
    void setColorArmedTriggerOff(String colorArmedTriggerOff);
    StringProperty colorArmedBorderTriggerOffProperty();
    void setColorArmedBorderTriggerOff(String colorArmedTriggerOff);



    void initialize();
    void setStyle();
    void setListener();
    void setListenerShape();
    void setListenerColor();
    void setListenerColorHover();
    void setListenerColorArmed();
    void setEventHandler();


    boolean isArmed();

}
