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
    Color armedd = Color.web("#666666");
    Color accent = Color.web("#498205");
    Color accent_hover = Color.web("#80a850");

    public BooleanProperty selectedProperty() { return selected; }
    public BooleanProperty armedProperty() { return armed; }
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
    public StringProperty colorBorderTriggerOffProperty() { return colorBorderTriggerOff; }
    public void setColorBorderTriggerOff(String colorBorderTriggerOff) { this.colorBorderTriggerOff.set(colorBorderTriggerOff); }

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
    public StringProperty colorHoverBorderTriggerOffProperty() { return colorHoverBorderTriggerOff; }
    public void setColorHoverBorderTriggerOff(String colorHoverBorderTriggerOff) { this.colorHoverBorderTriggerOff.set(colorHoverBorderTriggerOff); }

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
    public StringProperty colorArmedBorderTriggerOffProperty() { return colorArmedBorderTriggerOff; }
    public void setColorArmedBorderTriggerOff(String colorArmedBorderTriggerOff) { this.colorArmedBorderTriggerOff.set(colorArmedBorderTriggerOff); }

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
                    newValue ? widthBackground.getValue() - heightBackground.getValue() : 0
            );
            transition.play();

            if(newValue) {
                background.setFill(Color.web(colorHoverBackgroundOn.get()));
                background.setStroke(Color.web(colorHoverBorderOn.get()));
                trigger.setFill(Color.web(colorTriggerOn.get()));
                trigger.setStroke(Color.web(colorBorderTriggerOn.get()));
            } else {
                background.setFill(Color.web(colorHoverBackgroundOff.get()));
                background.setStroke(Color.web(colorHoverBorderOff.get()));
                trigger.setFill(Color.web(colorTriggerOff.get()));
                trigger.setStroke(Color.web(colorBorderTriggerOff.get()));
            }

        });

        hoverProperty().addListener( (v, oldValue, newValue) -> {

            if(newValue) {
                if(selected.get()) {
                    background.setFill(Color.web(colorHoverBackgroundOn.get()));
                    background.setStroke(Color.web(colorHoverBorderOn.get()));
                    trigger.setFill(Color.web(colorHoverTriggerOn.get()));
                    trigger.setStroke(Color.web(colorHoverBorderTriggerOn.get()));
                } else {
                    background.setFill(Color.web(colorHoverBackgroundOff.get()));
                    background.setStroke(Color.web(colorHoverBorderOff.get()));
                    trigger.setFill(Color.web(colorHoverTriggerOff.get()));
                    trigger.setStroke(Color.web(colorHoverBorderTriggerOff.get()));
                }
            } else {
                if(selected.get()) {
                    background.setFill(Color.web(colorBackgroundOn.get()));
                    background.setStroke(Color.web(colorBorderOn.get()));
                    trigger.setFill(Color.web(colorTriggerOn.get()));
                    trigger.setStroke(Color.web(colorBorderTriggerOn.get()));
                } else {
                    background.setFill(Color.web(colorBackgroundOff.get()));
                    background.setStroke(Color.web(colorBorderOff.get()));
                    trigger.setFill(Color.web(colorTriggerOff.get()));
                    trigger.setStroke(Color.web(colorBorderTriggerOff.get()));
                }
            }
        });

        setListenerShape();
        setListenerColor();
        setListenerColorHover();
        setListenerColorArmed();

    }

    @Override
    public void setListenerShape() {

        height.addListener((v, oldHeight, newHeight) -> region.setPrefHeight(newHeight.doubleValue()));
        width.addListener((v, oldWidth, newWidth) -> region.setPrefWidth(newWidth.doubleValue()));
        heightBackground.addListener((v, oldHeight, newHeight) -> background.setHeight(newHeight.doubleValue()));
        widthBackground.addListener((v, oldWidth, newWidth) -> background.setWidth(newWidth.doubleValue()));
        heightTrigger.addListener((v, oldHeight, newHeight) -> trigger.setHeight(newHeight.doubleValue()));
        widthTrigger.addListener((v, oldWidth, newWidth) -> trigger.setWidth(newWidth.doubleValue()));
        widthBorderBackground.addListener((v, oldWidth, newWidth) -> background.setStrokeWidth(newWidth.doubleValue()));
        widthBorderTrigger.addListener((v, oldWidth, newWidth) -> trigger.setStrokeWidth(newWidth.doubleValue()));
        arcBackground.addListener((v, oldArc, newArc) -> {
            background.setArcWidth(newArc.doubleValue());
            background.setArcHeight(newArc.doubleValue());
        });
        arcTrigger.addListener((v, oldArc, newArc) -> {
            trigger.setArcHeight(newArc.doubleValue());
            trigger.setArcWidth(newArc.doubleValue());
        });
        speedAnimation.addListener((v, oldSpeed, newSpeed) -> transition.setDuration(Duration.millis(newSpeed.doubleValue())));

    }

    @Override
    public void setListenerColor() {

        colorBackgroundOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && !isArmed()) {
                background.setFill(Color.web(newColor));
            }
        });
        colorBackgroundOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && !isArmed()) {
                background.setFill(Color.web(newColor));
            }
        });
        colorBorderOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && !isArmed()) {
                background.setStroke(Color.web(newColor));
            }
        });
        colorBorderOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && !isArmed()) {
                background.setStroke(Color.web(newColor));
            }
        });
        colorTriggerOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && !isArmed()) {
                trigger.setFill(Color.web(newColor));
            }
        });
        colorTriggerOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && !isArmed()) {
                trigger.setFill(Color.web(newColor));
            }
        });
        colorBorderTriggerOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && !isArmed()) {
                trigger.setStroke(Color.web(newColor));
            }
        });
        colorBorderTriggerOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && !isArmed()) {
                trigger.setStroke(Color.web(newColor));
            }
        });

    }

    @Override
    public void setListenerColorHover() {

        colorHoverBackgroundOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && isHover() && !isArmed()) {
                background.setFill(Color.web(newColor));
            }
        });
        colorHoverBackgroundOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && isHover() && !isArmed()) {
                background.setFill(Color.web(newColor));
            }
        });
        colorHoverBorderOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && isHover() && !isArmed()) {
                background.setStroke(Color.web(newColor));
            }
        });
        colorHoverBorderOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && isHover() && !isArmed()) {
                background.setStroke(Color.web(newColor));
            }
        });
        colorHoverTriggerOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && isHover() && !isArmed()) {
                trigger.setFill(Color.web(newColor));
            }
        });
        colorHoverTriggerOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && isHover() && !isArmed()) {
                trigger.setFill(Color.web(newColor));
            }
        });
        colorHoverBorderTriggerOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && isHover() && !isArmed()) {
                trigger.setStroke(Color.web(newColor));
            }
        });
        colorHoverBorderTriggerOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && isHover() && !isArmed()) {
                trigger.setStroke(Color.web(newColor));
            }
        });

    }

    @Override
    public void setListenerColorArmed() {

        colorArmedBackgroundOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && isArmed()) {
                background.setFill(Color.web(newColor));
            }
        });
        colorArmedBackgroundOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && isArmed()) {
                background.setFill(Color.web(newColor));
            }
        });
        colorArmedBorderOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && isArmed()) {
                background.setStroke(Color.web(newColor));
            }
        });
        colorArmedBorderOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && isArmed()) {
                background.setStroke(Color.web(newColor));
            }
        });
        colorArmedTriggerOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && isArmed()) {
                trigger.setFill(Color.web(newColor));
            }
        });
        colorArmedTriggerOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && isArmed()) {
                trigger.setFill(Color.web(newColor));
            }
        });
        colorArmedBorderTriggerOn.addListener((v, oldColor, newColor) -> {
            if(selected.get() && !isHover() && isArmed()) {
                trigger.setStroke(Color.web(newColor));
            }
        });
        colorArmedBorderTriggerOff.addListener((v, oldColor, newColor) -> {
            if(!selected.get() && !isHover() && isArmed()) {
                trigger.setStroke(Color.web(newColor));
            }
        });

    }

    @Override
    public void setEventHandler() {
        setOnMouseClicked( event -> selected.set(!selected.get()) );

        setOnMousePressed( event -> {
            armed.set(true);
            background.setFill(armedd);
            background.setStroke(armedd);
            trigger.setFill(Color.WHITE);
        });

        setOnMouseReleased( event -> {
            armed.set(false);
            background.setFill(Color.WHITE);
            background.setStroke(stroke);
            trigger.setFill(stroke);
        });

        /*
        setOnMouseDragged( event -> {

        });
        */
    }

    public ToggleSwitch(Double width, Double height) {

        widthBackground.setValue(width);
        heightBackground.setValue(height);

        region.setPrefHeight(100.0);
        region.setPrefWidth(100.0);
        region.setBackground(Background.EMPTY);

        background.setWidth(width);
        background.setHeight(height);
        background.setArcWidth(height);
        background.setArcHeight(height);
        background.setFill(Color.WHITE);
        background.setStroke(stroke);
        background.setStrokeWidth(2.0);

        trigger.setArcWidth(height / 2);
        trigger.setArcHeight(height / 2);
        trigger.setWidth(height / 2);
        trigger.setHeight(height / 2);
        trigger.setFill(Color.WHITE);

        //trigger.setRadius( height / 3.7 );
        trigger.setX(height / 4);
        trigger.setY(height / 4);
        trigger.setFill(stroke);

        transition.setNode(trigger);
        transition.setDuration(Duration.millis(70));

        getChildren().addAll(region, background, trigger);
        setListener();
        setEventHandler();

    }

    public boolean isArmed() {
        return armed.get();
    }

}
