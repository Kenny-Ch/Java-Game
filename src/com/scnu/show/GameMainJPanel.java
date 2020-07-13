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
 */
public class GameMainJPanel extends JPanel{
//联动管理器
	private ElementManager em;
	
	public GameMainJPanel() {
		init();
		//以下代码为临时测试代码
		load();
	}
	public void load() {//该方法为临时方法
		ImageIcon icon =new ImageIcon("image/player1_up.png");
		ElementObj obj =new Play(100,100,50,50,icon);//实例化对象
//		em.getElementsByKey(GameElement.PLAY).add(obj);//将对象放入到我们的元素管理器中
		em.addElement(obj, GameElement.PLAY);//直接添加进去
	}
	public void init() {
		em=ElementManager.getManager();
	}
	
	@Override //用于绘画的 Graphics 画笔 专门用于绘画
	public void paint(Graphics g) {
		super.paint(g);
		Map<GameElement, List<ElementObj>> all = em.getGameElements();
		Set<GameElement> set = all.keySet(); //得到所有的key集合
		for(GameElement ge:set) { //迭代器
			List<ElementObj> list = all.get(ge);
			for(int i=0;i<list.size();i++) {
				ElementObj obj=list.get(i);
				obj.showElement(g);//调用每个类的自己的show方法完成自己的显示
			}
		}
		
		
		
	}
	
	
}
