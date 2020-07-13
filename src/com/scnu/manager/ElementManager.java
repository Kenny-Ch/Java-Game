package com.scnu.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scnu.element.ElementObj;

/**
 * @说明 本类是元素管理器，专门存储所有的元素，同时提供方法给予视图和控制获取数据
 * @author 12083
 * @问题一：存储所有元素数据，怎么存放？
 * @问题二：管理器是视图和控制要访问，管理器就必须只有一个
 */

public class ElementManager {
	/*
	 * String 作为key 匹配所有的元素 play->List<Object> listPlay
	 * 枚举类型：当作map的key用于区分不一样的资源，用于获取资源
	 * List中元素的泛型 应该是 元素 基类
	 * 所有的元素都可以存放到map集合中，显示模块只需要获取到这个map就可以显示所有界面需要显示的元素
	 */
	private Map<GameElement,List<ElementObj>> gameElements;
	//本方法一定不够用
	public Map<GameElement, List<ElementObj>> getGameElements() {
		return gameElements;
	}
	//添加元素（多半由加载器调用）
	public void addElement(ElementObj obj,GameElement ge){
		// List<ElementObj> list=gameElements.get(ge);
		// list.add(obj);
		gameElements.get(ge).add(obj);
	}
	//依据key返回list集合，取出某一类元素
	public List<ElementObj> getElementsByKey(GameElement ge){
		return gameElements.get(ge);
	}
	
	/**
	 *  单例模式：内存中只有一个实例。
	 *  饿汉模式-是启动就自动加载实例
	 *  饱汉模式-是需要使用的实话才加载实例
	 *  
	 *  编写方式：
	 *  1、需要提供一个静态的属性(定义一个常量)单例的引用
	 *  2、提供一个静态的方法(返回这个实例)return单例的引用
	 *  3、一般为了防止其他人自己使用（类可以是实例化）所以回私有化构造方法
	 *  	ElementManager em=new ElementManager();
	 */
	
	private static ElementManager EM=null;
	//synchronized线程锁->保证本方法中只有一个线程
	public static synchronized ElementManager getManager() {
		if(EM==null) {//空值判定
			EM=new ElementManager();
		}
		return EM;
	}
	private ElementManager() {//私有化构造方法
		init();//实例化方法
	}
	
//	static { //饿汉实例化对象 //静态语句块是在类被加载的实话直接执行
//		EM=new ElementManager();//只会执行一次
//		
//	}
	public void init() { //实例化在这里完成
		gameElements=new HashMap<GameElement,List<ElementObj>>();
		gameElements.put(GameElement.PLAY,new ArrayList<ElementObj>());
		gameElements.put(GameElement.MAPS,new ArrayList<ElementObj>());
		gameElements.put(GameElement.ENEMY,new ArrayList<ElementObj>());
		gameElements.put(GameElement.BOSS,new ArrayList<ElementObj>());
	}

}
