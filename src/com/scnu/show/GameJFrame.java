package com.scnu.show;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @说明 游戏窗体 主要实现的功能：关闭 显示 最大最小化
 * @author 12083
 * @功能说明 需要嵌入面板，启动主线程等等
 * @窗体说明 swing awt 窗体大小（记录用户上次使用软件的窗体样式——存储在本地的配置文件中）
 * @分析 1、面板绑定到窗体
 * 		 2、监听绑定
 * 		 3、游戏主线程启动
 * 		 4、显示窗体
 */
public class GameJFrame extends JFrame{
	public static int GameX=500;//一般情况下应该写成GAMEX
	public static int GameY=600;
	private JPanel jPanel=null;//正在实现的面板
	private KeyListener keyListener=null;
	private MouseMotionListener mouseMotionListener=null;
	private MouseListener mouseListener =null;
	private Thread thread=null;//游戏主线程
	
	public GameJFrame() {
		init();
	}
	public void init() {
		this.setSize(GameX, GameY);//设置窗体大小
		this.setTitle("测试游戏");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出并且关闭
		this.setLocationRelativeTo(null);//屏幕居中
	}
	/*窗体布局：可以讲存档，读档等待*/
	public void addButton() {
//		this.setLayout(manager);//布局格式，可以添加控件layout
	}
	
	/**
	 * 启动方法
	 */
	public void start() {
		if(jPanel!=null) {
			this.add(jPanel);
		}
		if(keyListener!=null) {
			this.addKeyListener(keyListener);
		}
		if(thread!=null){
			thread.start();
		}
		this.setVisible(true);//显示界面
		if(this.jPanel instanceof Runnable) {
//			已经做了类型判断，强制类型转换不出错
			new Thread((Runnable)this.jPanel).start();
		}

	}
	
	/**
	 * set注入：等大家学习ssm 通过set方法注入配置文件中读取的数据；讲配置文件中的数据赋值类的属性
	 * 构造输入：需要配合构造方法
	 * spring中
	 */
	public void setJPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
		this.mouseMotionListener = mouseMotionListener;
	}
	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
}
