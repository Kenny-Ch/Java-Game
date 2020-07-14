package com.scnu.element;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Play extends ElementObj{
	/**
	 * 移动属性：
	 * 1、单属性 配合方向枚举类型使用，一次只能移动一个方向
	 * 2、双属性 上下和左右 配合boolean值使用 例如true代表上 false为下
	 *           	  还需要另外一个变量来判断是否按下方向键
	 * 	       	  约定   代表不动 1代表上 2代表下
	 * 3、四属性 上下左右都可以 boolean配合使用 true 代表移动 false不移动
	 *            	  同时按上下怎么办？后按的会重置先按的
	 * 	说明：以上3种方式是代码编写和判定方式不一样
	 * 	说明：游戏中非常多的判断，建议灵活使用判定属性：很多状态值也使用判定属性
	 * 		多状态中 可以使用map<泛型，boolean>;set<判定对象>判定对象中有时间
	 */
	private boolean left=false;
	private boolean up=false;
	private boolean right=false;
	private boolean down=false;
			
	
	public Play(int x, int y, int w, int h, ImageIcon icon) {
		super(x, y, w, h, icon);
	}
	/**
	 * 面向对象中第1个思想： 对象自己的事情自己做
	 */
	@Override
	public void showElement(Graphics g) {
		g.drawImage(this.getIcon().getImage(), 
				this.getX(), this.getY(), 
				this.getW(), this.getH(), null);
	}
	
	public void keyClick(boolean bl,int key) {
		if(bl) {
			switch(key) {
			case 37:this.left=true;break;
			case 38:this.up=true;break;
			case 39:this.right=true;break;
			case 40:this.down=true;break;
			}
		}else {
			switch(key) {
			case 37:this.left=false;break;
			case 38:this.up=false;break;
			case 39:this.right=false;break;
			case 40:this.down=false;break;
			}
		}
		
		if(this.left) {
			this.setX(this.getX()-10);
		}
		if(this.up) {
			this.setY(this.getY()-10);
		}
		if(this.right) {
			this.setX(this.getX()+10);
		}
		if(this.down) {
			this.setY(this.getY()+10);
		}
		
	}
}
