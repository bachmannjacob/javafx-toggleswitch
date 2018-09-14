package bchmnn;

import javafx.scene.Parent;
import javafx.animation.TranslateTransition;
import javafx.beans.property.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch extends Parent implements ToggleSwitchInterface {

    Color stroke = Color.web("#333333");
    Color armed = Color.web("#666666");
    Color accent = Color.web("#498205");
    Color accent_hover = Color.web("#80a850");

    public BooleanProperty selectedProperty() { return selected; }
    public DoubleProperty widthProperty() { return width; }
    public void setWidth(double width) { this.width.set(width); }
    public DoubleProperty heightProperty() { return height; }
    public void setHeight(double height) { this.height.set(height); }
    public DoubleProperty widthBackgroundProperty() { return widthBackground; }
    public void setWidthBackground(double widthBackground) { this.widthBackground.set(widthBackground); }
    public DoubleProperty heightBackgroundProperty() { return heightBackground; }
    public void setHeightBackground(double heightBackground) { this.heightBackground.set(heightBackground); }
    public DoubleProperty widthTriggerProperty() { return widthTrigger; }
    public void setWidthTrigger(double widthTrigger) { this.widthTrigger.set(widthTrigger); }
    public DoubleProperty heightTriggerProperty() { return heightTrigger; }
    public void setHeightTrigger(double heightTrigger) { this.heightTrigger.set(heightTrigger); }
    public DoubleProperty widthBorderBackgroundProperty() { return widthBorderBackground; }
    public void setWidthBorderBackground(double widthBorderBackground) { this.widthBorderBackground.set(widthBorderBackground); }
    public DoubleProperty widthBorderTriggerProperty() { return widthBorderTrigger; }
    public void setWidthBorderTrigger(double widthBorderTrigger) { this.widthBorderTrigger.set(widthBorderTrigger); }
    public DoubleProperty arcBackgroundProperty() { return arcBackground; }
    public void setArcBackground(double arcBackground) { this.arcBackground.set(arcBackground); }
    public DoubleProperty arcTriggerProperty() { return arcTrigger; }
    public void setArcTrigger(double arcTrigger) { this.arcTrigger.set(arcTrigger); }
    public DoubleProperty speedAnimationProperty() { return speedAnimation; }
    public void setSpeedAnimation(double speedAnimation) { this.speedAnimation.set(speedAnimation); }
    public StringProperty colorBackgroundOnProperty() { return colorBackgroundOn; }
    public void setColorBackgroundOn(String colorBackgroundOn) { this.colorBackgroundOn.set(colorBackgroundOn); }
    public StringProperty colorBackgroundOffProperty() { return colorBackgroundOff; }
    public void setColorBackgroundOff(String colorBackgroundOff) { this.colorBackgroundOff.set(colorBackgroundOff); }
    public StringProperty colorBorderOnProperty() { return colorBorderOn; }
    public void setColorBorderOn(String colorBorderOn) { this.colorBorderOn.set(colorBorderOn); }
    public StringProperty colorBorderOffProperty() { return colorBorderOff; }
    public void setColorBorderOff(String colorBorderOff) { this.colorBorderOff.set(colorBorderOff); }
    public StringProperty colorTriggerOnProperty() { return colorTriggerOn; }
    public void setColorTriggerOn(String colorTriggerOn) { this.colorTriggerOn.set(colorTriggerOn); }
    public StringProperty colorTriggerOffProperty() { return colorTriggerOff; }
    public void setColorTriggerOff(String colorTriggerOff) { this.colorTriggerOff.set(colorTriggerOff); }
    public StringProperty colorHoverBackgroundOnProperty() { return colorHoverBackgroundOn; }
    public void setColorHoverBackgroundOn(String colorHoverBackgroundOn) { this.colorHoverBackgroundOn.set(colorHoverBackgroundOn); }
    public StringProperty colorHoverBackgroundOffProperty() { return colorHoverBackgroundOff; }
    public void setColorHoverBackgroundOff(String colorHoverBackgroundOff) { this.colorHoverBackgroundOff.set(colorHoverBackgroundOff); }
    public StringProperty colorHoverBorderOnProperty() { return colorHoverBorderOn; }
    public void setColorHoverBorderOn(String colorHoverBorderOn) { this.colorHoverBorderOn.set(colorHoverBorderOn); }
    public StringProperty colorHoverBorderOffProperty() { return colorHoverBorderOff; }
    public void setColorHoverBorderOff(String colorHoverBorderOff) { this.colorHoverBorderOff.set(colorHoverBorderOff); }
    public StringProperty colorHoverTriggerOnProperty() { return colorHoverTriggerOn; }
    public void setColorHoverTriggerOn(String colorHoverTriggerOn) { this.colorHoverTriggerOn.set(colorHoverTriggerOn); }
    public StringProperty colorHoverTriggerOffProperty() { return colorHoverTriggerOff; }
    public void setColorHoverTriggerOff(String colorHoverTriggerOff) { this.colorHoverTriggerOff.set(colorHoverTriggerOff); }
    public StringProperty colorArmedBackgroundOnProperty() { return colorArmedBackgroundOn; }
    public void setColorArmedBackgroundOn(String colorArmedBackgroundOn) { this.colorArmedBackgroundOn.set(colorArmedBackgroundOn); }
    public StringProperty colorArmedBackgroundOffProperty() { return colorArmedBackgroundOff; }
    public void setColorArmedBackgroundOff(String colorArmedBackgroundOff) { this.colorArmedBackgroundOff.set(colorArmedBackgroundOff); }
    public StringProperty colorArmedBorderOnProperty() { return colorArmedBorderOn; }
    public void setColorArmedBorderOn(String colorArmedBorderOn) { this.colorArmedBorderOn.set(colorArmedBorderOn); }
    public StringProperty colorArmedBorderOffProperty() { return colorArmedBorderOff; }
    public void setColorArmedBorderOff(String colorArmedBorderOff) { this.colorArmedBorderOff.set(colorArmedBorderOff); }
    public StringProperty colorArmedTriggerOnProperty() { return colorArmedTriggerOn; }
    public void setColorArmedTriggerOn(String colorArmedTriggerOn) { this.colorArmedTriggerOn.set(colorArmedTriggerOn); }
    public StringProperty colorArmedTriggerOffProperty() { return colorArmedTriggerOff; }
    public void setColorArmedTriggerOff(String colorArmedTriggerOff) { this.colorArmedTriggerOff.set(colorArmedTriggerOff); }

    public ToggleSwitch() {
        this(43.0, 18.5);
    }

    public void initialize() {

    }

    @Override
    public void setStyle() {

    }

    @Override
    public void setListener() {
        selected.addListener((v, oldValue, newValue) -> {
            transition.setToX(
                    newValue.booleanValue() ? width.getValue() - height.getValue() : 0
            );
            transition.play();

            if(newValue.booleanValue()) {
                background.setFill(accent_hover);
                background.setStroke(accent_hover);
                trigger.setFill(Color.WHITE);
            } else {
                background.setFill(Color.WHITE);
                background.setStroke(stroke);
                trigger.setFill(stroke);
            }

        });

        hoverProperty().addListener( (v, oldValue, newValue) -> {

            if(newValue) {
                if(!selected.get()) {
                    background.setStroke(Color.BLACK);
                    trigger.setFill(Color.BLACK);
                } else {
                    background.setFill(accent_hover);
                    background.setStroke(accent_hover);
                }
            } else {
                if(!selected.get()) {
                    background.setStroke(stroke);
                    trigger.setFill(stroke);
                } else {
                    background.setFill(accent);
                    background.setStroke(accent);
                }
            }
        });

    }

    @Override
    public void setEventHandler() {
        setOnMouseClicked( event -> selected.set(!selected.get()) );

        setOnMousePressed( event -> {
            background.setFill(armed);
            background.setStroke(armed);
            trigger.setFill(Color.WHITE);
        });

        setOnMouseReleased( event -> {
            background.setFill(Color.WHITE);
            background.setStroke(stroke);
            trigger.setFill(stroke);
        });

        setOnMouseDragged( event -> {

        });
    }

    public ToggleSwitch(Double width, Double height) {

        region.setPrefHeight(100.0);
        region.setPrefWidth(100.0);
        region.setBackground(Background.EMPTY);

        Rectangle background = new Rectangle(width, height);
        background.setArcWidth(height);
        background.setArcHeight(height);
        background.setFill(Color.WHITE);
        background.setStroke(stroke);
        background.setStrokeWidth(2.0);

        Circle trigger = new Circle(height / 3.7);
        trigger.setCenterX(height / 2);
        trigger.setCenterY(height / 2);
        trigger.setFill(stroke);

        transition.setNode(trigger);

        getChildren().addAll(region, background, trigger);







    }
}
