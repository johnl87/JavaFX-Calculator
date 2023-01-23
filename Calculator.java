import javafx.application.Application; 
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


/*
 * John Le 
 * 
 */
public class Calculator extends Application {
	private TextField tfFirst = new TextField();
	private TextField tfSecond = new TextField();
	private TextField tfResult = new TextField();
	private Button btAdd = new Button("Add");
	private Button btSubtract = new Button("subtract");
	private Button btClear = new Button("Clear");
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		GridPane root1 = new GridPane();
		root1.setPadding(new Insets(20, 2, 5, 15));
		root1.setHgap(5);
		root1.setVgap(15);
		
		root1.add(new Label ("First Operand "), 0, 0);
		root1.add(tfFirst, 1, 0);
		
		root1.add(new Label ("Second Operand "), 0, 1);
		root1.add(tfSecond, 1, 1);
		
		root1.add(new Label ("Result "), 0, 2);
		root1.add(tfResult, 1, 2);
		
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(btAdd, btSubtract, btClear);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(2, 2, 10, 50));
		root.setBottom(hBox);
		root.setCenter(root1);

		//set properties for UI
		root1.setAlignment(Pos.BASELINE_CENTER);
		
		tfFirst.setAlignment(Pos.BASELINE_LEFT);
		tfFirst.setMaxSize(60, 15);
		tfSecond.setAlignment(Pos.BASELINE_LEFT);
		tfSecond.setMaxSize(60, 15);
		tfResult.setAlignment(Pos.BASELINE_LEFT);
		tfResult.setMaxSize(60, 15);
		tfResult.setEditable(false);
		/*
		GridPane.setHalignment(btAdd, HPos.LEFT);
		GridPane.setHalignment(btSubtract, HPos.LEFT);
		GridPane.setHalignment(btClear, HPos.CENTER);
		*/
		btAdd.setOnAction(e -> add());
		btSubtract.setOnAction(e -> subtract());
		btClear.setOnAction(e -> clear());

		Scene scene = new Scene(root,250,200);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}//end of start
	
	private void add() {
		double first = Double.parseDouble(tfFirst.getText());
		double second = Double.parseDouble(tfSecond.getText());
		double total = first + second;
		tfResult.setText(String.format("%.1f", total));
	}
	private void subtract() {
		double first = Double.parseDouble(tfFirst.getText());
		double second = Double.parseDouble(tfSecond.getText());
		double total = first - second;
		tfResult.setText(String.format("%.1f", total));
	}
	private void clear() {
		tfResult.setText(null);
		tfFirst.setText(null);
		tfSecond.setText(null);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}