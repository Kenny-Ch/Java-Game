package com.scnu.game;

import com.scnu.show.GameJFrame;
import com.scnu.show.GameMainJPanel;

public class GameStart {
	/**
	 * @程序的唯一入口
	 */
	public static void main(String[] args) {
		GameJFrame gj=new GameJFrame();
		//第一件事情，实例化面板，注入到jframe中
		GameMainJPanel jp=new GameMainJPanel();
		
		gj.setJPanel(jp);
		gj.start();

	}

}
