package bchmnn;

import bchmnn.var.color.ColorPack;
import bchmnn.var.dimensions.DimensionPack;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class ToggleSwitch extends Parent {

    public BooleanProperty select = new SimpleBooleanProperty();
    public BooleanProperty armed = new SimpleBooleanProperty();

    public ColorPack selected = new ColorPack();
    public ColorPack unselected = new ColorPack();
    public DimensionPack dimensions = new DimensionPack();

    public Rectangle ground = new Rectangle();
    public Rectangle innerBorder = new Rectangle();
    public Rectangle trigger = new Rectangle();

    public TranslateTransition transition = new TranslateTransition();

    public boolean isSelect() { return select.get(); }
    public BooleanProperty selectProperty() { return select; }
    public void setSelect(boolean select) { this.select.set(select); }
    public boolean isArmed() { return armed.get(); }
    public BooleanProperty armedProperty() { return armed; }
    public void setArmed(boolean armed) { this.armed.set(armed); }

    public ToggleSwitch() {

        dimensions.speed = 70.0;
        transition.setNode(trigger);
        getChildren().addAll(ground, trigger);
        loadStyle("WIN10");
        build();
        setEventHandler();
        setListener();

    }

    public void build() {

        ground.setHeight(dimensions.ground.height);
        ground.setWidth(dimensions.ground.width);
        ground.setArcHeight(dimensions.ground.arc.width);
        ground.setArcWidth(dimensions.ground.arc.width);
        ground.setFill(Color.web(unselected.ground.base.background));
        ground.setStroke(Color.web(unselected.ground.base.border.background));
        ground.setStrokeWidth(dimensions.ground.border.width);
        ground.setStrokeMiterLimit(10.0);

        Double width = 2.0;
        innerBorder.setHeight(dimensions.ground.height - 2*(dimensions.ground.border.width));
        innerBorder.setWidth(dimensions.ground.width - 2*(dimensions.ground.border.width));
        innerBorder.setX(dimensions.ground.border.width);
        innerBorder.setY(dimensions.ground.border.width);
        innerBorder.setFill(Color.TRANSPARENT);
        innerBorder.setStrokeWidth(width);
        innerBorder.setStroke(Color.WHITE);

        trigger.setHeight(dimensions.trigger.height);
        trigger.setWidth(dimensions.trigger.width);
        trigger.setArcHeight(dimensions.trigger.arc.width);
        trigger.setArcWidth(dimensions.trigger.arc.width);
        trigger.setX(dimensions.ground.height / 4);
        trigger.setY(dimensions.ground.height / 2 - dimensions.trigger.height / 2);
        trigger.setFill(Color.web(unselected.trigger.base.background));
        trigger.setStroke(Color.web(unselected.trigger.base.border.background));
        trigger.setStrokeWidth(dimensions.trigger.border.width);

        transition.setDuration(Duration.millis(dimensions.speed));

    }

    public void setEventHandler() {

        setOnMouseClicked( event -> select.set(!select.get()) );

        setOnMousePressed( event -> armed.set(true) );

        setOnMouseReleased( event -> armed.set(false) );

    }

    public void setListener() {

        selectProperty().addListener( (v, oldBool, newBool) -> {

            transition.setToX(
                    newBool ? dimensions.ground.width - dimensions.ground.height : 0
            );

            transition.play();
            if(!newBool) {
                ground.setFill(Color.web(unselected.ground.base.background));
                ground.setStroke(Color.web(unselected.ground.base.border.background));
                trigger.setFill(Color.web(unselected.trigger.base.background));
                trigger.setStroke(Color.web(unselected.trigger.base.border.background));
            } else {
                ground.setFill(Color.web(selected.ground.hover.background));
                ground.setStroke(Color.web(selected.ground.hover.border.background));
                trigger.setFill(Color.web(selected.trigger.hover.background));
                trigger.setStroke(Color.web(selected.trigger.hover.border.background));
            }
        });

        hoverProperty().addListener( (v, oldBool, newBool) -> {
            if(newBool) {
                if(isSelect() && !isArmed()) {
                    ground.setFill(Color.web(selected.ground.hover.background));
                    ground.setStroke(Color.web(selected.ground.hover.border.background));
                    trigger.setFill(Color.web(selected.trigger.hover.background));
                    trigger.setStroke(Color.web(selected.trigger.hover.border.background));
                } else if(!isArmed()){
                    ground.setFill(Color.web(unselected.ground.hover.background));
                    ground.setStroke(Color.web(unselected.ground.hover.border.background));
                    trigger.setFill(Color.web(unselected.trigger.hover.background));
                    trigger.setStroke(Color.web(unselected.trigger.hover.border.background));
                }
            } else {
                if(isSelect() && !isArmed()) {
                    ground.setFill(Color.web(selected.ground.base.background));
                    ground.setStroke(Color.web(selected.ground.base.border.background));
                    trigger.setFill(Color.web(selected.trigger.base.background));
                    trigger.setStroke(Color.web(selected.trigger.base.border.background));
                } else if(!isArmed()) {
                    ground.setFill(Color.web(unselected.ground.base.background));
                    ground.setStroke(Color.web(unselected.ground.base.border.background));
                    trigger.setFill(Color.web(unselected.trigger.base.background));
                    trigger.setStroke(Color.web(unselected.trigger.base.border.background));
                }
            }
        });

        armedProperty().addListener( (v, oldBool, newBool) -> {
            if(newBool) {
                if(isSelect()) {
                    ground.setFill(Color.web(selected.ground.armed.background));
                    ground.setStroke(Color.web(selected.ground.armed.border.background));
                    trigger.setFill(Color.web(selected.trigger.armed.background));
                    trigger.setStroke(Color.web(selected.trigger.armed.border.background));
                } else {
                    ground.setFill(Color.web(unselected.ground.armed.background));
                    ground.setStroke(Color.web(unselected.ground.armed.border.background));
                    trigger.setFill(Color.web(unselected.trigger.armed.background));
                    trigger.setStroke(Color.web(unselected.trigger.armed.border.background));
                }
            } else {
                if(isSelect()) {
                    ground.setFill(Color.web(selected.ground.base.background));
                    ground.setStroke(Color.web(selected.ground.base.border.background));
                    trigger.setFill(Color.web(selected.trigger.base.background));
                    trigger.setStroke(Color.web(selected.trigger.base.border.background));
                } else {
                    ground.setFill(Color.web(unselected.ground.base.background));
                    ground.setStroke(Color.web(unselected.ground.base.border.background));
                    trigger.setFill(Color.web(unselected.trigger.base.background));
                    trigger.setStroke(Color.web(unselected.trigger.base.border.background));
                }
            }
        });

    }

    public void loadStyle(String style) {

        Doc doc = new Doc("src/bchmnn/styles/" + style + ".xml");

        dimensions.ground.height = doc.getD("dgh");
        dimensions.ground.width = doc.getD("dgw");
        dimensions.ground.arc.width = doc.getD("dgaw");
        dimensions.ground.border.width = doc.getD("dgbw");

        dimensions.trigger.height = doc.getD("dth");
        dimensions.trigger.width = doc.getD("dtw");
        dimensions.trigger.arc.width = doc.getD("dtaw");
        dimensions.trigger.border.width = doc.getD("dtbw");

        selected.ground.base.background = doc.getS("sgbb");
        selected.ground.base.border.background = doc.getS("sgbbb");
        selected.ground.hover.background = doc.getS("sghb");
        selected.ground.hover.border.background = doc.getS("sghbb");
        selected.ground.armed.background = doc.getS("sgab");
        selected.ground.armed.border.background = doc.getS("sgabb");

        selected.trigger.base.background = doc.getS("stbb");
        selected.trigger.base.border.background = doc.getS("stbbb");
        selected.trigger.hover.background = doc.getS("sthb");
        selected.trigger.hover.border.background = doc.getS("sthbb");
        selected.trigger.armed.background = doc.getS("stab");
        selected.trigger.armed.border.background = doc.getS("stabb");

        unselected.ground.base.background = doc.getS("ugbb");
        unselected.ground.base.border.background = doc.getS("ugbbb");
        unselected.ground.hover.background = doc.getS("ughb");
        unselected.ground.hover.border.background = doc.getS("ughbb");
        unselected.ground.armed.background = doc.getS("ugab");
        unselected.ground.armed.border.background = doc.getS("ugabb");

        unselected.trigger.base.background = doc.getS("utbb");
        unselected.trigger.base.border.background = doc.getS("utbbb");
        unselected.trigger.hover.background = doc.getS("uthb");
        unselected.trigger.hover.border.background = doc.getS("uthbb");
        unselected.trigger.armed.background = doc.getS("utab");
        unselected.trigger.armed.border.background = doc.getS("utabb");


    }

    public class Doc {

        public Document doc;

        public Doc(String path) {
            File xml = new File(path);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();
                doc = builder.parse(xml);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
                return;
            }
        }

        public String getS(String id) { return doc.getElementsByTagName(id).item(0).getTextContent(); }

        public Double getD(String id) { return Double.parseDouble(doc.getElementsByTagName(id).item(0).getTextContent()); }

    }

}
