package application;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	private static final Locale Locale = null;
	private TextField tfItem = new TextField(); // Create textfields, label, checkbox, radiobuttons, and buttons
	private TextField tfPrice = new TextField();
	private TextField tfQuantity = new TextField();
	private Label laTotalDue = new Label();
	private CheckBox chkTaxable = new CheckBox("Taxable?");
	private ToggleGroup group = new ToggleGroup(); 
	private RadioButton rNextDay = new RadioButton("$20");
	private RadioButton rThisWeek = new RadioButton("$12");
	private RadioButton rSomeDay = new RadioButton("$5");
	private Button btProcess = new Button("Process");
	private Button btReset = new Button("Reset");
	
	@Override
	public void start(Stage primaryStage) {
			//Place radio buttons in ToggleGroup
			rNextDay.setToggleGroup(group);
			rThisWeek.setToggleGroup(group);
			rSomeDay.setToggleGroup(group);
			
			//Create UI
			GridPane gridPane = new GridPane(); 
			gridPane.setPadding(new Insets(15, 25, 15, 25));
			gridPane.setHgap(9);
			gridPane.setVgap(9);
			gridPane.add(new Label("Item: "), 0, 0);
			gridPane.add(tfItem, 1, 0);
			gridPane.add(new Label("Price: "), 0, 1);
			gridPane.add(tfPrice, 1, 1);
			gridPane.add(new Label("Quantity: "), 0, 2);
			gridPane.add(tfQuantity, 1, 2);
			gridPane.add(chkTaxable, 1, 3);
			chkTaxable.setContentDisplay(ContentDisplay.LEFT);
			gridPane.add(new Label("Shipping: "), 0, 4);
			gridPane.add(new Label("Next Day: "), 0, 5);
			gridPane.add(rNextDay, 1, 5);
			gridPane.add(new Label("This Week: "), 0, 6);
			gridPane.add(rThisWeek, 1, 6);
			gridPane.add(new Label("Some Day: "), 0, 7);
			gridPane.add(rSomeDay, 1, 7);
			gridPane.add(new Label("Total Due: "), 0, 8);
			gridPane.add(laTotalDue, 1, 8);
			gridPane.add(btProcess, 0, 9);
			gridPane.add(btReset, 1, 9);
			
			//Process event
			btProcess.setOnAction(e -> calculateTotal(Locale));
			btReset.setOnAction(e -> reset());
			//Add to scene
			Scene scene = new Scene(gridPane,400,400);
			primaryStage.setTitle("orinoco.com");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		private void calculateTotal( Locale currentLocale){
			double price = Double.parseDouble(tfPrice.getText());
			double taxable;
			int qty = Integer.parseInt(tfQuantity.getText());
			double shipping = 0;
			//Get Values from text field
			if (chkTaxable.isSelected()){
				taxable = 0.07;
			}else {
				taxable = 0;
			}
			if (rNextDay.isSelected()) {
				shipping = 20.00;
			}else if (rThisWeek.isSelected()) {
				shipping = 12.00;
			}else if (rSomeDay.isSelected()) {
				shipping = 5.00;
			}
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();  //NumberFormat class
		    Process process = new Process(price, taxable, qty, shipping); //Create new Process class 
			laTotalDue.setText(currencyFormatter.format(process.getTotalDue())); //Call getTotalSue method and set to label
	}
		//Method for reset button
		private void reset() {
			String clear = " ";
			tfItem.clear(); 
			tfPrice.clear();
			tfQuantity.clear();
			laTotalDue.setText(clear);
			
			if(chkTaxable.isSelected()) {
				chkTaxable.setSelected(false);
			}
			if(rNextDay.isSelected()) {
				rNextDay.setSelected(false);
			}
			if(rThisWeek.isSelected()) {
				rThisWeek.setSelected(false);
			}
			if(rSomeDay.isSelected()) {
				rSomeDay.setSelected(false);
			}
			
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
