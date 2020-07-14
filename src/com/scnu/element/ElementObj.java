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
	 * @说明 方式1: 使用父类定义接收键盘事件的方法
	 * 			 只有需要键盘监听的子类，重写这个方法(约定)
	 * @说明 方式2: 使用接口方式：使用接口方式需要在监听类进行类型转换
	 * @题外话 约定 配置 现在大部分的Java框架都是需要进行配置的
	 * 		  约定优于配置
	 * @param bl 点击的类型 true代表按下 false代表松开
	 * @param key 代表触发的键盘的code值
	 * 
	 * @拓展 本方法是否可以分为两个方法 一个接收按下 一个接收松开(给同学拓展使用) //TODO
	 */
	public void keyClick(boolean bl,int key) {//不是强制必须实现的。
		
	}
	/**
	 * @说明 移动方法；需要移动的子类请实现这个方法
	 */
	public void move() {
		
	}
	
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

