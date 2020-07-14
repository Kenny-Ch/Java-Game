package com.scnu.show;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.scnu.element.ElementObj;
import com.scnu.element.Play;
import com.scnu.manager.ElementManager;
import com.scnu.manager.GameElement;

/**
 * @说明 游戏的主要面板
 * @author 12083
 * @功能说明 主要进行元素的显示，同时进行界面的刷新（多线程）
 * 
 * @题外话 Java开发首先思考的应该是：做继承或者是接口实现
 * 
 * @多线程刷新 1.本类实现线程接口
 * 			 2.本类中定义一个内部类来实现
 *
 */
public class GameMainJPanel extends JPanel implements Runnable{
//联动管理器
	private ElementManager em;
	
	public GameMainJPanel() {
		init();
	}

	public void init() {
		em=ElementManager.getManager();
	}
	/**
	 * paint用于绘画的 Graphics 画笔 专门用于绘画
	 * @说明
	 * @约定
	 */
	@Override 
	public void paint(Graphics g) {
		super.paint(g);
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
		for(GameElement ge:GameElement.values()) {
			List<ElementObj> list = all.get(ge);
			for(int i=0;i<list.size();i++) {
				ElementObj obj=list.get(i);
				obj.showElement(g);//调用每个类的自己的show方法完成自己的显示
			}
		}
		
//		Set<GameElement> set = all.keySet(); //得到所有的key集合
//		for(GameElement ge:set) { //迭代器
//			List<ElementObj> list = all.get(ge);
//			for(int i=0;i<list.size();i++) {
//				ElementObj obj=list.get(i);
//				obj.showElement(g);//调用每个类的自己的show方法完成自己的显示
//			}
//		}
		
		
		
	}
	@Override
	public void run() { //接口的实现
		while(true) {
			this.repaint();
//			一般情况下，多线程都会使用一个休眠用于控制速度
			try {
				Thread.sleep(50);//一秒刷新20次
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	
	
}
