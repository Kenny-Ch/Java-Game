package com.scnu.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.scnu.element.ElementObj;
import com.scnu.manager.ElementManager;
import com.scnu.manager.GameElement;

/**
 * @说明 监听类，用于监听用户的操作KeyListener
 * @author 12083
 *
 */
public class GameListener implements KeyListener {
	private ElementManager em =ElementManager.getManager();
	private Set<Integer> set=new HashSet<Integer>();
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	/**
	 * @说明 按下 实现主角移动 （左37 上38 右39 下40）
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		//拿到玩家集合
		int key=e.getKeyCode();
		if(set.contains(key)) {//判定集合中是否已经存在这个对象
//			如果包含了，直接结束方法
			return;
		}
		set.add(key);
		List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
		for(ElementObj obj:play) {
			obj.keyClick(true, e.getKeyCode());
		}
	}
	/**
	 * @说明 松开
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(!set.contains(e.getKeyCode())) {
			return;
		}
		set.remove(e.getKeyCode());
		
		List<ElementObj> play = em.getElementsByKey(GameElement.PLAY);
		for(ElementObj obj:play) {
			obj.keyClick(false, e.getKeyCode());
		}
		
	}

}
