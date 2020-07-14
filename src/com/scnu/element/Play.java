package com.scnu.element;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import com.scnu.manager.GameLoad;

public class Play extends ElementObj{
	/**
	 * 	移动属性：
	 * 1、单属性 配合方向枚举类型使用，一次只能移动一个方向
	 * 2、双属性 上下和左右 配合boolean值使用 例如true代表上 false为下
	 *           	  还需要另外一个变量来判断是否按下方向键
	 * 	       	  约定   代表不动 1代表上 2代表下
	 * 3、四属性 上下左右都可以 boolean配合使用 true 代表移动 false不移动
	 *            	  同时按上下怎么办？后按的会重置先按的
	 * 	说明：以上3种方式是代码编写和判定方式不一样
	 * 	说明：游戏中非常多的判断，建议灵活使用判定属性：很多状态值也使用判定属性
	 * 		多状态中 可以使用map<泛型，boolean>;set<判定对象>判定对象中有时间
	 * 
	 * @问题	1、图片要读取到内存中：加载器 临时处理方式，手动编写存储到内存中
	 * 		2、什么时候进行修改图片(因为图片是在父类中的属性存储)
	 * 		3、图片应该使用什么集合进行存储
	 */
	private boolean left=false;
	private boolean up=false;
	private boolean right=false;
	private boolean down=false;
			

//	变量专门用来记录当前主角面向的方向，默认是up
	private String fx ="up";
	
	public Play(int x, int y, int w, int h, ImageIcon icon) {
		super(x, y, w, h, icon);
		
	}
	/**
	 * 面向对象中第1个思想： 对象自己的事情自己做
	 */
	@Override
	public void showElement(Graphics g) {
//		绘画图片
		g.drawImage(this.getIcon().getImage(), 
				this.getX(), this.getY(), 
				this.getW(), this.getH(), null);
	}
	
	public void keyClick(boolean bl,int key) {
		if(bl) {
			switch(key) {
			case 37:this.left=true;this.right=false;this.up=false;this.down=false;this.fx="left";break;
			case 38:this.up=true;this.down=false;this.right=false;this.left=false;this.fx="up";break;
			case 39:this.right=true;this.left=false;this.up=false;this.down=false;this.fx="right";break;
			case 40:this.down=true;this.up=false;this.left=false;this.right=false;this.fx="down";break;
			}
		}else {
			switch(key) {
			case 37:this.left=false;break;
			case 38:this.up=false;break;
			case 39:this.right=false;break;
			case 40:this.down=false;break;
			}
		}
		

		
	}
	@Override
	public void move() {
		if (this.left&&this.getX()>0) {
			this.setX(this.getX() - 2);
		}
		if (this.up&&this.getY()>0) {
			this.setY(this.getY() - 2);
		}
		if (this.right&&this.getX()<485-this.getW()) {
			this.setX(this.getX() + 2);
		}
		if (this.down&&this.getY()<550-this.getH()) {
			this.setY(this.getY() + 2);
		}

	}
	protected void updateImage() {
		this.setIcon(GameLoad.imgMap.get(fx));
	}
}
