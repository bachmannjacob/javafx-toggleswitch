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
import org.w3c.dom.NodeList;
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

        trigger.setHeight(dimensions.trigger.height);
        trigger.setWidth(dimensions.trigger.width);
        trigger.setArcHeight(dimensions.trigger.arc.width);
        trigger.setArcWidth(dimensions.trigger.arc.width);
        trigger.setX(dimensions.ground.height / 4);
        trigger.setY(dimensions.ground.height / 4);
        trigger.setFill(Color.web(unselected.trigger.base.background));
        trigger.setStroke(Color.web(unselected.trigger.base.border.background));
        trigger.setStrokeWidth(dimensions.trigger.border.width);

        transition.setNode(trigger);
        transition.setDuration(Duration.millis(dimensions.speed));

        getChildren().addAll(ground, trigger);

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

        dimensions.ground.height = doc.getD("0");
        dimensions.ground.width = doc.getD("1");
        dimensions.ground.arc.width = doc.getD("2");
        dimensions.ground.border.width = doc.getD("3");

        dimensions.trigger.height = doc.getD("4");
        dimensions.trigger.width = doc.getD("5");
        dimensions.trigger.arc.width = doc.getD("6");
        dimensions.trigger.border.width = doc.getD("7");

        selected.ground.base.background = doc.getS("8");
        selected.ground.base.border.background = doc.getS("9");
        selected.ground.hover.background = doc.getS("10");
        selected.ground.hover.border.background = doc.getS("11");
        selected.ground.armed.background = doc.getS("12");
        selected.ground.armed.border.background = doc.getS("13");

        selected.trigger.base.background = doc.getS("14");
        selected.trigger.base.border.background = doc.getS("15");
        selected.trigger.hover.background = doc.getS("16");
        selected.trigger.hover.border.background = doc.getS("17");
        selected.trigger.armed.background = doc.getS("18");
        selected.trigger.armed.border.background = doc.getS("19");

        unselected.ground.base.background = doc.getS("20");
        unselected.ground.base.border.background = doc.getS("21");
        unselected.ground.hover.background = doc.getS("22");
        unselected.ground.hover.border.background = doc.getS("23");
        unselected.ground.armed.background = doc.getS("24");
        unselected.ground.armed.border.background = doc.getS("25");

        unselected.trigger.base.background = doc.getS("26");
        unselected.trigger.base.border.background = doc.getS("27");
        unselected.trigger.hover.background = doc.getS("28");
        unselected.trigger.hover.border.background = doc.getS("29");
        unselected.trigger.armed.background = doc.getS("30");
        unselected.trigger.armed.border.background = doc.getS("31");


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

            doc.getDocumentElement().normalize();
        }

        public String getS(String id) { return doc.getElementById(id).getTextContent(); }

        public Double getD(String id) { return Double.parseDouble(doc.getElementById(id).getTextContent()); }

    }

}
