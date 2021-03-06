package team.unstudio.jblockly.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import team.unstudio.jblockly.SlotType;
import team.unstudio.jblockly.util.BlockBuilder;
import team.unstudio.jblockly.BlockWorkspace;
import team.unstudio.jblockly.ConnectionType;
import team.unstudio.jblockly.util.BlockBuilder;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BlockBuilder main = new BlockBuilder().setConnectionType(ConnectionType.NONE).setRegistyName("main")
				.addLabel("main").addBlockSlot().addBlockSlot("branch",SlotType.BRANCH).addLabel("").addBlockSlot();
		
		BlockBuilder ifBlock = new BlockBuilder().setConnectionType(ConnectionType.TOPANDBOTTOM).setRegistyName("if")
				.addLabel("如果").addBlockSlot("if", SlotType.INSERT).addBlockSlot("branch", SlotType.BRANCH)
				.addBlockSlot().addBlockSlot("next",SlotType.NEXT);
		
		BlockBuilder end = new BlockBuilder().setConnectionType(ConnectionType.TOP).setRegistyName("end").addLabel("返回").addBlockSlot();

		BlockBuilder hookan = new BlockBuilder().setConnectionType(ConnectionType.LEFT).setRegistyName("hookan")
				.addLabel("皇天").addBlockSlot();
		
		BlockBuilder getDalao = new BlockBuilder().setConnectionType(ConnectionType.LEFT).setRegistyName("getDalao")
				.addLabel("获取大佬").addBlockSlot(null, SlotType.INSERT);
		
		BlockBuilder nvZhuang = new BlockBuilder().setConnectionType(ConnectionType.LEFT).setRegistyName("nvZhuang")
				.addLabel("女装").addBlockSlot();
		
		BlockBuilder dalao = new BlockBuilder().setConnectionType(ConnectionType.TOPANDBOTTOM).setRegistyName("dalao")
				.addLabel("变量 大佬").addBlockSlot(null, SlotType.INSERT);
		
		BlockBuilder set = new BlockBuilder().setConnectionType(ConnectionType.LEFT).setRegistyName("set")
				.addLabel("=").addBlockSlot(null, SlotType.INSERT);
		
		BlockWorkspace workspace = new BlockWorkspace();
		workspace.addBlock(main.build());
		workspace.addBlock(ifBlock.build());
		workspace.addBlock(hookan.build());
		workspace.addBlock(getDalao.build());
		workspace.addBlock(nvZhuang.build());
		workspace.addBlock(dalao.build());
		workspace.addBlock(dalao.build());
		workspace.addBlock(set.build());
		workspace.addBlock(end.build());

		Scene scene = new Scene(workspace);

		stage.setTitle("JBlockly");
		stage.setWidth(900);
		stage.setHeight(600);
		stage.setScene(scene);
		stage.show();
	}
}
