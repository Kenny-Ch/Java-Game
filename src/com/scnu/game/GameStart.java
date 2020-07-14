package com.scnu.game;

import com.scnu.controller.GameListener;
import com.scnu.controller.GameThread;
import com.scnu.show.GameJFrame;
import com.scnu.show.GameMainJPanel;

public class GameStart {
	/**
	 * @程序的唯一入口
	 */
	public static void main(String[] args) {
		GameJFrame gj=new GameJFrame();
//		第一件事情，实例化面板，注入到jframe中
		GameMainJPanel jp=new GameMainJPanel();
//		实例化监听
		GameListener listener=new GameListener();
		GameThread th=new GameThread();
//		注入
		gj.setJPanel(jp);
		gj.setKeyListener(listener);
		gj.setThread(th);
		gj.start();
				

	}

}
