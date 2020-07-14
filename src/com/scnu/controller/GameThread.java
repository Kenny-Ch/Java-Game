package com.scnu.controller;

import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import com.scnu.element.ElementObj;
import com.scnu.element.Play;
import com.scnu.manager.ElementManager;
import com.scnu.manager.GameElement;

/**
 * @说明 游戏的主线程，用于控制游戏的加载，游戏关卡，游戏运行时的自动化，游戏判定：游戏地图切换，资源释放和重新读取。
 * @author 12083
 * @继承 熟悉使用继承的方式实现多线程（一般建议使用接口实现）
 */
public class GameThread extends Thread{
	private ElementManager em;
	
	public GameThread() {
		em=ElementManager.getManager();
	}

	@Override
	public void run() {//游戏的run方法，主线程
		while(true) {

//		游戏开始前		读进度条，加载游戏资源(场景资源)
			gameLoad();
//		游戏进行时		游戏过程中
			gameRun();
//		游戏场景结束	游戏资源回收(场景资源)
			gameOver();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * @说明 游戏的加载
	 */
	private void gameLoad() {
		load();
		
	}
	/**
	 * @throws InterruptedException 
	 * @说明 游戏进行时
	 * @任务说明 游戏过程中需要做的事情：	1、自动化玩家的移动，碰撞，死亡
	 * 								2、新元素的自动添加
	 */
	private void gameRun(){
		while(true) {//预留拓展 true可以为变量，用于控制关卡结束等
			Map<GameElement, List<ElementObj>> all = em.getGameElements();
			for(GameElement ge:GameElement.values()) {
				List<ElementObj> list = all.get(ge);
				for(int i=0;i<list.size();i++) {
					ElementObj obj=list.get(i);
					obj.move();
				}
			}
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	/**
	 * @说明 游戏切换关卡
	 */
	private void gameOver() {
		// TODO 自动生成的方法存根
		
	}
	
	public void load() {//该方法为临时方法
		ImageIcon icon =new ImageIcon("image/player1_up.png");
		ElementObj obj =new Play(100,100,50,50,icon);//实例化对象
//		em.getElementsByKey(GameElement.PLAY).add(obj);//将对象放入到我们的元素管理器中
		em.addElement(obj, GameElement.PLAY);//直接添加进去
	}
}
