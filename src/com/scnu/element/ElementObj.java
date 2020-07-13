package com.scnu.element;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * @说明 所有元素的基类
 * @author 12083
 *
 */
public abstract class ElementObj {
	private int x;
	private int y;
	private int w;
	private int h;
	private ImageIcon icon;
	
	public ElementObj() {
		
	}
	/**
	 * @说明 带参数的构造方法，可以由子类传到父类
	 * @param x    左上角x坐标
	 * @param y    左上角y坐标
	 * @param w    宽度
	 * @param h    高度
	 * @param icon 图片
	 */
	public ElementObj(int x, int y, int w, int h, ImageIcon icon) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.icon = icon;
	}
	/**
	 * @说明 抽象方法 显示元素
	 * @param g 画笔 用于进行绘画
	 */
	public abstract void showElement(Graphics g);
	
	/**
	 * z只要是VO类POJO 就要为属性生成get和set方法
	 */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	
	

}
